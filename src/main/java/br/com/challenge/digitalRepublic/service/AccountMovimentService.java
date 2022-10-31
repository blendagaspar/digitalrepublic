package br.com.challenge.digitalRepublic.service;

import br.com.challenge.digitalRepublic.DTO.AccountMovimentReturnDTO;
import br.com.challenge.digitalRepublic.entities.AccountMovement;
import br.com.challenge.digitalRepublic.response.Response;

import java.math.BigDecimal;
import java.util.List;

public interface AccountMovimentService {


    Response<AccountMovimentReturnDTO> realizarTransferencia(Integer numeroContaOrigem, Integer numeroContaDestino, int valorTransacao );


    List<AccountMovement> findAll();

}
