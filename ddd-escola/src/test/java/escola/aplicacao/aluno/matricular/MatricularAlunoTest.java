package escola.aplicacao.aluno.matricular;

import escola.dominio.aluno.Aluno;
import escola.dominio.dadospessoais.Cpf;
import escola.infra.aluno.RepositorioDeAlunosEmMemoria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MatricularAlunoTest {

    @Test
    void alunoDeveriaSerMatriculado(){
        RepositorioDeAlunosEmMemoria repositorio = new RepositorioDeAlunosEmMemoria();
        MatricularAluno useCase = new MatricularAluno(repositorio);
        useCase.matricular(new MatricularAlunoDto(
                "145.222.147-14",
                "Gesse",
                "gesse@teste.com.br"));

        Aluno aluno = repositorio.buscarPorCpf(new Cpf("145.222.147-14"));
        Assertions.assertEquals("Gesse", aluno.getNome());
        Assertions.assertEquals("gesse@teste.com.br", aluno.getEmail().getEnderecoEmail());
    }

}
