package com.example.backaccountservices.Mappers;

import com.example.backaccountservices.DTO.BankAccountResponseDTO;
import com.example.backaccountservices.Models.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.UUID;

@Component
public class AccountMapper {

    public BankAccountResponseDTO  fromBankAccount(BankAccount bankAccount){
        BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }


}
