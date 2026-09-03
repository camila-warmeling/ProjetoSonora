package fase03.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import fase03.Plataforma;
import fase03.Musica;

public class PlataformaTest {

    public Plataforma criarPlataformaComMusicas(){
        Plataforma plat = new Plataforma();

        plat.cadastrarMusica(new Musica("Bohemian Rhapsody", "Queen", 354));
        plat.cadastrarMusica(new Musica("Song 2", "Blur", 122));
        plat.cadastrarMusica(new Musica("Hotel California", "Eagles", 390));
        plat.cadastrarMusica(new Musica("Billie Jean", "Michael Jackson", 294));
        plat.cadastrarMusica(new Musica("In the End", "Linkin Park", 216));

        return plat;
    }

    @Test 
    @DisplayName ("PL06 - Caso 01 - Buscar música cadastrada na plataforma pelo título")
    public void pl06buscarMusicaCadastradaPeloTitulo(){
        Plataforma plataforma = criarPlataformaComMusicas(); 

        Musica musica = plataforma.buscarMusica("Song 2");
        assertNotNull(musica);
        assertEquals("Song 2", musica.getTitulo());
    }

    @Test 
    @DisplayName ("PL06 - Caso 02 - Buscar música não cadastrada na plataforma pelo título")
    public void pl06buscarMusicaNaoCadastradaPeloTitulo(){
        Plataforma plataforma = criarPlataformaComMusicas(); 

        Musica musica = plataforma.buscarMusica("Take On Me");
        assertNull(musica);
    }

    @Test 
    @DisplayName ("PL06 - Caso 03 - Buscar música cadastrada na plataforma pelo id")
    public void pl06buscarMusicaCadastradaPeloId(){
        Plataforma plataforma = criarPlataformaComMusicas(); 

        Musica musica = plataforma.buscarMusica(2);
        assertNotNull(musica);
        assertEquals(2, musica.getId());
    }

    @Test 
    @DisplayName ("PL06 - Caso 04 - Buscar música não cadastrada na plataforma pelo id")
    public void pl06buscarMusicaNaoCadastradaPeloId(){
        Plataforma plataforma = criarPlataformaComMusicas(); 

        Musica musica = plataforma.buscarMusica(10);
        assertNull(musica);
    }
}
