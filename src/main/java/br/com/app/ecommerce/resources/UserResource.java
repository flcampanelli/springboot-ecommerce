package br.com.app.ecommerce.resources;

import br.com.app.ecommerce.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @GetMapping
    public ResponseEntity<User> findAll() {
        User user = new User(1L, "Endrick", "endrick@gmail.com", "999511999", "12345678");
        return ResponseEntity.ok().body(user);
    }
}
