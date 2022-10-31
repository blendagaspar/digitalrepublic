package br.com.challenge.digitalRepublic.repository;

import br.com.challenge.digitalRepublic.entities.AccountMovement;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountMovimentRepository extends MongoRepository<AccountMovement, String> {

}
