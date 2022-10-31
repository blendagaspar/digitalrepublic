package br.com.challenge.digitalRepublic.DTO;

import br.com.challenge.digitalRepublic.Utils.MessageUtils;
import br.com.challenge.digitalRepublic.entities.AccountMovement;
import br.com.challenge.digitalRepublic.enums.TipoTransacao;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountMovimentReturnDTO {

    private Integer numeroDaConta;

    private int novoSaldoConta;

    private TipoTransacao tipoTransacao;

    private int valorTransacao;


    public AccountMovimentReturnDTO() {

    }

    public AccountMovimentReturnDTO(Integer numeroDaConta, int novoSaldo, TipoTransacao tipoTransacao, int valorTransacao) {
        this.numeroDaConta = numeroDaConta;
        this.novoSaldoConta = novoSaldo;
        this.tipoTransacao = tipoTransacao;
        this.valorTransacao = valorTransacao;
    }

    public AccountMovimentReturnDTO(AccountMovement accountMovement) {
        this.numeroDaConta = accountMovement.getAccount().getNumeroDaConta();
        this.novoSaldoConta = accountMovement.getAccount().getSaldo();
        this.tipoTransacao = accountMovement.getTipoMovimento();
        this.valorTransacao = accountMovement.getValorTransacao();
    }


}