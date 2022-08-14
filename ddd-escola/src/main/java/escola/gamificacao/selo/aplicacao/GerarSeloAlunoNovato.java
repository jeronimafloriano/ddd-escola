package escola.gamificacao.selo.aplicacao;

import escola.gamificacao.selo.dominio.model.selo.RepositorioDeSelos;
import escola.gamificacao.selo.dominio.model.selo.Selo;
import escola.gamificacao.selo.dominio.model.selo.TipoDeSelo;
import escola.shared.dominio.eventos.Evento;
import escola.shared.dominio.eventos.Ouvinte;
import escola.shared.dominio.eventos.TipoDeEvento;
import escola.shared.dominio.model.Cpf;

public class GerarSeloAlunoNovato extends Ouvinte {

    private final RepositorioDeSelos repositorioDeSelos;

    public GerarSeloAlunoNovato(RepositorioDeSelos repositorioDeSelos){
        this.repositorioDeSelos = repositorioDeSelos;
    }

    @Override
    protected boolean deveProcessar(Evento evento) {
        return evento.tipo() == TipoDeEvento.ALUNO_MATRICULADO;
    }

    @Override
    protected void reageAo(Evento evento) {
        Cpf cpfDoAluno = (Cpf) evento.informacoesDoEvento().get("cpf");
        Selo seloAlunoNovato = new Selo(cpfDoAluno, TipoDeSelo.ALUNO_NOVATO);
        repositorioDeSelos.adicionarSelo(seloAlunoNovato);
    }
}
