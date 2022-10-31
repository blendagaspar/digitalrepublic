package br.com.challenge.digitalRepublic.service.serviceImpl;


import br.com.challenge.digitalRepublic.Utils.MessageUtils;
import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;

import org.springframework.util.StringUtils;
import br.com.challenge.digitalRepublic.response.Response;


import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {


     @Autowired
     AccountRepository accountRepository;


     @Override
     public List<Account> findAll() {

          return accountRepository.findAll();
     }

     @Override
     public String findById(String id) {

          return  id;
     }



     @Override
     public Response<Account> abrirConta(Account account){

          if( StringUtils.isEmpty( account.getCpf() ) || StringUtils.isEmpty( account.getNomeCompleto() ) ) {
               return new Response<Account>(MessageUtils.Account.MSG_CPF_NOME_OBRIGATORIO, HttpStatus.PRECONDITION_FAILED, null );
          }

          Boolean existConta = accountRepository.existsByCpf( account.getCpf() );

          if( existConta ) {
               return new Response<Account>( MessageUtils.Account.MSG_CPF_REPETIDO, HttpStatus.PRECONDITION_FAILED, null);
          }

          account.setNumeroDaConta(account.getNumeroDaConta());
          account.setDataDeCriacaoDaConta(new Date());

          try {

               Optional<Account> contaOk = Optional.ofNullable( accountRepository.save(account) );
               if( contaOk.isPresent() ) {
                    return new Response<Account>( MessageUtils.Account.MSG_CADASTRO_SUCESSO, HttpStatus.CREATED, contaOk.get() );
               }
               else {
                    return new Response<Account>( MessageUtils.Account.MSG_ERROR_DEFAULT, HttpStatus.BAD_REQUEST, null );
               }

          }catch (Exception e) {
               return new Response<Account>(MessageUtils.Account.MSG_ERROR_DEFAULT , HttpStatus.BAD_REQUEST, null );
          }

     }


}
