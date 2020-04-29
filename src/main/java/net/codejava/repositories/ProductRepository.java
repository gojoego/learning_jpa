package net.codejava.repositories;

import net.codejava.repositories.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

// repo does direct integration with database

public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findByMadein(String madein);

    public List<Product> findByPriceGreaterThan(float price);

    public Product findByName(String name);

    public List<Product> findByNameNot(String name);

    public void deleteByName(String name);
}
