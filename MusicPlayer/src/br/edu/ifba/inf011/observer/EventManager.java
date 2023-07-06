package br.edu.ifba.inf011.observer;
/*EVENT MANAGER*/

import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.model.PlayerMode;

public class EventManager {
	private List<Listener> listeners = new ArrayList<>();
	
	public void addListener(Listener listener) {
		this.listeners.add(listener);
	}
	
	public void removeListener(Listener listener) {
		this.listeners.remove(listener);	
	}
	
	public void notify(PlayerMode mode) {
		
		listeners.stream().forEach((e) -> e.update(mode));
		
	}
}
