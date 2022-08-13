package escola.aplicacao.aluno.matricular;

import escola.dominio.eventos.PublicadorDeEventos;
import escola.dominio.eventos.aluno.AlunoMatriculadoEvento;
import escola.dominio.model.aluno.Aluno;
import escola.dominio.model.aluno.RepositorioDeAlunos;

public class MatricularAluno {

    private final RepositorioDeAlunos repositorio;
    private final PublicadorDeEventos publicador;

    public MatricularAluno(RepositorioDeAlunos repositorio, PublicadorDeEventos publicador){
        this.repositorio = repositorio;
        this.publicador = publicador;
    }

    public void matricular(MatricularAlunoDto dados){
        Aluno novoAluno = dados.criarAluno();
        repositorio.matricular(novoAluno);

        AlunoMatriculadoEvento evento = new AlunoMatriculadoEvento(novoAluno.getCpf());
        publicador.publicar(evento);
    }
}
