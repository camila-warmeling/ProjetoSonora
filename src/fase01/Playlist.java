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
        if(musica != null && this.quantMusicas < 100){
            playlist[this.quantMusicas] = musica;
            this.quantMusicas++;
            return true;
        }
        return false;
    }

    public Musica getNaPosicao(int indice){
        if(indice < this.quantMusicas){ //a quantidade de músicas sempre vai ser indice+1. Pois o índice começa no 0 ao invés do 1.
            return this.playlist[indice];
        }
        return null;
    }

    public boolean removerNaPosicao(int indice){
        if(indice < 0 || indice >= this.quantMusicas){ 
            return false; 
        }

        for(int i=indice; i<this.quantMusicas - 1; i++){
            this.playlist[i] = this.playlist[i + 1]; //a musica vai ser removida ao ser sobrescrita pela do indice seguinte.
        }

        this.playlist[this.quantMusicas - 1] = null; //apaga a ultima musica da playlist pois se tornou repetida.
        this.quantMusicas --;

        return true;
    }

    public int getDuracaoTotalSegundos(){
        int totalSegundos = 0;
        for(int i=0; i<this.quantMusicas; i++){
            totalSegundos += this.playlist[i].getDuracaoSegundos();
        }
        return totalSegundos;
    }

    public void reproduzirTudo(){
        for(int i=0; i<this.quantMusicas; i++){
            this.playlist[i].reproduzir();
        }
    }
}
