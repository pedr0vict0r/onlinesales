package br.edu.xpe.onlinesales.service;

import br.edu.xpe.onlinesales.model.Customer;
import br.edu.xpe.onlinesales.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;

	@Autowired
	public CustomerService(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	public Customer createCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

	public List<Customer> findAllCustomers() {
		return customerRepository.findAll();
	}

	public Customer findCustomerById(Long id) {
		return customerRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	public List<Customer> findCustomerByName(String name) {
		return customerRepository.findByName(name);
	}

	public Customer updateCustomer(Long id, Customer updatedCustomer) {
		return customerRepository.findById(id).map(existingCustomer -> {
			existingCustomer.setName(updatedCustomer.getName());
			existingCustomer.setEmail(updatedCustomer.getEmail());
			return customerRepository.save(existingCustomer);
		}).orElseThrow(() -> new RuntimeException("Customer not found"));
	}

	public boolean deleteCustomer(Long id) {
		return customerRepository.findById(id).map(customer -> {
			customerRepository.delete(customer);
			return true;
		}).orElse(false);
	}

	public long countCustomers() {
		return customerRepository.count();
	}

}
