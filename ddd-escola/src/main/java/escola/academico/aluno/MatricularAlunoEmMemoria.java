package escola.academico.aluno;

import escola.shared.dominio.eventos.PublicadorDeEventos;
import escola.academico.aluno.dominio.eventos.aluno.OuvinteLogDeAlunoMatriculado;
import escola.academico.aluno.infra.aluno.RepositorioDeAlunosEmMemoria;
import escola.academico.aluno.aplicacao.aluno.matricular.MatricularAluno;
import escola.academico.aluno.aplicacao.aluno.matricular.MatricularAlunoDto;

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
