package com.nro.god.repository;

import com.nro.god.model.RechargeCard;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RechargeCardRepository extends org.springframework.data.jpa.repository.JpaRepository<com.nro.god.model.RechargeCard, java.lang.Long> {
@Query("select r from RechargeCard r where r.account.id = ?1")
RechargeCard findAllByAccountId(java.lang.Integer accountId);
@Query(value = "" +
        "SELECT * FROM recharge_card r JOIN token t\n" +
        "\tON r.account_id = t.account_id\n" +
        "\t WHERE t.CODE = ?1 \n" +
        "\tORDER BY r.Created DESC\n" +
        "\tLIMIT 5",nativeQuery = true)
    List<RechargeCard> findRechargeCardByAccountIdLimit5(String token);
    @Query(value = "SELECT * FROM recharge_card r WHERE r.status = ?1 ORDER BY recharge_card_id DESC",nativeQuery = true)
    List<RechargeCard> getByStatus(Integer status);
}
