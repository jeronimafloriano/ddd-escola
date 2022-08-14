package escola.academico.aluno.exception.dadospessoais;

import escola.academico.aluno.dominio.model.aluno.Aluno;

public class TelefoneMaxCadastradosException extends RuntimeException{

    public TelefoneMaxCadastradosException(Aluno aluno){
        super("Número máximo de telefones já cadastrado para o aluno: " + aluno);

    }

}
