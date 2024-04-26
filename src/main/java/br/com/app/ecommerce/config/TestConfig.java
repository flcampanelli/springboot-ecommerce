package br.com.app.ecommerce.config;

import br.com.app.ecommerce.entities.User;
import br.com.app.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User firstUser = new User(null, "Endrick", "endrick@gmail.com", "999511999", "12345678");
        User secondUser = new User(null, "Luis Guilherme", "luis@gmail.com", "995451897", "123456");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser));
    }
}
