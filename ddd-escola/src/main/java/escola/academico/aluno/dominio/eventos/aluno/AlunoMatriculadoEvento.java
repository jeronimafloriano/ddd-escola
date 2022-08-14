package escola.academico.aluno.dominio.eventos.aluno;

import escola.shared.dominio.eventos.TipoDeEvento;
import escola.shared.dominio.model.Cpf;
import escola.shared.dominio.eventos.Evento;

import java.time.LocalDateTime;
import java.util.Map;

public class AlunoMatriculadoEvento implements Evento {

    private final Cpf cpfAluno;
    private final LocalDateTime momento;
    private final TipoDeEvento tipoDeEvento;


    public AlunoMatriculadoEvento(Cpf cpf){
        this.cpfAluno = cpf;
        this.momento = LocalDateTime.now();
        this.tipoDeEvento = TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public LocalDateTime momento() {
        return this.momento;
    }

    @Override
    public TipoDeEvento tipo() {
        return TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    public Map<String, Object> informacoesDoEvento() {
        return Map.of("cpf",cpfAluno);
    }

    public Cpf getCpfAluno() {
        return cpfAluno;
    }

}
