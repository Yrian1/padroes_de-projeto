package br.edu.ifba.inf011.playlist.iteratorTypes;
/*Concrete iterator*/
import java.util.List;

import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public class PlayAllIterator implements IteratorPlayer{
	
	private final List<PlaylistComponent> items;
    private Integer index;

    public PlayAllIterator(List<PlaylistComponent> items) {
        this.items = items;
        this.reset();
    }

    @Override
    public boolean hasNext() {
        return this.index < this.items.size();
    }

    @Override
    public PlaylistComponent next() {
        if(this.hasNext()) return items.get(index++);
        return null;
    }

    public void reset() {
        this.index = 0;
    }
}
