package br.com.challenge.digitalRepublic.DTO;


import br.com.challenge.digitalRepublic.entities.Account;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDTO {


    private String cpf;

    private String nomeCompleto;

    public Account fromDtoToEntity() {
        return new Account(cpf , nomeCompleto);
    }


}
