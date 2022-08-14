package escola.academico.aluno.aplicacao.indicacao;

import escola.academico.aluno.dominio.model.aluno.Aluno;

public interface EnviarEmailIndicacao {

    void enviarEmailPara(Aluno indicado);
}
