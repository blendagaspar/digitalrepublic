package br.com.challenge.digitalRepublic.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
public class Account {

    @Id
    private String id ;

    private Person person;

    private Integer agency;

    private Integer accountNumber;

    private Integer accountBalance;

    public Date accountCreationDate;

    public void AccountCreate(Person person, Integer agency , Integer accountNumber, Integer accountBalance, Date accountCreationDate ) {
        this.person = person;
        this.agency = agency;
        this.accountNumber = accountNumber;
        this.accountCreationDate = accountCreationDate;

    }


}
