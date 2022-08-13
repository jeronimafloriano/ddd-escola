package escola;

import escola.aplicacao.aluno.matricular.MatricularAluno;
import escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import escola.dominio.aluno.Aluno;
import escola.dominio.aluno.FabricaDeAluno;
import escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoEmMemoria {

    public static void main(String[] args) {

        String nome = "Gesse";
        String cpf = "145.222.147-14";
        String email = "gesse@teste.com.br";

        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno matricularAluno = new MatricularAluno(repositorio);
        matricularAluno.matricular(new MatricularAlunoDto(cpf, nome, email));



    }
}
