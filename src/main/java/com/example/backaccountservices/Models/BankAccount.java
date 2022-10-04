package com.example.backaccountservices.Models;

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

@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @Builder

public class BankAccount {


    @Id
    private String id;

    private Date createdAt;
    private Double balance;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;


}
