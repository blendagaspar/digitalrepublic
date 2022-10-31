package br.com.challenge.digitalRepublic.entities;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Person {


    private String accountOwner;

    private String cpf;

}
