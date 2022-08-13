package escola.aplicacao.aluno.matricular;

import escola.dominio.aluno.Aluno;
import escola.dominio.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;

    public MatricularAluno(RepositorioDeAlunos repositorio){
        this.repositorio = repositorio;
    }

    public void matricular(MatricularAlunoDto dados){
        Aluno novoAluno = dados.criarAluno();
        repositorio.matricular(novoAluno);
    }
}
