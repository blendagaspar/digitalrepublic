package br.com.challenge.digitalRepublic.service;


import br.com.challenge.digitalRepublic.entities.Account;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AccountService {

     public List<Account> findAll();

     public String findById(String id);

     HttpStatus openAccountRules(Account account);
}
