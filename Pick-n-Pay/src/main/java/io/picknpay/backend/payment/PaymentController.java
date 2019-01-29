
package io.picknpay.backend.payment;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.picknpay.backend.email.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {

	@Autowired
	private PaymentService paymentService;
	
	@Autowired EmailService emailService;
	
	@GetMapping("/payment")
	public List<Payment> getPayments() {
		return paymentService.getAllPayments();
	}
	
	@PostMapping(value="/payment")
	public void addPayment(@RequestBody Payment payment) {
		paymentService.addPayment(payment);
	}
	
	@GetMapping("/payment/{id}")
	public Payment getPayment(@PathVariable int id) {
		return paymentService.getPayment(id);
	}
	
	@DeleteMapping(value="/payment/{id}")
	public void deletePayment(@PathVariable int id) {
		Payment payment = paymentService.getPayment(id);
		paymentService.deletePayment(payment);
	}
	
	@GetMapping("/payment/proof/{email}/{message}")
	public void forgetPassword(@PathVariable String email, @PathVariable String message) {
				
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Pick n Pay, Proof of Purchase");
		mail.setText(message);
		mail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(mail);
	}
}
