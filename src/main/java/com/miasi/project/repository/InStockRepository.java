package com.miasi.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.Optional;

@NoRepositoryBean
public interface InStockRepository<T> extends JpaRepository<T, Integer> {

    Optional<T> findByIdAndInStockIsTrue(int id);
    boolean existsByIdAndAndInStockIsTrue(int id);

}
