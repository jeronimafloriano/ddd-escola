package escola.gamificacao.selo.infra.selo;

import escola.shared.dominio.model.Cpf;
import escola.gamificacao.selo.dominio.model.selo.RepositorioDeSelos;
import escola.gamificacao.selo.dominio.model.selo.Selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public final class RepositorioDeSelosEmMemoria implements RepositorioDeSelos {

    private final List<Selo> selos = new ArrayList<>();


    @Override
    public List<Selo> buscarPorCpfAluno(Cpf cpf) {
        return this.selos.stream()
                .filter(s -> s.getCpfDoAluno().equals(cpf))
                .collect(Collectors.toList());
    }

    @Override
    public Selo buscarPorNomeDoSelo(String nome) {
        return this.selos.stream()
                .filter(a -> a.getTipoDeSelo().toString().equals(nome))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Não foo encontrado selo com o nome informado."));
    }

    @Override
    public void adicionarSelo(Selo selo) {
        this.selos.add(selo);
    }

    @Override
    public List<Selo> listarSelosDoAluno() {
        return this.selos;
    }
}
