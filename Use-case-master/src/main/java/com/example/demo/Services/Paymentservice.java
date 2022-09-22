package com.example.demo.Services;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Payment;
import com.example.demo.Entity.User;
import com.example.demo.Repository.Ipaymentrepo;
import com.example.demo.Repository.UserRepository;

@Service
public class Paymentservice {  
	 
	@Autowired
	private Ipaymentrepo paymentrepo;
	@Autowired
	private UserRepository userrepo;
	
	public void savepayment(Payment pay)
	{
		paymentrepo.save(pay);
	}
	public Optional<User> getByemail(String email)
	{
		return userrepo.findByemail(email);
	}

	public Boolean isPaymentAvailableByReader(Long readerId)
	{
		Boolean paymentAvailable=paymentrepo.existsByReaderId(readerId);
		return paymentAvailable;
	}
	public Map<String, Set<Long>> getBookId(Long readerid)
	{
		List<Payment> paymentList=paymentrepo.findAllByreaderId(readerid);
		Set<Long> bookIdList=new HashSet<Long>();
		Map<String, Set<Long>> map=new HashMap<String, Set<Long>>();
		paymentList.forEach(payment->{
			bookIdList.add(payment.getBookID());
		});
		map.put("bookID", bookIdList);
		return map;
	}
	
	

}
