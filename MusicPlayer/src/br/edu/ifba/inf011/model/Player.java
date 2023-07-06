package br.edu.ifba.inf011.model;
/*Publisher*/
import java.util.ArrayList;
import java.util.List;

import br.edu.ifba.inf011.observer.EventManager;
import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public class Player implements PlayerIterabler{
	
	/*Concrete Collection*/
	private final List<PlaylistComponent> components;
    private PlayerMode mode;
    public EventManager eventManager;
    		
	public Player() {
		// TODO Auto-generated constructor stub
		components = new ArrayList<PlaylistComponent>();
		this.eventManager = new EventManager();
	}
	

	@Override
	public void addComponent(PlaylistComponent item) {
		this.components.add(item);
		
	}

	@Override
	public void removeComponent(PlaylistComponent item) {
		this.components.remove(item);
		
	}

	@Override
    public IteratorPlayer createIterator() {
        return this.mode.createPlayer(components);
    }

    public void setMode(PlayerMode mode) {
        this.mode = mode;
        eventManager.notify(mode);
    }

    public PlayerMode getMode(){
        return this.mode;
    	}

}
