package br.edu.xpe.onlinesales.repository;

import br.edu.xpe.onlinesales.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	List<Customer> findByName(String name);

}
