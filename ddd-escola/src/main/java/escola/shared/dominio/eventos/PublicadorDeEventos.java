package escola.shared.dominio.eventos;

import java.util.ArrayList;
import java.util.List;

public class PublicadorDeEventos {

    List<Ouvinte> ouvintes = new ArrayList<>();

    public void adicionarOuvinte(Ouvinte ouvinte){
        this.ouvintes.add(ouvinte);
    }

    public void publicar(Evento evento){
        this.ouvintes.stream().forEach(o -> o.processa(evento));
    }
}
