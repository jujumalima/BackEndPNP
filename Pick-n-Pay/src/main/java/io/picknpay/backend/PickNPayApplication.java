package io.picknpay.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;

import io.picknpay.backend.customer.Customer;
import io.picknpay.backend.delivery.Delivery;
import io.picknpay.backend.item.Item;
import io.picknpay.backend.payment.Payment;
import io.picknpay.backend.product.Product;
import io.picknpay.backend.aisle.Aisle;
import io.picknpay.backend.cart.Cart;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@EntityScan(basePackageClasses= {Customer.class, Aisle.class, Product.class, Item.class, Cart.class, Payment.class, Delivery.class})
public class PickNPayApplication {

	public static void main(String[] args) {
		SpringApplication.run(PickNPayApplication.class, args);
	}
}