package fase03.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import fase03.Musica;
import fase03.Playlist;
import fase03.Usuario;

public class PlaylistTest {
    private Playlist playlist;
    private Musica musica;
    private Usuario usuario;

    @BeforeEach 
    public void setup(){
        usuario = new Usuario("UsuarioB", "email@teste.com");
        playlist = new Playlist("Nova Playlist", usuario);

        playlist.adicionarMusica(new Musica("Short Song", "Test Band", 65));
        playlist.adicionarMusica(new Musica("Smells Like Teen Spirit", "Nirvana", 301));
        playlist.adicionarMusica(new Musica("Blinding Lights", "The Weeknd", 200));
        playlist.adicionarMusica(new Musica("Wonderwall", "Oasis", 258));
        playlist.adicionarMusica(new Musica("Californication", "Red Hot Chili Peppers", 321));
    }

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

//----------------------------------------------------------------------------------------------------

    @Test
    @DisplayName ("PL04 - Caso 01 - Pesquisar música que está dentro da playlist")
    public void pl04pesquisaMusicaDaPlaylist(){
        Musica musica = playlist.getMusicaNaPosicao(0);
        assertNotNull(musica);
        assertEquals("Short Song", musica.getTitulo());
    }

    @Test
    @DisplayName ("PL04 - Caso 02 - Pesquisa com índice negativo")
    public void pl04pesquisarComIndiceNegativo(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.getMusicaNaPosicao(-1);
        });
    }

    @Test
    @DisplayName ("PL04 - Caso 03 - Pesquisar com índice que ultrapassa o limite de capacidade da playlist")
    public void pl04pesquisarIndiceAlemDaCapacidade(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.getMusicaNaPosicao(101);
        });
    }

    @Test
    @DisplayName ("PL04 - Caso 04 - Pesquisar com indice que não possui uma música cadastrada")
    public void pl04pesquisarIndiceQueNaoPossui(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.getMusicaNaPosicao(10);
        });
    }

//-------------------------------------------------------------------------------------------------------------------

    @Test 
    @DisplayName ("PL05 - Caso 01 - Remover com índice dentro da playlist, reorganizando-a")
    public void pl05removerIndiceReorganizadoPlaylist(){
        int qtdInicial = playlist.getQuantidadeMusicas();

        Musica segundaMusica = playlist.getMusicaNaPosicao(1); //título da segunda música
        playlist.removerMusicaNaPosicao(0);
        
        assertEquals(qtdInicial - 1, playlist.getQuantidadeMusicas());
        assertEquals(segundaMusica.getTitulo(), playlist.getMusicaNaPosicao(0).getTitulo());
    }

        @Test 
    @DisplayName ("PL05 - Caso 02 - Remover um índice que não possui uma música cadastrada")
    public void pl05removerIndiceSemCadastro(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.getMusicaNaPosicao(10);
        });
    }

        @Test 
    @DisplayName ("PL05 - Caso 03 - Remover com índice negativo")
    public void pl05removerIndiceNegativo(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.removerMusicaNaPosicao(-1);
        });
    }

        @Test 
    @DisplayName ("PL05 - Caso 04 - Remover com índice que vai além da quantidade permitida da playlist")
    public void pl05removerIndiceAlemDaCapacidade(){
        assertThrows(IndexOutOfBoundsException.class, () ->{
            playlist.removerMusicaNaPosicao(101);
        });
    }

}
