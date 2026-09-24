package fase05;

public class Musica extends Conteudo{

    private String artista;
    private int reproducoes = 0;


    public Musica(String titulo, String artista, int duracaoSegundos){
        super(titulo, duracaoSegundos);
        if (artista == null || artista.trim().isEmpty()){
            throw new IllegalArgumentException("O artista não pode ser vazio.");
        }
        this.artista  = artista;
        }

    public String getArtista(){
        return this.artista;
    }

    public int getReproducoes(){
        return this.reproducoes;
    }

    @Override
    public void reproduzir(){
        reproducoes ++;
        super.reproduzir();
    }

    public String getDuracaoFormatada(){
        int minutos = getDuracaoSegundos() / 60;
        int segundos = getDuracaoSegundos() % 60;
         
        return String.format("%02d:%02d", minutos, segundos);
    }
}
