package br.com.challenge.digitalRepublic.controller;


import br.com.challenge.digitalRepublic.DTO.AccountMovimentDTO;
import br.com.challenge.digitalRepublic.DTO.AccountMovimentReturnDTO;
import br.com.challenge.digitalRepublic.Utils.MessageUtils;
import br.com.challenge.digitalRepublic.response.Response;
import br.com.challenge.digitalRepublic.service.AccountMovimentService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movimentoDaConta")
public class AccountMovimentController {

    @Autowired
    private AccountMovimentService accountMovimentService;

    @ApiOperation( value = "Realizar uma transferência para outra conta" )
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = MessageUtils.AccountMovement.MSG_TRANSFERENCIA_OK ),
            @ApiResponse(code = 412, message = "Quando não atender aos requisitos mínimos" ),
            @ApiResponse(code = 400, message = "Quando ocorrer algum problema na transação"),
    })
    @PostMapping( "/transferencia" )
    public ResponseEntity<Response<AccountMovimentReturnDTO>> realizarTransferencia(@RequestBody AccountMovimentDTO accountMovimentDTO){

        Response<AccountMovimentReturnDTO> accountMovimentDTOResponse = accountMovimentService.realizarTransferencia( accountMovimentDTO.getNumeroContaDestino() ,
                accountMovimentDTO.getNumeroContaDestino(),
                accountMovimentDTO.getNumeroContaDestino() );

        return ResponseEntity.status( accountMovimentDTOResponse.getStatus() ).body( accountMovimentDTOResponse );
    }

}
