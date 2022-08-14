package escola;

import escola.academico.aluno.dominio.model.aluno.Aluno;
import escola.gamificacao.selo.aplicacao.GerarSeloAlunoNovato;
import escola.gamificacao.selo.dominio.model.selo.Selo;
import escola.gamificacao.selo.dominio.model.selo.TipoDeSelo;
import escola.gamificacao.selo.infra.selo.RepositorioDeSelosEmMemoria;
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
        RepositorioDeSelosEmMemoria repositorioDeSelosEmMemoria = new RepositorioDeSelosEmMemoria();

        publicador.adicionarOuvinte(new OuvinteLogDeAlunoMatriculado());
        publicador.adicionarOuvinte(new GerarSeloAlunoNovato(repositorioDeSelosEmMemoria));

        MatricularAluno matricularAluno = new MatricularAluno(repositorio, publicador);
        MatricularAlunoDto matricularAlunoDto = new MatricularAlunoDto(cpf, nome, email);
        matricularAluno.matricular(matricularAlunoDto);
        Aluno aluno = matricularAlunoDto.criarAluno();
        repositorioDeSelosEmMemoria.adicionarSelo(new Selo(aluno.getCpf(), TipoDeSelo.ALUNO_NOVATO));




    }
}
