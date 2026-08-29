package fase02;

public class Playlist {

    private Musica[] playlist = new Musica[100];
    private String nome;
    private Usuario dono; //a variável dono recebe somente objetos da classe Usuario 
    private int quantMusicas;

    public Playlist(String nome, Usuario dono){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }else if(dono == null){
            throw new IllegalArgumentException("É necessário um dono para criar a playlist.");
        }
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
        if(musica == null){
            throw new IllegalArgumentException("Não é possível adicionar uma música em branco.");
        }

        if(this.quantMusicas < this.playlist.length){
            playlist[this.quantMusicas] = musica;
            this.quantMusicas++;
            return true;
        }
        return false;
    }

    public Musica getNaPosicao(int indice){
        if(indice < 0 || indice >= this.quantMusicas){//a quantidade de músicas sempre vai ser indice+1. Pois o índice começa no 0 ao invés do 1.
            throw new IndexOutOfBoundsException("o índice " + indice + " não existe nessa playlist.");
        }
        return this.playlist[indice];
    }

    public void removerNaPosicao(int indice){
        if(indice < 0 || indice >= this.quantMusicas){ 
            throw new IndexOutOfBoundsException("o índice " + indice + " não existe nessa playlist.");
        }

        for(int i=indice; i<this.quantMusicas - 1; i++){
            this.playlist[i] = this.playlist[i + 1]; //a musica vai ser removida ao ser sobrescrita pela do indice seguinte.
        }
        this.playlist[this.quantMusicas - 1] = null; //apaga a ultima musica da playlist pois se tornou repetida.
        this.quantMusicas --;
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
