package escola;

import escola.aplicacao.aluno.matricular.MatricularAluno;
import escola.aplicacao.aluno.matricular.MatricularAlunoDto;
import escola.dominio.eventos.PublicadorDeEventos;
import escola.dominio.eventos.aluno.OuvinteLogDeAlunoMatriculado;
import escola.infra.aluno.RepositorioDeAlunosEmMemoria;

public class MatricularAlunoEmMemoria {

    public static void main(String[] args) {

        String nome = "Gesse";
        String cpf = "145.222.147-14";
        String email = "gesse@teste.com.br";

        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionarOuvinte(new OuvinteLogDeAlunoMatriculado());

        MatricularAluno matricularAluno = new MatricularAluno(repositorio, publicador);
        matricularAluno.matricular(new MatricularAlunoDto(cpf, nome, email));



    }
}
