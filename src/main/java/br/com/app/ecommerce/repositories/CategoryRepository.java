package br.com.app.ecommerce.repositories;

import br.com.app.ecommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

// @Repository - not necessary because this interface extends JpaRepository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
