package br.com.challenge.digitalRepublic;

import br.com.challenge.digitalRepublic.DTO.AccountDTO;
import br.com.challenge.digitalRepublic.entities.Account;
import br.com.challenge.digitalRepublic.repository.AccountRepository;
import br.com.challenge.digitalRepublic.response.Response;

import br.com.challenge.digitalRepublic.service.serviceImpl.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class AccountServiceTest {

    @Mock
    AccountRepository accountRepository;

    @InjectMocks
    private AccountServiceImpl accountService;

    @BeforeEach
    void init() {
        MockitoAnnotations.initMocks( this );
        when( accountRepository.save( any( Account.class ) ) ).thenReturn( getContaSave() );
    }


    @DisplayName( "Testa método abrirConta - Ok" )
    @Test
   public void abrirContaOk() {
        AccountDTO dto = getAccountDTO();
        Response<Account> contaOk = accountService.abrirConta( dto.fromDtoToEntity());
        assertNotNull( contaOk.getData() );
        assertEquals( contaOk.getData().getCpf(), dto.getCpf() );
        assertEquals( contaOk.getStatus() , HttpStatus.CREATED );

    }


    private AccountDTO getAccountDTO() {

        return AccountDTO.builder()
                .cpf("123456789")
                .nomeCompleto("Pedro Costa")
                .build();
    }

    private Account getContaSave() {

        Account account = getAccountDTO().fromDtoToEntity() ;
        account.setId("1");

        return account;
    }

}
