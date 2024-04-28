package br.com.app.ecommerce.repositories;

import br.com.app.ecommerce.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository - not necessary because this interface extends JpaRepository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
