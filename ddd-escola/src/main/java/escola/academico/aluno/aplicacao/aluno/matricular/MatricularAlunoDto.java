package escola.academico.aluno.aplicacao.aluno.matricular;

import escola.academico.aluno.dominio.model.aluno.Aluno;
import escola.shared.dominio.model.Cpf;
import escola.academico.aluno.dominio.model.aluno.Email;

public class MatricularAlunoDto {

    private String cpf;
    private String nome;
    private String email;

    public MatricularAlunoDto(String cpf, String nome, String email){
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }
    public Aluno criarAluno(){
        return new Aluno(new Cpf(cpf), nome, new Email(email));
    }

}
