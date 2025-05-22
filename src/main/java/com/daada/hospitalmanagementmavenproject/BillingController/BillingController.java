package com.daada.hospitalmanagementmavenproject.BillingController;

import com.daada.hospitalmanagementmavenproject.Billing.Billing;
import com.daada.hospitalmanagementmavenproject.BillingService.BillingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/billing")
public class BillingController {
    @Autowired
    private BillingService billingService;
    private static final Logger log = LoggerFactory.getLogger(BillingController.class);

   @GetMapping
    public List<Billing> getAllBillings() {
       return billingService.getAllBilling();
   }

   @GetMapping("/{billing_id}")
    public Billing getBillingById(@PathVariable int billing_id) {
       log.info("Getting with the billing id {}", billing_id);
       return billingService.getBillingById(billing_id);
   }

   @PostMapping
    public Billing createBilling(@RequestBody Billing billing) {
       return billingService.createBilling(billing);
   }

   @DeleteMapping("/{billing_id}")
    public void deleteBillingById(@PathVariable int billing_id) {
       log.warn("Deleting billing with id {}", billing_id);
       billingService.deleteBillingById(billing_id);
   }


}
