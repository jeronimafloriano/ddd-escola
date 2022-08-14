package escola.academico.aluno.dominio.eventos.aluno;

import escola.shared.dominio.model.Cpf;
import escola.shared.dominio.eventos.Evento;

import java.time.LocalDateTime;

public class AlunoMatriculadoEvento implements Evento {

    private final Cpf cpfAluno;
    private final LocalDateTime momento;

    public AlunoMatriculadoEvento(Cpf cpf){
        this.cpfAluno = cpf;
        this.momento = LocalDateTime.now();
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    public Cpf getCpfAluno() {
        return cpfAluno;
    }

}
