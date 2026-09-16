package fase04;

import java.util.ArrayList;

public class Playlist {

    private ArrayList<Musica> playlist = new ArrayList<>();
    private String nome;
    private Usuario dono; //a variável dono recebe somente objetos da classe Usuario 

    public Playlist(String nome, Usuario dono){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }else if(dono == null){
            throw new IllegalArgumentException("É necessário um dono válido para criar a playlist.");
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

    public int getQuantidadeMusicas(){
        return this.playlist.size();
    }

    public boolean adicionarMusica(Musica musica){
        if(musica == null){
            throw new IllegalArgumentException("Não é possível adicionar uma música em branco.");
        }

        playlist.add(musica);
        return true;
    }

    public Musica getMusicaNaPosicao(int indice){
        if(indice < 0 || indice > 99){
            throw new IndexOutOfBoundsException("Os indices devem estar presentes no intervalo de 0 a 99.");
        }else if(indice >= this.playlist.size()){//a quantidade de músicas sempre vai ser indice+1. Pois o índice começa no 0 ao invés do 1.
            throw new IndexOutOfBoundsException("Ainda não foi adicionado uma música com id " + indice + " nesta playlist.");
        }
        return this.playlist.get(indice);
    }

    public void removerMusicaNaPosicao(int indice){
        if(indice < 0 || indice > 99){
            throw new IndexOutOfBoundsException("Os indices devem estar presentes no intervalo de 0 a 99.");
        }else if(indice >= this.playlist.size()){//a quantidade de músicas sempre vai ser indice+1. Pois o índice começa no 0 ao invés do 1.
            throw new IndexOutOfBoundsException("Ainda não foi adicionado uma música com id " + indice + " nesta playlist.");
        }

        for(int i=indice; i<this.playlist.size() - 1; i++){
            this.playlist.set(i, this.playlist.get(i+1)); //a musica vai ser removida ao ser sobrescrita pela do indice seguinte.
        }
        this.playlist.set(this.playlist.size() - 1, null);
    }

    public int getDuracaoTotalSegundos(){
        int totalSegundos = 0;
        for(int i=0; i<this.playlist.size(); i++){
            totalSegundos += this.playlist.get(i).getDuracaoSegundos();
        }
        return totalSegundos;
    }

    public void reproduzirTudo(){
        for(int i=0; i<this.playlist.size(); i++){
            this.playlist.get(i).reproduzir();
        }
    }
}
