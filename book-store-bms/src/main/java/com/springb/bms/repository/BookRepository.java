package com.springb.bms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springb.bms.Entity.BookEntity;

@Repository
public interface BookRepository extends JpaRepository<BookEntity,Integer> {

}
