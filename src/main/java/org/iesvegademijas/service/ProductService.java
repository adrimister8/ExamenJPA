package org.iesvegademijas.service;

import org.iesvegademijas.domain.Product;
import org.iesvegademijas.repository.ProductCustomRepository;
import org.iesvegademijas.repository.ProductRepository;
import org.springframework.stereotype.Service;

import javax.management.Query;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductCustomRepository productCustomRepository;

    public ProductService(ProductRepository productRepository, ProductCustomRepository productCustomRepository) {
        this.productRepository = productRepository;
        this.productCustomRepository = productCustomRepository;
    }

    public List<Product> all() {
        return this.productRepository.findAll();
    }

    public List<Product> listaOrdenada(Optional<String> buscar, Optional<String> ordenar){
        return this.productCustomRepository.QueryCustom(buscar, ordenar);
    }

    public Product save(Product product) {
        return this.productRepository.save(product);
    }

    public Optional<Product> one(Long id) {
        return this.productRepository.findById(id);
    }

    public Optional<Product> replace(Long id, Product product) {

        return this.productRepository.findById(id).map( p -> (id.equals(product.getId())  ?
                        this.productRepository.save(product) : null));

    }

    public void delete(Long id) {
        this.productRepository.findById(id).map(p -> {this.productRepository.delete(p);
                    return p;});
    }


}
