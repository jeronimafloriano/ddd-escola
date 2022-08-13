package escola.dominio.model.aluno;

import escola.dominio.model.dadospessoais.Cpf;
import escola.dominio.model.dadospessoais.Telefone;

import java.util.List;

public interface RepositorioDeAlunos {

    Aluno buscarPorCpf(Cpf cpf);
    void matricular(Aluno aluno);

    void adicionarTelefone(Aluno aluno, Telefone telefones);
    List<Aluno> listarTodosAlunosMatriculados();

}
