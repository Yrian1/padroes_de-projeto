package br.edu.ifba.inf011.decorator;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.resources.ResourceLoader;

import java.io.IOException;
import java.util.List;

public class TraducaoDecorator extends  MusicaBase{
    private List<String> traducao;
    private Integer linha;

    public TraducaoDecorator(Musica musica, String idioma) throws IOException {
        super(musica);
        this.traducao = ResourceLoader.instance().loadTraducao(super.getName(),idioma);
        this.reset();
    }

    public void reset() {
        super.reset();
        this.linha = 0;
    }

    public Boolean finish() {
        return this.linha >= this.traducao.size();
    }

    public String play() {
        return super.play()+this.traducao.get(this.linha++)+"\n";
    }

   

}
