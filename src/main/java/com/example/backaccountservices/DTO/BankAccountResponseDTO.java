package com.example.backaccountservices.DTO;

import com.example.backaccountservices.Enum.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankAccountResponseDTO {

    private String id;

    private Date createdAt;
    private Double balance;
    private String currency;

    private AccountType type;
}
