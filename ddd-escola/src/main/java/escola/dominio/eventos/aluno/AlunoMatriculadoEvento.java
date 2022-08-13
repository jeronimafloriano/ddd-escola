package escola.dominio.eventos.aluno;

import escola.dominio.model.dadospessoais.Cpf;
import escola.dominio.eventos.Evento;

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
