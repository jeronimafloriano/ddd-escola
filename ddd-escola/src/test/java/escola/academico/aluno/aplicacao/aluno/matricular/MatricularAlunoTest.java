package escola.academico.aluno.aplicacao.aluno.matricular;

import escola.shared.dominio.eventos.PublicadorDeEventos;
import escola.academico.aluno.dominio.eventos.aluno.OuvinteLogDeAlunoMatriculado;
import escola.academico.aluno.dominio.model.aluno.Aluno;
import escola.shared.dominio.model.Cpf;
import escola.academico.aluno.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerMatriculado(){
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();

        PublicadorDeEventos publicador = new PublicadorDeEventos();
        publicador.adicionarOuvinte(new OuvinteLogDeAlunoMatriculado());

        MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
        useCase.matricular(new MatricularAlunoDto(
                "145.222.147-14",
                "Gesse",
                "gesse@teste.com.br"));

        Aluno aluno = repositorio.buscarPorCpf(new Cpf("145.222.147-14"));
        Assertions.assertEquals("Gesse", aluno.getNome());
        Assertions.assertEquals("gesse@teste.com.br", aluno.getEmail().getEnderecoEmail());
    }

}
