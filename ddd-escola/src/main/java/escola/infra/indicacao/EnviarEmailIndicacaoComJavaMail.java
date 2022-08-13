package escola.infra.indicacao;

import escola.aplicacao.indicacao.EnviarEmailIndicacao;
import escola.dominio.model.aluno.Aluno;

public class EnviarEmailIndicacaoComJavaMail implements EnviarEmailIndicacao {
    @Override
    public void enviarEmailPara(Aluno indicado) {
        //...
    }
}
