package escola.dominio.dadospessoais;

import escola.dominio.dadospessoais.Telefone;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TelefoneTest {

    @Test
    void devePermitirCriarTelefoneValido(){
        String ddd = "62";
        String numero = "995563028";
        Telefone telefone = new Telefone(ddd, numero);
        Assertions.assertEquals(ddd,telefone.getDdd());
        Assertions.assertEquals(numero, telefone.getNumero());
    }

    @Test
    void naoDevePermitirCriarTelefoneComDddInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Telefone("12345","123695899"));
    }

    @Test
    void naoDevePermitirCriarTelefoneComNumeroInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Telefone("62", "12588"));
    }
}
