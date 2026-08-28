package fase02;

public class Usuario {

    private int id;
    private static int contador = 0;
    private String nome;
    private String email;

    public Usuario(String nome, String email){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        this.nome = nome;

        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }
        if(!email.contains("@")){
            throw new IllegalArgumentException("O nome não pode ser vazio nem nulo");
        }
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
