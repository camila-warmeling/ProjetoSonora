package fase07;

public abstract class Conteudo {
    
    private static int contadorId = 0;
    private int id;
    private String titulo;
    private int duracaoSegundos;
    private int reproducoes = 0; 
    
    public Conteudo(String titulo, int duracaoSegundos){
        this.id = ++contadorId;
        setTitulo(titulo);
        setDuracaoSegundos(duracaoSegundos);
    }

    public int getId(){
        return id;
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
            throw new IllegalArgumentException("A duração deve ser maior que 0.");
        }
        this.duracaoSegundos = duracaoSegundos;
    }

    public String getDuracaoFormatada(){
        int minutos = duracaoSegundos / 60;
        int segundos = duracaoSegundos % 60;
        return String.format("%02d:%02d", minutos, segundos);
    }

    public int getReproducoes() {
        return this.reproducoes;
    }
    
    public final void reproduzir(){
        reproducoes++;
        System.out.println("Reproduzindo: " + getTitulo() + " - " + getCreditos());
    }

    @Override 
    public String toString(){
        return "[" + getId() + "] " + titulo + " (" + getDuracaoFormatada() + ")";
    }

    public abstract String getCreditos();
}