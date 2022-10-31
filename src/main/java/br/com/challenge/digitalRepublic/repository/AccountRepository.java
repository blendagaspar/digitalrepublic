package br.com.challenge.digitalRepublic.repository;

import br.com.challenge.digitalRepublic.entities.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface AccountRepository extends MongoRepository<Account, String> {


}