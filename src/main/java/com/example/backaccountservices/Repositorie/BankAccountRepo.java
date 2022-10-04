package com.example.backaccountservices.Repositorie;

import com.example.backaccountservices.Enum.AccountType;
import com.example.backaccountservices.Models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource
public interface BankAccountRepo extends JpaRepository<BankAccount,String> {
       @RestResource(path = "/bytype")
        List<BankAccount> findByType(@Param("t") AccountType type);
}
