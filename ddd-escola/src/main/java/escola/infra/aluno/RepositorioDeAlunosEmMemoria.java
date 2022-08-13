package escola.infra.aluno;

import escola.dominio.aluno.Aluno;
import escola.dominio.aluno.RepositorioDeAlunos;
import escola.dominio.dadospessoais.Cpf;
import escola.dominio.dadospessoais.Telefone;
import escola.exception.AlunoNaoEncontradoException;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosEmMemoria implements RepositorioDeAlunos {

    private List<Aluno> matriculados = new ArrayList<>();

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        return this.matriculados.stream()
                .filter(a -> a.getNumeroCpf().equals(cpf.getCpf()))
                .findFirst()
                .orElseThrow(() -> new AlunoNaoEncontradoException(cpf));
    }

    @Override
    public void matricular(Aluno aluno) {
        this.matriculados.add(aluno);
    }

    @Override
    public void adicionarTelefone(Aluno aluno, Telefone telefones) {
        aluno.adicionarTelefone(telefones.getDdd(), telefones.getNumero());
    }

    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        return this.matriculados;
    }
}
