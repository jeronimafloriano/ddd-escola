package escola.gamificacao.selo.dominio.model.selo;

import escola.shared.dominio.model.Cpf;

import java.util.List;

public interface RepositorioDeSelos {

    List<Selo> buscarPorCpfAluno(Cpf cpf);

    Selo buscarPorNomeDoSelo(String nome);

    void adicionarSelo(Selo selo);

    List<Selo> listarSelosDoAluno();

}
