package br.com.challenge.digitalRepublic.enums;

import lombok.Getter;

public enum TipoTransacao {

    R("Retirada"),
    D("Deposito"),
    T("Transferência");

    @Getter
    private String descricao;

    private TipoTransacao( String descricao ) {
        this.descricao = descricao;
    }

}
