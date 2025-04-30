package br.edu.xpe.onlinesales.service;

import br.edu.xpe.onlinesales.model.Order;
import br.edu.xpe.onlinesales.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public Order createOrder(Order order) {
		return orderRepository.save(order);
	}

	public List<Order> findAllOrders() {
		return orderRepository.findAll();
	}

	public Order findOrderById(Long id) {
		return orderRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Order not found"));
	}

	public List<Order> findOrderByCustomerId(Long customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	public Order updateOrder(Long id, Order updatedOrder) {
		return orderRepository.findById(id).map(existingOrder -> {
			existingOrder.setCustomer(updatedOrder.getCustomer());
			existingOrder.setProduct(updatedOrder.getProduct());
			existingOrder.setQuantity(updatedOrder.getQuantity());
			existingOrder.setOrderDate(updatedOrder.getOrderDate());
			return orderRepository.save(existingOrder);
		}).orElseThrow(() -> new RuntimeException("Order not found"));
	}

	public boolean deleteOrder(Long id) {
		return orderRepository.findById(id).map(order -> {
			orderRepository.delete(order);
			return true;
		}).orElse(false);
	}

	public long countOrders() {
		return orderRepository.count();
	}

}
