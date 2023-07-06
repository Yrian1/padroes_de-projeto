package br.edu.ifba.inf011.model;

import java.util.List;

import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.PlaylistComponent;
import br.edu.ifba.inf011.playlist.iteratorTypes.LoopPlayerIterator;
import br.edu.ifba.inf011.playlist.iteratorTypes.PlayAllIterator;
import br.edu.ifba.inf011.playlist.iteratorTypes.RandomIterator;

public enum PlayerMode {
	
	PlayerAll {
		public IteratorPlayer createPlayer(List<PlaylistComponent> components) {
			return new PlayAllIterator(components);
		}
	},
	RepeatAll {
		public IteratorPlayer createPlayer(List<PlaylistComponent> components) {
			return new LoopPlayerIterator(components);
		}
	},
	RandomMode {
		public IteratorPlayer createPlayer(List<PlaylistComponent> components) {
			return new RandomIterator(components);
		}
	};

	public abstract IteratorPlayer createPlayer(List<PlaylistComponent> components);

}
