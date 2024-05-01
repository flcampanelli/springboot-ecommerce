package br.com.app.ecommerce.repositories;

import br.com.app.ecommerce.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository - not necessary because this interface extends JpaRepository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
