package com.example.demo.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.User;
import com.example.demo.Services.Paymentservice;

@RestController
@RequestMapping("/api/auth")
public class PaymentController {
	  
	@Autowired 
	private Paymentservice paymentservice;
	
	@PreAuthorize("hasRole('ROLE_READER')")
	@PostMapping("/buybook")
	public String payfornewwbook(@RequestBody Payment payment)
	{
		paymentservice.savepayment(payment);
		return "Payment succesfull";
	}
	
	@PreAuthorize("hasRole('ROLE_READER')")
	@GetMapping("purchasedbook/{email}")
	@ResponseBody
	public ResponseEntity getallbooksbymail(@PathVariable("email") String email)
	{
		Optional<User> optional=paymentservice.getByemail(email);
		User user=optional.get();
		Boolean isReaderpurchased=paymentservice.isPaymentAvailableByReader(user.getId());
		if(isReaderpurchased)
		{
			
		}
		Map<String, Set<Long>> bookList=paymentservice.getBookId(user.getId());
		ResponseEntity responseEntity=new ResponseEntity(bookList,HttpStatus.OK);
		
		return responseEntity;
	}
	
	

}
