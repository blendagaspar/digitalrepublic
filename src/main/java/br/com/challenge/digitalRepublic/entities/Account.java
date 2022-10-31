package br.com.challenge.digitalRepublic.entities;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Document
@Data
public class Account {

    @Id
    private String id ;

    private String nomeCompleto;

    private String cpf;

    private Integer agencia;

    private Integer numeroDaConta;

    private int saldo;

    public Date dataDeCriacaoDaConta;

    public Account( String cpf , String nomeCompleto ) {
        this.nomeCompleto= nomeCompleto;
        this.cpf = cpf;

    }


}
