package br.com.challenge.digitalRepublic.service.serviceImpl;


import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;

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
     public HttpStatus openAccountRules(Account account) {


          if ( account.getPerson().getCpf().isEmpty() || account.getPerson().getAccountOwner().isEmpty()){

                  return HttpStatus.NOT_FOUND ;
          }


          return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(account)).getStatusCode();
     }





}
