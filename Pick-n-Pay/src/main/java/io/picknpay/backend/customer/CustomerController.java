package io.picknpay.backend.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.picknpay.backend.email.EmailService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private EmailService emailService;
	
	@GetMapping("/")
	public String sayHello() {
		return "Hello";
	}
	
	@GetMapping("/customers")
	public List<Customer> getAllCustomers() {
		return customerService.getAllCustomers();
	}
	
	@PostMapping(value="/customers")
	public void addCustomer(@RequestBody Customer customer) {
		customerService.addCustomer(customer);
	}
	
	@GetMapping("/customers/{id}")
	public Customer getCustomer(@PathVariable int id) {
		return customerService.getCustomer(id);
	}
	
	@GetMapping("/customers/login/{email}/{password}")
	public Customer getCustomerByEmail(@PathVariable String email, @PathVariable String password) {
		return customerService.getCustLogin(email, password);
	}
	
	@DeleteMapping("/customers")
	public void deleteAllCustomers() {
		customerService.deleteAllCustomers();
	}
	
	@PutMapping(value="/customers/{id}")
	public void updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
		Customer c = customerService.getCustomer(id);
		c.setName(customer.getName());
		c.setSurname(customer.getSurname());
		c.setEmail(customer.getEmail());
		c.setPassword(customer.getPassword());
		customerService.updateCustomer(id, c);
	}
		
	@DeleteMapping(value="/customers/{id}")
	public void deleteCustomer(@PathVariable int id) {
		Customer customer = customerService.getCustomer(id);
		customerService.deleteCustomer(customer);
	}
	
	@GetMapping("/resetPassword")
	public void resetPassword(/*@RequestBody Customer customer*/) {
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo("avhashoninetshiozwi@gmail.com");
		mail.setSubject("Forget password");
		mail.setText("HA!");
		mail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(mail);
	}
	
	@GetMapping("/customers/resetPassword/{email}")
	public void forgetPassword(@PathVariable String email) {
		String password = customerService.forgetPassword(email);
		
		SimpleMailMessage mail = new SimpleMailMessage();
		mail.setTo(email);
		mail.setSubject("Pick n Pay, Forget password");
		mail.setText("It appears that you forgot your password. \nYour password is: " + password);
		mail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(mail);
	}
}
