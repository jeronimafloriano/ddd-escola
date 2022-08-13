package escola.aplicacao.aluno.matricular;

import escola.dominio.aluno.Aluno;
import escola.dominio.dadospessoais.Cpf;
import escola.dominio.dadospessoais.Email;

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
