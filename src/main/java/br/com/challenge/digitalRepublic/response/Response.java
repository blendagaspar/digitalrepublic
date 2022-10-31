package br.com.challenge.digitalRepublic.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
public class Response<T> {

    @ApiModelProperty()
    private T data;

    @ApiModelProperty()
    private List<String> mensagens;

    @ApiModelProperty()
    private HttpStatus status;

    public Response() {

    }

    public List<String> getMensagens() {
        if (this.mensagens == null) {
            this.mensagens = new ArrayList<String>();
        }

        return this.mensagens;
    }

    public Response(String msg, HttpStatus status, T data) {
        this.setData( data );
        this.setMensagens( Arrays.asList( msg ) );
        this.setStatus( status );
    }


}
