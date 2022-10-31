package br.com.challenge.digitalRepublic.Utils;

public interface MessageUtils {

    public interface Account{
        public static final String MSG_ERROR_DEFAULT = "Ocorreu um erro. Tente novamente mais tarde!";
        public static final String MSG_CPF_NOME_OBRIGATORIO = "CPF e nome completo são obrigatórios para abrir a conta!";
        public static final String MSG_CPF_INVALIDO = "CPF inválido!";
        public static final String MSG_CPF_REPETIDO = "CPF já Cadastrado em uma conta";
        public static final String MSG_CADASTRO_SUCESSO = "Conta cadastrada com sucesso!";

    }

    public interface AccountMovement{
        //MSGs MovimentoConta
        public static final String MSG_ERROR_DEFAULT = "Ocorreu um erro. Tente novamente mais tarde!";

        public static final String MSG_VALOR_NÃO_PODE_SER_MAIOR_QUE_2000_E_MENOR_QUE_0 = "O valor não pode ser menor que 0 e maior que 2000!";
        public static final String MSG_CONTA_ORIGEM_INVALIDA = "Transação não permitida! Conta de origem não cadastrada ou invalida!";
        public static final String MSG_CONTA_DESTINO_INVALIDA = "Transação não permitida! Conta de destino não cadastrada ou invalida!";
        public static final String MSG_TRANSFERENCIA_OK = "Transferência realizada com sucesso!";;



    }

}
