package br.com.challenge.digitalRepublic.controller;


import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.service.AccountService;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private AccountRepository accountRepository;



    @GetMapping("/searchAllAccount")
    public ResponseEntity<List<Account>> searchAllAccount(){

        return ResponseEntity.ok(accountService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Account> searchAccountById(@PathVariable String id){
        return accountRepository.findById(id).map(resp -> ResponseEntity.ok(resp))
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping("/createAnAccount")
    public ResponseEntity<Account>createAnAccount(@RequestBody Account account) {

        HttpStatus response = accountService.openAccountRules(account);

        return ResponseEntity.status(HttpStatus.CREATED).body(accountRepository.save(account));

    }









}
