package fase03;

public class Usuario {

    private int id;
    private static int contador = 0;
    private String nome;
    private String email;

    public Usuario(String nome, String email){
        if(nome == null || nome.trim().isEmpty()){
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        }else if(email == null || email.trim().isEmpty()){
            throw new IllegalArgumentException("O email não pode ser vazio.");
        }else if(!email.contains("@")){
            throw new IllegalArgumentException("O email deve conter '@'.");
        }
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
