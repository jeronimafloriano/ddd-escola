package escola.dominio.dadospessoais;

public class Cpf {

    private String cpf;

    public Cpf(String numero){
        if(numero == null || !numero.matches("\\d{3}\\.\\d{3}\\.\\d{3}\\-\\d{2}")){
            throw new IllegalArgumentException();
        };

        this.cpf = numero;

    }

    public String getCpf() {
        return this.cpf;
    }
}
