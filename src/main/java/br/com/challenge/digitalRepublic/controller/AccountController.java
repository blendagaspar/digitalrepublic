package br.com.challenge.digitalRepublic.controller;


import br.com.challenge.digitalRepublic.Utils.MessageUtils;
import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.service.AccountService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import br.com.challenge.digitalRepublic.response.Response;

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


    @ApiOperation( value = "Cadastrar uma nova conta" )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = MessageUtils.Account.MSG_CADASTRO_SUCESSO ),
            @ApiResponse(code = 412, message = "Quando não atender aos requisitos mínimos" ),
            @ApiResponse(code = 400, message = "Quando ocorrer algum problema na abertura da conta"),
    })
    @PostMapping( )
    public ResponseEntity<Response<Account>> abrirConta( @RequestBody Account account ){

        Response<Account> response = accountService.abrirConta(account);

        return ResponseEntity.status( response.getStatus() ).body( response );
    }




}
