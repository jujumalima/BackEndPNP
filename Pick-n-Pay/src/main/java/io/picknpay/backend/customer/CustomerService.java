package io.picknpay.backend.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;
	
	public List<Customer> getAllCustomers() {
		return customerRepository.findAll();
	}

	public void addCustomer(Customer customer) {
		customerRepository.save(customer);	
	}

	public Customer getCustomer(int id) {
		return customerRepository.findById(id);
	}

	public Customer getCustLogin(String email, String password) {
		List<Customer> list = customerRepository.findAll();
		Customer logIn = null;
		for (int i = 0; i < list.size(); i++) {
			if (email.equals(list.get(i).getEmail()) && password.equals(list.get(i).getPassword())) {
				logIn =  list.get(i);
				break;
			}
		}
		return logIn;
	}

	public void deleteAllCustomers() {
		customerRepository.deleteAll();
	}

	public void updateCustomer(long id, Customer customer) {
		customerRepository.saveAndFlush(customer);
	}

	public void deleteCustomer(Customer customer) {
		customerRepository.delete(customer);
	}
	
	public String forgetPassword(String email) {
		List<Customer> list = customerRepository.findAll();
		String passwrd = "";
		for (int i = 0; i < list.size(); i++) {
			if (email.equals(list.get(i).getEmail())) {
				passwrd = list.get(i).getPassword();
				break;
			}
		}
		return passwrd;
	}
}