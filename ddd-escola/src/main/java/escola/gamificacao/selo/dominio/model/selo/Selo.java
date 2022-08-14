package escola.gamificacao.selo.dominio.model.selo;

import escola.shared.dominio.model.Cpf;
import lombok.Getter;

@Getter
public class Selo {

    private Cpf cpfDoAluno;
    private TipoDeSelo tipoDeSelo;

    public Selo(Cpf cpfDoAluno, TipoDeSelo tipoDeSelo){
        this.cpfDoAluno = cpfDoAluno;
        this.tipoDeSelo = tipoDeSelo;
    }


}
