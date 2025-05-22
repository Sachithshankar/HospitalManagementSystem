package com.daada.hospitalmanagementmavenproject.BillingService;

import com.daada.hospitalmanagementmavenproject.Billing.Billing;
import com.daada.hospitalmanagementmavenproject.BillingRepository.BillingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class BillingService {

    final BillingRepository billingRepository;
    private static final Logger log = LoggerFactory.getLogger(BillingService.class);

    public BillingService(BillingRepository billingRepository) {
        this.billingRepository = billingRepository;
    }

    public List<Billing> getAllBilling() {
        log.info("Getting all billings");
        return billingRepository.findAll();
    }

    public Billing getBillingById(int billing_id) {
        log.info("Getting billing with id {}", billing_id);
        return billingRepository.findById((long) billing_id).orElse(null);
    }

    public Billing createBilling(@RequestBody Billing billing) {
        log.info("Creating billing ");
        return billingRepository.save(billing);
    }

    public void deleteBillingById(int billing_id) {
        log.warn("Deleting billing with id {}", billing_id);
        billingRepository.deleteById((long) billing_id);
    }
}
