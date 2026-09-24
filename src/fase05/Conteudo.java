package fase05;

public class Conteudo {
    
    private static int contador = 0;
    private int id;
    private String titulo;
    private int duracaoSegundos;
    
    public Conteudo(String titulo, int duracaoSegundos){
        this.id = ++contador;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
    }

    public int getId(){
        return id;
    }

    protected void setId(int id){
        this.id = id; 
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("O título não pode ser vazio.");
        }

        this.titulo = titulo;
    }

    public int getDuracaoSegundos(){
        return this.duracaoSegundos;
    }

    public void setDuracaoSegundos(int duracaoSegundos){
        if(duracaoSegundos <= 0){
            throw new IllegalArgumentException("A duração da música deve ser maior que 0. Número digitado: " + duracaoSegundos);
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public void reproduzir(){
        System.err.println("Reproduzindo: " + toString());
    }

    @Override 
    public String toString(){
        return "[" + getId()  + "]" + titulo + "(" + duracaoSegundos + "s)";
    }

}
