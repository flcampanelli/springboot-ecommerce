package br.com.app.ecommerce.repositories;

import br.com.app.ecommerce.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
