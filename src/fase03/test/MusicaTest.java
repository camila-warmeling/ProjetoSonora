package fase03.test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.assertEquals;
import fase03.Musica;

public class MusicaTest {
    Musica musica;

    @Test
    @DisplayName ("PL01 - Caso 01 - Duração com minutos e segundos")
    public void pl01duracaoMinutosSegundos(){
        musica = new Musica("Bohemian Rhapsody", "Queen", 125);
        String resultado = musica.getDuracaoFormatada();
        //(esperado, obtido)
        assertEquals("02:05", resultado);
    }

    @Test
    @DisplayName ("PL01 - Caso 02 - Duração redonda em minutos")
    public void pl01duracaoRedondaMinutos(){
        musica = new Musica("Billie Jean", "Michael Jackson",90);
        String resultado = musica.getDuracaoFormatada();
        assertEquals("01:30", resultado);    
    }

    @Test
    @DisplayName ("PL01 - Caso 03 - Menos de um minuto, com zero a esquerda")
    public void pl01duracaoMenosDeUmMinuto(){
        musica = new Musica("Short Song", "Test Band", 5);
        String resultado = musica.getDuracaoFormatada();
        assertEquals("00:05", resultado);
    }

    @Test
    @DisplayName ("PL01 - Caso 04 - Dois dígitos nos minutos")
    public void pl01doisDigitosMinutos(){
        musica = new Musica("Long Symphony", "Orchestra", 600);
        String resultado = musica.getDuracaoFormatada();
        assertEquals("10:00", resultado);
    }

    @Test
    @DisplayName ("PL01 - Caso 05 - Valor logo abaixo de 10 minutos")
    public void pl01valorLogoAbaixoDezMinutos(){
        musica = new Musica("Shape of You", "Ed Sheeran", 599);
        String resultado = musica.getDuracaoFormatada();
        assertEquals("09:59", resultado);
    }

}
