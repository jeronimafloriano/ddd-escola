package escola.aplicacao.indicacao;

import escola.dominio.model.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarEmailPara(Aluno indicado);
}
