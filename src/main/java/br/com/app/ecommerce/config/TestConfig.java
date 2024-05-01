package br.com.app.ecommerce.config;

import br.com.app.ecommerce.entities.*;
import br.com.app.ecommerce.entities.enums.OrderStatus;
import br.com.app.ecommerce.repositories.*;
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
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public void run(String... args) throws Exception {
        Category electronicsCategory = new Category(null, "Electronics");
        Category booksCategory = new Category(null, "Books");
        Category computersCategory = new Category(null, "Computers");
        categoryRepository.saveAll(Arrays.asList(electronicsCategory, booksCategory, computersCategory));

        Product lordOfTheRingsProduct = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
        Product smartTVProduct = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
        Product macbookProProduct = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
        Product pcGamerProduct = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
        Product railsForDummiesProduct = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
        productRepository.saveAll(Arrays.asList(lordOfTheRingsProduct, smartTVProduct, macbookProProduct, pcGamerProduct, railsForDummiesProduct));

        lordOfTheRingsProduct.getCategories().add(booksCategory);
        smartTVProduct.getCategories().add(electronicsCategory);
        smartTVProduct.getCategories().add(computersCategory);
        macbookProProduct.getCategories().add(computersCategory);
        pcGamerProduct.getCategories().add(computersCategory);
        railsForDummiesProduct.getCategories().add(booksCategory);
        productRepository.saveAll(Arrays.asList(lordOfTheRingsProduct, smartTVProduct, macbookProProduct, pcGamerProduct, railsForDummiesProduct));

        User endrickUser = new User(null, "Endrick", "endrick@gmail.com", "999511999", "12345678");
        User luisGuilhermeUser = new User(null, "Luis Guilherme", "luis@gmail.com", "995451897", "123456");
        userRepository.saveAll(Arrays.asList(endrickUser, luisGuilhermeUser));

        Order firstOrder = new Order(null, Instant.parse("2024-03-20T19:53:07Z"), OrderStatus.PAID, endrickUser);
        Order secondOrder = new Order(null, Instant.parse("2024-04-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, luisGuilhermeUser);
        Order thirdOrder = new Order(null, Instant.parse("2024-04-27T15:21:22Z"), OrderStatus.WAITING_PAYMENT, endrickUser);
        orderRepository.saveAll(Arrays.asList(firstOrder, secondOrder, thirdOrder));

        OrderItem firstOrderItem = new OrderItem(firstOrder, lordOfTheRingsProduct, 2, lordOfTheRingsProduct.getPrice());
        OrderItem secondOrderItem = new OrderItem(firstOrder, macbookProProduct, 1, macbookProProduct.getPrice());
        OrderItem thirdOrderItem = new OrderItem(secondOrder, macbookProProduct, 2, macbookProProduct.getPrice());
        OrderItem fourthOrderItem = new OrderItem(thirdOrder, railsForDummiesProduct, 2, railsForDummiesProduct.getPrice());
        orderItemRepository.saveAll(Arrays.asList(firstOrderItem, secondOrderItem, thirdOrderItem, fourthOrderItem));
    }
}
