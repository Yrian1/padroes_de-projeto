package br.edu.ifba.inf011.playlist;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/* Composite: Composite pattern */
public class Playlist implements PlaylistComponent {

    private final String nome;
    private final List<PlaylistComponent> items;

    public Playlist(String nome) {
        this.nome = nome;
        this.items = new ArrayList<>();
    }

    public void adicionar(PlaylistComponent item) {
        this.items.add(item);
    }

    public void remove(PlaylistComponent item) {
        this.items.remove(item);
    }

    public List<PlaylistComponent> getChildren() {
        return this.items;
    }

    @Override
    public String getName() {
        return this.nome;
    }

    public PlaylistComponent randomize() {
        int random = new Random().nextInt(items.size());
        PlaylistComponent playlistItem = items.get(random);
        if (playlistItem instanceof Playlist) {
            return ((Playlist) playlistItem).randomize();
        }
        return playlistItem;
    }

    @Override
    public String execute() {
        StringBuffer str = new StringBuffer();
        for (PlaylistComponent item : items) {
            str.append(item.execute());
        }
        return str.toString();
    }

}
