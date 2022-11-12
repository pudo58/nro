package com.nro.god.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends org.springframework.data.jpa.repository.JpaRepository<com.nro.god.model.Comment, java.lang.Long> {

}
