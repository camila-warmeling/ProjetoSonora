package fase03.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import fase03.Musica;
import fase03.Playlist;
import fase03.Usuario;

public class PlaylistTest {
    Playlist playlist;
    Musica musica;
    Usuario usuario;

    @Test
    @DisplayName ("PL03 - Caso 01 - Adicionar música em playlist que ainda não está cheia")
    public void pl03adicionarMusicaPlaylistNaoCheia(){
        usuario = new Usuario("UsuarioA", "email@teste.com");
        playlist = new Playlist("Minhas Playlist", usuario);
        musica = new Musica("Blinding Lights", "The Weeknd", 200);
        
        playlist.adicionarMusica(musica);
        assertEquals(1, playlist.getQuantidadeMusicas());
    }

    @Test
    @DisplayName ("PL03 - Caso 02 - Adicionar música em playlist até atingir a capacidade máxima")
    public void pl03adicionarMusicaPlaylistQuaseCheia(){
        usuario = new Usuario("UsuarioA", "email@teste.com");
        playlist = new Playlist("Minhas Playlist", usuario);

        for(int i = 0; i < 100; i++){
            musica = new Musica("Blinding Lights" + i, "The Weeknd", 200);
            boolean adicionar = playlist.adicionarMusica(musica);
            assertTrue(adicionar); //garante que a musica foi adicionada em cada ciclo do looping
        }

        assertEquals(100, playlist.getQuantidadeMusicas());
    }

    @Test
    @DisplayName ("PL03 - Caso 03 - Tentar adicionar música em playlist que já está cheia")
    public void pl03tentarAdicionarMusicaPlaylistCheia(){
        boolean adicionar;
        usuario = new Usuario("UsuarioA", "email@teste.com");
        playlist = new Playlist("Minhas Playlist", usuario);

        for(int i = 0; i < 100; i++){
            musica = new Musica("Blinding Lights" + i, "The Weeknd", 200);
            adicionar = playlist.adicionarMusica(musica);
            assertTrue(adicionar); //garante que a musica foi adicionada em cada ciclo do looping
        }

        //adicionando a música com a playlist cheia
        musica = new Musica("Wonderwall", "Oasis", 258);
        adicionar = playlist.adicionarMusica(musica);
        assertFalse(adicionar);
        assertEquals(100, playlist.getQuantidadeMusicas());
    }
}
