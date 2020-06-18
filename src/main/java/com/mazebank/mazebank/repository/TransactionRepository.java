package com.mazebank.mazebank.repository;

import com.mazebank.mazebank.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Long> {

    List<Transaction> findAllByTransactionDateBetween(Date startDate,Date endDate);
}
