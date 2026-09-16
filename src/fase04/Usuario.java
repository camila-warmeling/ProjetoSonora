package fase04;

import java.util.ArrayList;

public class Usuario {

    private int id;
    private static int contador = 0;
    private String nome;
    private String email;
    private ArrayList<Usuario> seguindo;

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
        this.seguindo = new ArrayList<>();
    
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

    public void seguir(Usuario outro){
        if(outro == null){
            throw new IllegalArgumentException("O usuário que vai ser seguido não pode ser nulo.");
        }else if(this == outro){
            throw new IllegalArgumentException("O usuário não pode seguir ele mesmo.");
        }else if(seguindo.contains(outro)){
            throw new IllegalArgumentException("Este usuário já está sendo seguido.");
        }

        seguindo.add(outro);
    }

    public void deixarDeSeguir(Usuario outro){

    }

    public int getQuantidadeSeguindo(){
        return this.seguindo.size();
    }
}
