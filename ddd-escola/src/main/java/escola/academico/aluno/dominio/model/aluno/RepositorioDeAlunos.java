package escola.academico.aluno.dominio.model.aluno;

import escola.shared.dominio.model.Cpf;

import java.util.List;

public interface RepositorioDeAlunos {

    Aluno buscarPorCpf(Cpf cpf);
    void matricular(Aluno aluno);

    void adicionarTelefone(Aluno aluno, Telefone telefones);
    List<Aluno> listarTodosAlunosMatriculados();

}
