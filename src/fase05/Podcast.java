package fase05;

public class Podcast extends Conteudo {

    private String apresentador;
    private int numeroEpisodio;
    private int reproducoes = 0;

    public Podcast(String titulo, String apresentador, int numeroEpisodio, int duracaoSegundos){
        super(titulo, duracaoSegundos);
        
        if (apresentador == null || apresentador.trim().isEmpty()){
            throw new IllegalArgumentException("O apresentador não pode ser vazio.");
        }
        if (numeroEpisodio < 1){
            throw new IllegalArgumentException("O número do episódio deve ser maior ou igual a 1. Número digitado: " + numeroEpisodio);
        }
        
        this.apresentador = apresentador;
        this.numeroEpisodio = numeroEpisodio;
    }

    public String getApresentador(){
        return this.apresentador;
    }

    public void setApresentador(String apresentador){
        if (apresentador == null || apresentador.trim().isEmpty()){
            throw new IllegalArgumentException("O apresentador não pode ser vazio.");
        }
        this.apresentador = apresentador;
    }

    public int getNumeroEpisodio(){
        return this.numeroEpisodio;
    }

    public void setNumeroEpisodio(int numeroEpisodio){
        if (numeroEpisodio < 1){
            throw new IllegalArgumentException("O número do episódio deve ser maior ou igual a 1. Número digitado: " + numeroEpisodio);
        }
        this.numeroEpisodio = numeroEpisodio;
    }

    public int getReproducoes(){
        return this.reproducoes;
    }

    @Override 
    public void reproduzir(){
        reproducoes++;
        super.reproduzir();
    }

    @Override
    public String toString() {
        return super.toString() + " - " + apresentador + " (Ep. " + numeroEpisodio + ")";
    }
}