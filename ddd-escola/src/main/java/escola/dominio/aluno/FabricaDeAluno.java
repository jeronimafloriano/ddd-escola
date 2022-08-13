package escola.dominio.aluno;

import escola.dominio.dadospessoais.Cpf;
import escola.dominio.dadospessoais.Email;

public class FabricaDeAluno {

    private static Aluno aluno;
    private static FabricaDeAluno fabricaDeAluno = new FabricaDeAluno();

    public static FabricaDeAluno comCpfNomeEmail(String cpf, String nome, String email){
        aluno = new Aluno(new Cpf(cpf), nome, new Email(email));
        return fabricaDeAluno;
    }

    public static FabricaDeAluno comTelefone(String ddd, String numero){
        aluno.adicionarTelefone(ddd, numero);
        return fabricaDeAluno;
    }

    public Aluno criarAluno(){
        return this.aluno;
    }
}

