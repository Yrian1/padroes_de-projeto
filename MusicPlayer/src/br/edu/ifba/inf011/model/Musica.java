package br.edu.ifba.inf011.model;

import br.edu.ifba.inf011.playlist.PlaylistComponent;

public interface Musica extends PlaylistComponent{
	public void reset();
	public Boolean finish();
	public String play();
}
