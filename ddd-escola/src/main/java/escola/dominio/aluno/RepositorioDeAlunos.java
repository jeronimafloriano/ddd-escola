package escola.dominio.aluno;

import escola.dominio.dadospessoais.Cpf;
import escola.dominio.dadospessoais.Telefone;

import java.sql.SQLException;
import java.util.List;

public interface RepositorioDeAlunos {

    Aluno buscarPorCpf(Cpf cpf);
    void matricular(Aluno aluno);

    void adicionarTelefone(Aluno aluno, Telefone telefones);
    List<Aluno> listarTodosAlunosMatriculados();

}
