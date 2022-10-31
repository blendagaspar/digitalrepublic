package br.com.challenge.digitalRepublic.service;


import br.com.challenge.digitalRepublic.entities.Account;

import br.com.challenge.digitalRepublic.response.Response;

import java.util.List;

public interface AccountService {

     public List<Account> findAll();

     public String findById(String id);

     Response<Account> abrirConta(Account account);
}
