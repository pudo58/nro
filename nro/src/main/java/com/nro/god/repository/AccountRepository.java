package com.nro.god.repository;

import com.nro.god.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query("select a from Account a where a.username = ?1")
     Account findByUsername(String username);
    @Query("select a from Account a where a.username = ?1 and a.password = ?2")
     Account findByUsernameAndPassword(String username, String password);
    @Query(value = "SELECT * FROM ACCOUNT a WHERE a.username like %?1% ",nativeQuery = true)
    List<Account> findByUsernameEquals(String username);
}
