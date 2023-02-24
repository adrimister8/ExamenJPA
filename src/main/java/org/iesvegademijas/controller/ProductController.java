package org.iesvegademijas.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvegademijas.domain.Product;
import org.iesvegademijas.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = {"","/"}, params = {"!buscar", "!ordenar"})
    public List<Product> all() {
        log.info("Accediendo a todas las películas");
        return this.productService.all();
    }

    @GetMapping({"","/"})
    public List<Product> all(@RequestParam("buscar") Optional<String> buscarOptional, @RequestParam("ordenar") Optional<String> ordenarOptional) {

        return this.productService.listaOrdenada(buscarOptional, ordenarOptional);
    }

    @PostMapping({"","/"})
    public Product newPelicula(@RequestBody Product product) {
        return this.productService.save(product);
    }

    @GetMapping("/{id}")
    public Optional<Product> one(@PathVariable("id") Long id) {
        return this.productService.one(id);
    }

    @PutMapping("/{id}")
    public Optional<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return this.productService.replace(id, product);
    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {
        this.productService.delete(id);
    }

}
