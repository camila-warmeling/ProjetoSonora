package fase05;

import java.util.ArrayList;

public class Plataforma {
    private ArrayList<Conteudo> acervoConteudos = new ArrayList<>(); // Alterado para Conteudo
    private ArrayList<Usuario> acervoUsuarios = new ArrayList<>();

    public boolean cadastrarConteudo(Conteudo conteudo){ // Alterado de cadastrarMusica para cadastrarConteudo
        if(conteudo == null){
            throw new IllegalArgumentException("Não é possível criar um conteúdo vazio.");
        }
        this.acervoConteudos.add(conteudo);  
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("Não é possível criar um usuário vazio.");
        }
        this.acervoUsuarios.add(usuario);
        return true;
    }

    public Conteudo buscarConteudo(int id){ // Retorna Conteudo
        for(int i=0; i<acervoConteudos.size(); i++){
            if(this.acervoConteudos.get(i).getId() == id){
                return this.acervoConteudos.get(i);
            }
        }
        return null;
    }

    public Conteudo buscarConteudo(String titulo){ // Retorna Conteudo
        for(int i=0; i<this.acervoConteudos.size(); i++){
            if(this.acervoConteudos.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return this.acervoConteudos.get(i);
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int id){
        if(this.acervoUsuarios.size() == 0){
            throw new IllegalStateException("Não foi criado nenhum usuário ainda.");
        }
        for(int i=0; i<this.acervoUsuarios.size(); i++){
            if(this.acervoUsuarios.get(i).getId() == id){
                return this.acervoUsuarios.get(i);
            }
        }
        return null;
    }
    
    public int getTotalConteudos(){ // Renomeado para refletir o acervo geral
        return this.acervoConteudos.size();
    }

    public int getTotalUsuarios(){
        return this.acervoUsuarios.size();
    }
}