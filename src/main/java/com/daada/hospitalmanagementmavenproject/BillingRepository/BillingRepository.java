package com.daada.hospitalmanagementmavenproject.BillingRepository;

import com.daada.hospitalmanagementmavenproject.Billing.Billing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillingRepository extends JpaRepository<Billing,Long> {
}
