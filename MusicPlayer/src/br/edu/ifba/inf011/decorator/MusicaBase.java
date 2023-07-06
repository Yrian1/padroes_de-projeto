package br.edu.ifba.inf011.decorator;
/*Base Decorator*/

import br.edu.ifba.inf011.model.Musica;

public abstract class MusicaBase implements Musica {
    private Musica musica;

    public MusicaBase(Musica musica) {
        this.musica = musica;
    }

    @Override
    public String getName() {
        return musica.getName();
    }

    public String execute() {
        StringBuffer str = new StringBuffer();
        this.reset();
        str.append("titulo : " + this.getName() + "\n\n");
        while(!this.finish())
            str.append(this.play());
    	str.append("--------------------------\n");
        return str.toString();
    }

    @Override
    public void reset() {
        musica.reset();
    }
    @Override
    public Boolean finish() {
        return musica.finish();
    }

    @Override
    public String play() {
        return musica.play();
    }
}
