package com.example.backaccountservices.DTO;

import com.example.backaccountservices.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BankAccountREequestDTO {


    private Double balance;
    private String currency;
    private AccountType type;
}
