package fase02;

public class Usuario {

    private int id;
    private static int contador = 0;
    private String nome;
    private String email;

    public Usuario(String nome, String email){
        this.nome = nome;
        this.email = email;
    
        setId();
    }

    private void setId(){
        contador++;
        this.id = contador; 
    }

    public int getId(){
        return id;
    }

    public String getNome(){
        return this.nome;
    }

    public String getEmail(){
        return this.email;
    }
}
