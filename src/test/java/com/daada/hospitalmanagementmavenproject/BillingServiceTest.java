package com.daada.hospitalmanagementmavenproject;

import com.daada.hospitalmanagementmavenproject.Billing.Billing;
import com.daada.hospitalmanagementmavenproject.BillingRepository.BillingRepository;
import com.daada.hospitalmanagementmavenproject.BillingService.BillingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static java.util.Optional.empty;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BillingServiceTest {
    @Mock
    private BillingRepository billingRepository;

    @InjectMocks
    private BillingService billingService;

    private Billing sampleBilling;

    Logger log =  LoggerFactory.getLogger(BillingServiceTest.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        sampleBilling = new Billing(1001, 1,201,"2024-05-10", 100);
    }

    @Test
    void testCreateBilling() {
        when(billingRepository.save(sampleBilling)).thenReturn(sampleBilling);

        Billing saved = billingService.createBilling(sampleBilling);

        assertEquals(sampleBilling, saved);
        verify(billingRepository).save(sampleBilling);
    }

    @Test
    void testGetBillingis_Found() {
        when(billingRepository.findById(1001L)).thenReturn(Optional.of(sampleBilling));
        Billing saved = billingService.getBillingById(1001);
        assertEquals(sampleBilling, saved);
        verify(billingRepository, times(1)).findById(1001L);
    }

    @Test
    void testGetBilling_NotFound() {
        when(billingRepository.findById(999L)).thenReturn(empty());
        Billing saved = billingService.getBillingById(999);
        log.error("Billing for the id 999 not found");
        assertNull(null);
    }

    @Test
    void testDeleteBilling() {
        doNothing().when(billingRepository).deleteById(1001L);
        billingService.deleteBillingById(1001);
        verify(billingRepository, times(1)).deleteById(1001L);
    }
}
