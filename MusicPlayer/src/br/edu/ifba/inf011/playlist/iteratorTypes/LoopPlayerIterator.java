package br.edu.ifba.inf011.playlist.iteratorTypes;
/*Concrete iterator*/
import java.util.List;

import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public class LoopPlayerIterator implements IteratorPlayer{
	
	private final List<PlaylistComponent> items;
    private Integer index;

    public LoopPlayerIterator(List<PlaylistComponent> items) {
        this.items = items;
        this.reset();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public PlaylistComponent next() {
        if (index >= items.size()) this.reset();
        return items.get(index++);
    }

    public void reset() {
        this.index = 0;
    }
}
