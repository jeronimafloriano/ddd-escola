package escola.exception.dadospessoais;

import escola.dominio.model.aluno.Aluno;

public class TelefoneMaxCadastradosException extends RuntimeException{

    public TelefoneMaxCadastradosException(Aluno aluno){
        super("Número máximo de telefones já cadastrado para o aluno: " + aluno);

    }

}
