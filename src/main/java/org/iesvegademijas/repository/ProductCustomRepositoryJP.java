package org.iesvegademijas.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvegademijas.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class ProductCustomRepositoryJP implements ProductCustomRepository{
    @Autowired
    EntityManager em;

    @Override
    public List<Product> QueryCustom(Optional<String> buscar, Optional<String> ordenar){
        StringBuilder query = new StringBuilder(("Select P from Product P"));

        if(buscar.isPresent()){
            query.append(" ").append("where P.name like :name");
        }
        if (ordenar.isPresent()){
            if(buscar.isPresent() && "asc".equalsIgnoreCase(ordenar.get())){
                query.append(" ").append("ORDER BY P.name ASC");
            }else if (buscar.isPresent() && "desc".equalsIgnoreCase(ordenar.get())){
                query.append(" ").append("ORDER BY P.name DESC");
            }
        }

        Query quer = em.createQuery(query.toString());
        if(buscar.isPresent()){
            quer.setParameter("name", "%"+buscar.get()+"%");
        }
        return quer.getResultList();
    }
}
