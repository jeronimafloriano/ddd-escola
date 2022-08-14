package escola.gamificacao.selo.dominio.model.selo;

import escola.shared.dominio.model.Cpf;
import lombok.Getter;

@Getter
public class Selo {

    private Cpf cpfDoAluno;
    private String nome;

    public Selo(Cpf cpfDoAluno, String nome){
        this.cpfDoAluno = cpfDoAluno;
        this.nome = nome;
    }


}
