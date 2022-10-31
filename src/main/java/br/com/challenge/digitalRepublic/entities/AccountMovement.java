package br.com.challenge.digitalRepublic.entities;

import br.com.challenge.digitalRepublic.enums.TipoTransacao;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Document( collection = "movimento_conta" )
public class AccountMovement {

    @Id
    private String id;

    private TipoTransacao tipoMovimento;

    private Date dataTransacao;

    private int valorTransacao;

    @DBRef
    private Account account;



    public AccountMovement() {
    }


    public  AccountMovement(Account account, int valorTransacao, TipoTransacao tipoTransacao, Date dataTransacao ) {
        this.account = account;
        this.dataTransacao = dataTransacao;
        this.tipoMovimento = tipoTransacao;
        this.valorTransacao = valorTransacao;
    }











}
