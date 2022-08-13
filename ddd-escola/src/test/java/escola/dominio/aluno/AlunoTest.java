package escola.dominio.aluno;

import escola.dominio.model.dadospessoais.Cpf;
import escola.dominio.model.dadospessoais.Email;
import escola.dominio.model.aluno.Aluno;
import escola.exception.dadospessoais.TelefoneMaxCadastradosException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    private Aluno aluno;

    @BeforeEach
    void beforeEach(){
        this.aluno = new Aluno(
                new Cpf("125.145.782-00"),
                "Maria",
                new Email("maria@teste.com.br"));
    }

    @Test
    void devePermitirCadastrarTelefoneValido(){
        this.aluno.adicionarTelefone("62", "987452125");
        Assertions.assertEquals(1, this.aluno.getTelefones().size());
    }

    @Test
    void devePermitirCadastrarDoisTelefones(){
        this.aluno.adicionarTelefone("62", "987452125");
        this.aluno.adicionarTelefone("62", "987412125");
        Assertions.assertEquals(2, this.aluno.getTelefones().size());
    }

    @Test
    void naoDevePermitirCriarMaisDeDoisTelefonesPorAluno(){
        Assertions.assertThrows(TelefoneMaxCadastradosException.class, () -> {
            this.aluno.adicionarTelefone("62", "981237125");
            this.aluno.adicionarTelefone("62", "981237125");
            this.aluno.adicionarTelefone("62", "981237125");
        });
    }
}
