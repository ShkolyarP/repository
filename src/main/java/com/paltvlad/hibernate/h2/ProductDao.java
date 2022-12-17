package com.paltvlad.hibernate.h2;

import java.util.List;
import java.util.Optional;

public interface ProductDao {
    Optional<Product> findById(Long id);
    Optional<Product> findByTitle(String title);
    List<Product>findAll();

    void SaveOrUpdate(Product product);
    void deleteById(Long id);

}
