package escola.academico.aluno.exception;

import escola.shared.dominio.model.Cpf;

public class AlunoNaoEncontradoException extends RuntimeException{

    public AlunoNaoEncontradoException(Cpf cpf){
        super("Aluno não encontrado com o CPF: " + cpf.getNumeroCpf());
    }

}
