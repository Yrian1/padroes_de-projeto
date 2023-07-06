package br.edu.ifba.inf011.playlist.iteratorTypes;
/*Concrete iterator*/
import java.util.List;
import java.util.Random;

import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.Playlist;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public class RandomIterator implements IteratorPlayer{
	
	private final Random random;
    private final List<PlaylistComponent> items;

    public RandomIterator(List<PlaylistComponent> items) {
        this.items = items;
        this.random = new Random();
    }

    @Override
    public boolean hasNext() {
        return true;
    }

    @Override
    public PlaylistComponent next() {
    	PlaylistComponent playlistItem = items.get(nextRandom());
        if (playlistItem instanceof Playlist) {
            return ((Playlist) playlistItem).randomize();
        }
        return playlistItem;
    }
    private int nextRandom() {
        return random.nextInt(this.items.size());
    }

}
