package fase01;

public class Playlist {

    private Musica[] playlist = new Musica[100];
    private String nome;
    private Usuario dono; //a variável dono recebe somente objetos da classe Usuario 
    private int quantMusicas;

    public Playlist(String nome, Usuario dono){
        this.nome = nome;
        this.dono = dono;
    }

    public String getNome(){
        return this.nome;
    }

    public Usuario getDono(){
        return this.dono;
    }

    public int getQuantidade(){
        return this.quantMusicas;
    }

    public boolean adicionar(Musica musica){
        if(musica != null && quantMusicas < 100){
            playlist[this.quantMusicas] = musica;
            quantMusicas++;
            return true;
        }
        return false;
    }

    public Musica getNaPosicao(int indice){
        if(indice < quantMusicas){ //a quantidade de músicas sempre vai ser indice+1. Pois o índice começa no 0 ao invés do 1.
            return this.playlist[indice];
        }
        return null;
    }

    public boolean removerNaPosicao(int indice){
        //TO DO
    }

    public int getDuracaoTotalSegundos(){
        //TO DO
    }

    public void reproduzirTudo(){
        //TO DO
    }
}
