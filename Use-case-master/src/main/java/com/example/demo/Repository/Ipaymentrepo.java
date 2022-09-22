package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.Entity.Payment;

public interface Ipaymentrepo extends JpaRepository<Payment, Long> {
	Boolean existsByReaderId (Long readerId);
	List<Payment> findAllByreaderId(Long readerId);
	Payment findByPaymentId(Long paymentId);
	
	

}
