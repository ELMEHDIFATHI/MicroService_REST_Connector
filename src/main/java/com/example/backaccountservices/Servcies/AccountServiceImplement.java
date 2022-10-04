package com.example.backaccountservices.Servcies;

import com.example.backaccountservices.DTO.BankAccountREequestDTO;
import com.example.backaccountservices.DTO.BankAccountResponseDTO;
import com.example.backaccountservices.Mappers.AccountMapper;
import com.example.backaccountservices.Models.BankAccount;
import com.example.backaccountservices.Repositorie.BankAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;


@Service
@Transactional
public class AccountServiceImplement implements AccountServices{

    @Autowired
    private BankAccountRepo bn;
    @Autowired
    private AccountMapper accountMapper;
    @Override
    public BankAccountResponseDTO addAccount(BankAccountREequestDTO bankAccountDTO) {



        BankAccount bankAccount=BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();

       BankAccount savebank= bn.save(bankAccount);
/*
       BankAccountResponseDTO bankAccountResponseDTO=BankAccountResponseDTO
               .builder()
               .id(savebank.getId())
               .type(savebank.getType())
               .createdAt(savebank.getCreatedAt())
               .currency(savebank.getCurrency())
               .balance(savebank.getBalance())
               .build();
               */
  BankAccountResponseDTO bankAccountResponseDTO=  accountMapper.fromBankAccount(savebank);

       return bankAccountResponseDTO;
    }
}
