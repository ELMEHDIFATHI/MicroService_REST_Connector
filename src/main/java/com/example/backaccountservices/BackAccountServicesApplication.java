package com.example.backaccountservices;

import com.example.backaccountservices.Enum.AccountType;
import com.example.backaccountservices.Models.BankAccount;
import com.example.backaccountservices.Repositorie.BankAccountRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class BackAccountServicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackAccountServicesApplication.class, args);
    }

    @Bean
    CommandLineRunner start(BankAccountRepo bankAccountRepo){
        return  t->{
            for (int i=0;i<10;i++){
                BankAccount b=new BankAccount().builder()
                        .id(UUID.randomUUID().toString())
                        .type(Math.random()>0.5? AccountType.SAVING_ACCOUNT:AccountType.CURRENT_ACCOUNT)
                        .balance(1000*Math.random()*5)
                        .createdAt(new Date())
                        .currency("MAD")
                        .build();

                bankAccountRepo.save(b);
            }

        };

    }

}
