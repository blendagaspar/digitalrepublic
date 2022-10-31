package br.com.challenge.digitalRepublic.DTO;

import com.mongodb.lang.NonNull;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class AccountMovimentDTO {

    @NonNull
    @ApiModelProperty( value = "Número da conta de origem" )
    private Integer numeroContaOrigem;

    @ApiModelProperty( value = "Número da conta de destino - Obrigatório somente para transferência" )
    private Integer numeroContaDestino;

    @NonNull
    @ApiModelProperty( value = "Valor da transação" )
    private BigDecimal valorTransacao;
}
