package br.edu.ifba.inf011.observer;

import br.edu.ifba.inf011.model.PlayerMode;
/*SUBSCRIBER INTERFACE*/
public interface Listener {
	
	void update(PlayerMode mode);
}
