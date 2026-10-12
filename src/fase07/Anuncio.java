package fase07;

public class Anuncio {

    private String anunciante;
    private String titulo;
    private int duracaoSegundos;
    private int valorPorMilImpressoes;
    private int impressoes = 0;

    public Anuncio(String anunciante, String titulo, int duracaoSegundos, double valorPorMilImpressoes){
        setAnunciante(anunciante);
        setTitulo(titulo);
    }

    public String getAnunciante(){
        return this.anunciante;
    }

    public void setAnunciante(String anunciante){
        if(anunciante == null || anunciante.trim().isEmpty()){
            throw new IllegalArgumentException("Não é possível criar um anunciante vazio.");
        }
        this.anunciante = anunciante;
    }

    public String getTitulo(){
        return this.titulo;
    }

    public void setTitulo(String titulo){
        if(titulo == null || titulo.trim().isEmpty()){
            throw new IllegalArgumentException("Não é possível criar um titulo vazio para o anúncio.");
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

    public double getValorPorMilImpressoes(){
        return this.valorPorMilImpressoes;
    }

    public void setValorPorMilImpressoes(int valorPorMilImpressoes){
        if(valorPorMilImpressoes <= 0){
            throw new IllegalArgumentException("O valor por mil impressões deve ser maior que 0.");
        }
        this.valorPorMilImpressoes = valorPorMilImpressoes;
    }

    public int getImpressoes(){
        return this.impressoes;
    }

    public void reproduzir(){
        impressoes ++;
        System.out.printf("[Anuncio] %s - um oferecimento de %s" + titulo, anunciante);
    }

}
