package escola.dominio.dadospessoais;

import static org.junit.jupiter.api.Assertions.*;

import escola.dominio.dadospessoais.Cpf;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CpfTest {

//    @BeforeAll
//    void beforeAll(){
//        escola.dadospessoais.Cpf cpf = new escola.dadospessoais.Cpf("123.456.789-11");
//    }

    @Test
    void cpfNaoPodeSerNulo(){
        assertThrows(IllegalArgumentException.class,() -> new Cpf(null));
    }

    @Test
    void cpfNaoPodeSerInvalido(){
        assertThrows(IllegalArgumentException.class, () -> new Cpf("00-99"));
    }

    @Test
    void devePermitirCriarCpfValido(){
        String numero = "145.222.147-14";
        Cpf cpf = new Cpf(numero);
        Assertions.assertEquals(numero, cpf.getCpf());
    }


}
