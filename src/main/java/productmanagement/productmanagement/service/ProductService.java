package productmanagement.productmanagement.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import productmanagement.productmanagement.entity.Product;
import productmanagement.productmanagement.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {


    @Autowired
    private ProductRepository repository;



    public Product saveProduct(Product product) {
        return repository.save(product);
    }

    public List<Product> saveProducts(List<Product> products) {
        return repository.saveAll(products);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }


    public Product getProductById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Product getProductByByName(int id) {
        return  repository.findById(id).orElse(null);
    }

    public String deleteProduct (int id) {
        repository.deleteById(id);
        return "product deleted!!" + id;
    }

    public Product updateProduct(Product product) {
        Product existingProduct = repository.findById(product.getId()).orElse(null);
        assert existingProduct != null;
        existingProduct.setName(product.getName());
        existingProduct.setQuantity(product.getQuantity());
        existingProduct.setPrice(product.getPrice());
        return repository.save(existingProduct);
    }
}
