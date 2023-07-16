package productmanagement.productmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import productmanagement.productmanagement.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    Product findByName(String name);
}
