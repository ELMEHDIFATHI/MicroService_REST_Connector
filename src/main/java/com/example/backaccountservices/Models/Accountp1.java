package com.example.backaccountservices.Models;

import com.example.backaccountservices.Enum.AccountType;
import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class ,name="p1")
public interface Accountp1 {
    public String getId();
    public AccountType getType();
    public Double getBalance();

}
