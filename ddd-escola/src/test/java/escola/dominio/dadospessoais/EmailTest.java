package escola.dominio.dadospessoais;

import escola.dominio.model.dadospessoais.Email;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {

    @Test
    void devePermitirCriarEmailValido(){
        Email email = new Email("fulano@alura.com.br");
        Assertions.assertEquals("fulano@alura.com.br", email.getEnderecoEmail());
    }

    @Test
    void naoDevePermitirCriarEmailInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Email("123"));
    }
}
