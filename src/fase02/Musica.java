package fase02;

public class Musica {

    private String titulo;
    private String artista;
    private int duracaoSegundos;
    private int id;
    //método static - pertence a classe e não ao objeto. Ou seja, ao instanciar um novo objeto, o contador não vai zerar, mas continuar a contagem a partir do último valor que recebeu.
    private static int contador = 0; 
    private int reproducoes = 0;


    public Musica(String titulo, String artista, int duracaoSegundos){
        //trim() - tira todos os espaços em branco
        //isEmpty() - retorna true se o tamanho da string for zero
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }
        this.titulo = titulo;

        if(artista == null || artista.trim().isEmpty()){
            throw new IllegalArgumentException("O artista não pode ser vazio.");
        }
        this.artista = artista;

        if(duracaoSegundos <= 0){
            throw new IllegalArgumentException("A duração da música deve ser de pelo menos 1 segundo.");
        }
        this.duracaoSegundos = duracaoSegundos;

        setId(); //atribui um id para o objeto no momento em que é instanciado
    }

    private void setId(){
        contador++;
        this.id = contador; 
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public String getArtista(){
        return this.artista;
    }

    public int getDuracaoSegundos(){
        return this.duracaoSegundos;
    }

    public int getReproducoes(){
        return this.reproducoes;
    }

    public void reproduzir(){
        reproducoes ++;
    }

    public String getDuracaoFormatada(){
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
         
        return String.format("%02d:%02d", minutos, segundos);
    }
}
