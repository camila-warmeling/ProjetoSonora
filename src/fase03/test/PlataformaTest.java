package fase03.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import fase03.Plataforma;
import fase03.Musica;

public class PlataformaTest {
    private Plataforma plataforma;

    @BeforeEach 
    public void setup() {
        plataforma = new Plataforma();

        plataforma.cadastrarMusica(new Musica("Bohemian Rhapsody", "Queen", 354));
        plataforma.cadastrarMusica(new Musica("Song 2", "Blur", 122));
        plataforma.cadastrarMusica(new Musica("Hotel California", "Eagles", 390));
        plataforma.cadastrarMusica(new Musica("Billie Jean", "Michael Jackson", 294));
        plataforma.cadastrarMusica(new Musica("In the End", "Linkin Park", 216));
    }

    @Test 
    @DisplayName ("PL06 - Caso 01 - Buscar música cadastrada na plataforma pelo título")
    public void pl06buscarMusicaCadastradaPeloTitulo(){
        Musica musica = plataforma.buscarMusica("Song 2");
        assertNotNull(musica);
        assertEquals("Song 2", musica.getTitulo());
    }

    @Test 
    @DisplayName ("PL06 - Caso 02 - Buscar música não cadastrada na plataforma pelo título")
    public void pl06buscarMusicaNaoCadastradaPeloTitulo(){
        Musica musica = plataforma.buscarMusica("Take On Me");
        assertNull(musica);
    }

    @Test 
    @DisplayName ("PL06 - Caso 03 - Buscar música cadastrada na plataforma pelo id")
    public void pl06buscarMusicaCadastradaPeloId(){
        Musica musica = plataforma.buscarMusica(2);
        assertNotNull(musica);
        assertEquals(2, musica.getId());
    }

    @Test 
    @DisplayName ("PL06 - Caso 04 - Buscar música não cadastrada na plataforma pelo id")
    public void pl06buscarMusicaNaoCadastradaPeloId(){
        Musica musica = plataforma.buscarMusica(10);
        assertNull(musica);
    }
}
