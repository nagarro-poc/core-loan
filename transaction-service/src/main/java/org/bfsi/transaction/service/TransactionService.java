package org.bfsi.transaction.service;

import org.bfsi.transaction.entity.TransactionEntity;
import org.bfsi.transaction.model.TransactionDTO;
import org.springframework.stereotype.Service;

@Service
public interface TransactionService {
    public TransactionEntity credit(TransactionDTO transactionDTO);

    public TransactionEntity debit(TransactionDTO transactionDTO);
}
