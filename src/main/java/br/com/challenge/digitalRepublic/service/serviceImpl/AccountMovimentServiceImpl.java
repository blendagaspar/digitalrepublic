package br.com.challenge.digitalRepublic.service.serviceImpl;

import br.com.challenge.digitalRepublic.DTO.AccountMovimentReturnDTO;
import br.com.challenge.digitalRepublic.Utils.MessageUtils;
import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.entities.AccountMovement;
import br.com.challenge.digitalRepublic.enums.TipoTransacao;
import br.com.challenge.digitalRepublic.repository.AccountMovimentRepository;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.response.Response;
import br.com.challenge.digitalRepublic.service.AccountMovimentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class AccountMovimentServiceImpl implements AccountMovimentService {

    @Autowired
    private AccountMovimentRepository accountMovimentRepository;

    @Autowired
    private AccountRepository accountRepository;


    @Override
    public Response<AccountMovimentReturnDTO> realizarTransferencia(Integer numeroContaOrigem,  Integer numeroDaConta, int valorTransacao) {

        Account contaOrigem = accountRepository.findByNumeroDaConta(numeroDaConta);

        if( contaOrigem == null ) {
            return new Response<AccountMovimentReturnDTO>( MessageUtils.AccountMovement.MSG_CONTA_ORIGEM_INVALIDA , HttpStatus.PRECONDITION_FAILED, null );
        }

        Account contaDestino = accountRepository.findByNumeroDaConta(  numeroDaConta );

        if( contaDestino == null ) {
            return new Response<AccountMovimentReturnDTO>( MessageUtils.AccountMovement.MSG_CONTA_DESTINO_INVALIDA , HttpStatus.PRECONDITION_FAILED, null );
        }

        if (valorTransacao <= 0 && valorTransacao >=2000 ) {

            return new Response<AccountMovimentReturnDTO>(MessageUtils.AccountMovement.MSG_VALOR_NÃO_PODE_SER_MAIOR_QUE_2000_E_MENOR_QUE_0,HttpStatus.PRECONDITION_FAILED, null );
        }



        AccountMovement movimentoContaOrigem = new AccountMovement(contaOrigem, valorTransacao, TipoTransacao.T, new Date());
        int novoSaldoOrigem = contaOrigem.getSaldo();
        contaOrigem.setSaldo( novoSaldoOrigem );


        try {

            accountMovimentRepository.save( movimentoContaOrigem );
            accountRepository.save( contaOrigem );
            accountRepository.save( contaDestino );

            AccountMovimentReturnDTO returnDTO = new AccountMovimentReturnDTO( numeroContaOrigem, novoSaldoOrigem,
                    movimentoContaOrigem.getTipoMovimento(), movimentoContaOrigem.getValorTransacao()  );

            return new Response<AccountMovimentReturnDTO>( MessageUtils.AccountMovement.MSG_TRANSFERENCIA_OK, HttpStatus.CREATED, returnDTO );

        }catch (Exception e) {
            return new Response<AccountMovimentReturnDTO>( MessageUtils.AccountMovement.MSG_ERROR_DEFAULT , HttpStatus.BAD_REQUEST, null );
        }

    }


    @Override
    public List<AccountMovement> findAll() {
        return accountMovimentRepository.findAll();
    }


}
