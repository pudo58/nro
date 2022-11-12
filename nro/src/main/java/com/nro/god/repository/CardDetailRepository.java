package com.nro.god.repository;

import com.nro.god.model.CardDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CardDetailRepository extends JpaRepository<CardDetail, Integer> {
    @Query(value = "select c from CardDetail c where c.card.name = ?1")
    List<CardDetail> findByCardName(String id);
}
