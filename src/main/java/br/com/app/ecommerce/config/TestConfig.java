package br.com.app.ecommerce.config;

import br.com.app.ecommerce.entities.Category;
import br.com.app.ecommerce.entities.Order;
import br.com.app.ecommerce.entities.User;
import br.com.app.ecommerce.entities.enums.OrderStatus;
import br.com.app.ecommerce.repositories.CategoryRepository;
import br.com.app.ecommerce.repositories.OrderRepository;
import br.com.app.ecommerce.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String... args) throws Exception {
        Category firstCategory = new Category(null, "Eletronics");
        Category secondCategory = new Category(null, "Musics");
        Category thirdCategory = new Category(null, "Sports");
        categoryRepository.saveAll(Arrays.asList(firstCategory, secondCategory, thirdCategory));

        User firstUser = new User(null, "Endrick", "endrick@gmail.com", "999511999", "12345678");
        User secondUser = new User(null, "Luis Guilherme", "luis@gmail.com", "995451897", "123456");
        userRepository.saveAll(Arrays.asList(firstUser, secondUser));

        Order firstOrder = new Order(null, Instant.parse("2024-03-20T19:53:07Z"), OrderStatus.PAID, firstUser);
        Order secondOrder = new Order(null, Instant.parse("2024-04-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, secondUser);
        Order thirdOrder = new Order(null, Instant.parse("2024-04-27T15:21:22Z"), OrderStatus.WAITING_PAYMENT, firstUser);
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));
    }
}
