package io.picknpay.backend.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	public List<Payment> getAllPayments() {
		return paymentRepository.findAll();
	}
	
	public void addPayment(Payment payment) {
		paymentRepository.save(payment);
	}
	
	public Payment getPayment(int id) {
		return paymentRepository.findById(id);
	}
	
	public void deletePayment(Payment payment) {
		paymentRepository.delete(payment);
	}
}
