package escola.exception;

import escola.dominio.model.dadospessoais.Cpf;

public class AlunoNaoEncontradoException extends RuntimeException{

    public AlunoNaoEncontradoException(Cpf cpf){
        super("Aluno não encontrado com o CPF: " + cpf.getNumeroCpf());
    }

}
