package br.edu.ifba.inf011;

import java.io.IOException;

import br.edu.ifba.inf011.model.Musica;
import br.edu.ifba.inf011.model.Player;
import br.edu.ifba.inf011.model.PlayerMode;
import br.edu.ifba.inf011.decorator.MusicaConcrete;
import br.edu.ifba.inf011.decorator.LetrasDecorator;
import br.edu.ifba.inf011.decorator.NotaDecorator;
import br.edu.ifba.inf011.decorator.TraducaoDecorator;
import br.edu.ifba.inf011.observer.Listener;
import br.edu.ifba.inf011.playlist.IteratorPlayer;
import br.edu.ifba.inf011.playlist.Playlist;
import br.edu.ifba.inf011.playlist.PlaylistComponent;

public class Aplicacao implements Listener{
	private void playlist() throws IOException, InterruptedException {
		Playlist playlist = new Playlist("playlist1");
		
		
		Musica notas =  new NotaDecorator(new MusicaConcrete("GodSaveTheQueen"));

		Musica letras =  new LetrasDecorator(new MusicaConcrete("GodSaveTheQueen"));

		Musica traducao =  new TraducaoDecorator(new MusicaConcrete("GodSaveTheQueen"),"pt");

		Musica notasLetras = new NotaDecorator(new LetrasDecorator(new MusicaConcrete("GodSaveTheQueen")));

		Musica notasLetrasTraducao = new TraducaoDecorator(new LetrasDecorator(new NotaDecorator(new MusicaConcrete("GodSaveTheQueen"))),"pt");
		Musica andreDora = new TraducaoDecorator(new LetrasDecorator(new NotaDecorator(new MusicaConcrete("Lullaby"))),"pt");
		playlist.adicionar(notas);
		
		playlist.adicionar(traducao);
		
		playlist.adicionar(notasLetras);
		
		Player player = new Player();
		player.eventManager.addListener(this);
		player.addComponent(notasLetras);
		player.addComponent(andreDora);
		player.setMode(PlayerMode.PlayerAll);
		
		IteratorPlayer playiterator = player.createIterator();
		
		while(playiterator.hasNext()) {
			PlaylistComponent component = playiterator.next();
			System.out.println(component.execute());
			Thread.sleep(10000);
		}
		player.addComponent(notas);
		player.addComponent(letras);
		player.addComponent(playlist);
		player.addComponent(notasLetrasTraducao);
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		Aplicacao app = new Aplicacao();
		app.playlist();
		//app.teste();
	}
	
	public void update(PlayerMode mode) {
		System.out.println("Modo de execução mudado para: " + mode);
	}

}
