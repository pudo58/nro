package com.nro.god.repository;

import com.nro.god.model.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card, Integer> {
    @Query(value = "SELECT DISTINCT NAME FROM Card",nativeQuery = true)
    String[] findDistinctName();
}
