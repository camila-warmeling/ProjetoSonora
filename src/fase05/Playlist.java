package fase05;

import java.util.ArrayList;

public class Playlist {

    private ArrayList<Musica> playlist = new ArrayList<>();
    private String nome;
    private Usuario dono; 

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
        }else if(indice >= this.playlist.size()){
            throw new IndexOutOfBoundsException("Ainda não foi adicionada uma música com índice " + indice + " nesta playlist.");
        }
        return this.playlist.get(indice);
    }

    public void removerMusicaNaPosicao(int indice){
        if(indice < 0 || indice > 99){
            throw new IndexOutOfBoundsException("Os indices devem estar presentes no intervalo de 0 a 99.");
        }else if(indice >= this.playlist.size()){
            throw new IndexOutOfBoundsException("Ainda não foi adicionada uma música com índice " + indice + " nesta playlist.");
        }
        this.playlist.remove(indice);
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