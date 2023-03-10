package org.iesvegademijas.repository;

import org.iesvegademijas.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductCustomRepository{

    List<Product> QueryCustom (Optional<String> buscar, Optional<String> ordenar);
}
