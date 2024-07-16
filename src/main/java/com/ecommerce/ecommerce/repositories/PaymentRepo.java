package com.ecommerce.ecommerce.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.ecommerce.entites.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Long>{

}
