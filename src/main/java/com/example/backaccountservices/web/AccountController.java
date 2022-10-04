package com.example.backaccountservices.web;

import com.example.backaccountservices.DTO.BankAccountREequestDTO;
import com.example.backaccountservices.DTO.BankAccountResponseDTO;
import com.example.backaccountservices.Mappers.AccountMapper;
import com.example.backaccountservices.Models.BankAccount;
import com.example.backaccountservices.Repositorie.BankAccountRepo;
import com.example.backaccountservices.Servcies.AccountServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
public class AccountController {
    @Autowired
    private BankAccountRepo bankAccountRepo;
    @Autowired
    private AccountServices accountServices;
    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/bankAccounts")
    public List<BankAccount>  bankAccounts(){
        return bankAccountRepo.findAll();
    }

    @GetMapping("/bankAccounts/{id}")
    public BankAccount bankAccount(@PathVariable String id){
        return bankAccountRepo.findById(id)
                               .orElseThrow(()->new RuntimeException(String .format("Account %s not found",id)));
    }
    /*

    @PutMapping("/bankAccounts")
    public BankAccount save(@RequestBody BankAccount bankAccount){
        bankAccount.setId(UUID.randomUUID().toString());
        return bankAccountRepo.save(bankAccount);
    }
    */


    @PostMapping("/bankAccounts")
    public BankAccountResponseDTO saveDTO(@RequestBody BankAccountREequestDTO requestDto){

        return accountServices.addAccount(requestDto);
    }

    @PutMapping("/bankAccounts/{id}")
    public BankAccount update(@PathVariable String id,@RequestBody BankAccount bankAccount){
        BankAccount bankAccount1=bankAccountRepo.
                 findById(id)
                .orElseThrow(()->new RuntimeException(String .format("Account %s not found",id)));
                if(bankAccount.getBalance()!=null) bankAccount1.setBalance(bankAccount.getBalance());
                if(bankAccount.getBalance()!=null) bankAccount1.setCreatedAt(new Date());
                if(bankAccount.getBalance()!=null) bankAccount1.setType(bankAccount.getType());
                if(bankAccount.getBalance()!=null) bankAccount1.setCurrency(bankAccount.getCurrency());
        return bankAccountRepo.save(bankAccount);
    }

    @DeleteMapping ("/bankAccounts/{id}")
    public void deleteAccount(@PathVariable String id) {
        bankAccountRepo.deleteById(id);
    }




}
