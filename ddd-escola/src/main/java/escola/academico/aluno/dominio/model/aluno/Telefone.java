package escola.academico.aluno.dominio.model.aluno;

import escola.academico.aluno.exception.dadospessoais.TelefoneMaxCadastradosException;

public final class Telefone {

    private String ddd;
    private String numero;


    public Telefone (String ddd, String numero){
        if(ddd == null || ddd.trim().isEmpty() || ddd.length() != 2){
            throw new IllegalArgumentException("DDD inválido.");
        }
        if(numero == null || numero.trim().isEmpty() || numero.length() != 9 ){
            throw new IllegalArgumentException("escola.dadospessoais.Telefone inválido");
        }
        this.ddd = ddd;
        this.numero = numero;
    }

    public static void adicionarTelefone(Aluno aluno, Telefone telefone){
        if(aluno.getTelefones().size() == 2){
            throw new TelefoneMaxCadastradosException(aluno);
        }
        aluno.getTelefones().add(telefone);
    }

    public String getDdd(){
        return this.ddd;
    }

    public String getNumero(){
        return this.numero;
    }
}
