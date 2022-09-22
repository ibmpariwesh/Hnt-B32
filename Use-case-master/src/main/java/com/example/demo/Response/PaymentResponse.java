package com.example.demo.Response;

public class PaymentResponse {

	private Long paymentId;
	private Long bookID;
	private Long price;
	private String paymentDate;
	public Long getPaymentId() { 
		return paymentId; 
	}
	public void setPaymentId(Long paymentId) {
		this.paymentId = paymentId;
	}
	public Long getBookID() { 
		return bookID;
	}
	public void setBookID(Long bookID) {
		this.bookID = bookID;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	
}
