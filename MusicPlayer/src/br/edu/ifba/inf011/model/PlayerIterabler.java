package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public interface PlayerIterabler {

	void addComponent(PlaylistComponent item);
    void removeComponent(PlaylistComponent item);
    IteratorPlayer createIterator();

}
