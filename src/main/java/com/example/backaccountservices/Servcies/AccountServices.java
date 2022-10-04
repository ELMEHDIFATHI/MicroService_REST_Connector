package com.example.backaccountservices.Servcies;

import com.example.backaccountservices.DTO.BankAccountREequestDTO;
import com.example.backaccountservices.DTO.BankAccountResponseDTO;
import com.example.backaccountservices.Models.BankAccount;

public interface AccountServices {

    public BankAccountResponseDTO addAccount(BankAccountREequestDTO bankAccountDTO);
}
