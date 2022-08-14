package escola.academico.aluno.dominio.eventos.aluno;

import escola.shared.dominio.eventos.Ouvinte;
import escola.shared.dominio.eventos.Evento;

import java.time.format.DateTimeFormatter;

public class OuvinteLogDeAlunoMatriculado extends Ouvinte {

    @Override
    public void reageAo(Evento evento){
        String momentoFormatado = evento
                .momento()
                .format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
        System.out.format("Aluno com CPF %s matriculado em %s. \n",
                ((AlunoMatriculadoEvento) evento).getCpfAluno().getNumeroCpf(),
                momentoFormatado);
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento instanceof AlunoMatriculadoEvento;
    }

}
