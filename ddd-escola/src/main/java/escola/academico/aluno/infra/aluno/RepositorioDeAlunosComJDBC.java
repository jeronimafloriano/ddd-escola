package escola.academico.aluno.infra.aluno;

import escola.academico.aluno.dominio.model.aluno.Aluno;
import escola.academico.aluno.dominio.model.aluno.RepositorioDeAlunos;
import escola.shared.dominio.model.Cpf;
import escola.academico.aluno.dominio.model.aluno.Email;
import escola.academico.aluno.dominio.model.aluno.Telefone;
import escola.academico.aluno.exception.AlunoNaoEncontradoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RepositorioDeAlunosComJDBC implements RepositorioDeAlunos {

    private final Connection connection;

    public RepositorioDeAlunosComJDBC(Connection connection){
        this.connection = connection;
    }

    @Override
    public void matricular(Aluno aluno)  {
        String sql = "INSERT INTO ALUNO VALUES (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, aluno.getCpf().getNumeroCpf());
            ps.setString(2, aluno.getNome());
            ps.setString(3, aluno.getEmail().toString());
            ps.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public void adicionarTelefone(Aluno aluno, Telefone telefones){
        String sql = "INSERT INTO TELEFONE VALUES (? ,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            for (Telefone telefone : aluno.getTelefones()) {
                ps.setString(1, telefone.getDdd());
                ps.setString(2, telefone.getNumero());
                ps.execute();
            }
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

    @Override
    public Aluno buscarPorCpf(Cpf cpf) {
        String sql = "SELECT id, nome, email FROM ALUNO WHERE cpf = ?";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, cpf.getNumeroCpf().toString());
            ResultSet result = ps.executeQuery();

            boolean encontrou = result.next();
            if(!encontrou){
                throw new AlunoNaoEncontradoException(cpf);
            }

            String nome =  result.getString("nome");
            Email email = new Email(result.getString("email"));
            return new Aluno(cpf, nome, email);

        } catch(SQLException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Aluno> listarTodosAlunosMatriculados() {
        String sql = "SELECT cpf, nome, email FROM ALUNO";
        try{
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> alunos = new ArrayList<>();

            while(rs.next()){
                Cpf cpf = new Cpf(rs.getString("cpf"));
                String nome = rs.getString("nome");
                Email email = new Email(rs.getString("email"));
                Aluno aluno = new Aluno(cpf, nome, email);
                alunos.add(aluno);
            }

            return alunos;
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

    }

}
