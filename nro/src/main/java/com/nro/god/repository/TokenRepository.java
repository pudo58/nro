package com.nro.god.repository;

import com.nro.god.model.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query("select t from Token t where t.code = ?1")
    Token findByToken(String token);
    @Query("select t from Token t where t.account.id = ?1")
    Token findByAccountId(Integer accountId);
}
