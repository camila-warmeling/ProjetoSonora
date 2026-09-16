package fase04;

import java.util.ArrayList;

public class Plataforma {
    private ArrayList<Musica> acervoMusicas = new ArrayList<>();
    private ArrayList<Usuario> acervoUsuarios = new ArrayList<>();

    public boolean cadastrarMusica(Musica musica){
        if(musica == null){
            throw new IllegalArgumentException("Não é possível criar uma música vazio.");
        }
        this.acervoMusicas.add(musica);  
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("Não é possível criar um usuário vazio.");
        }
        this.acervoUsuarios.add(usuario);

        return true;
    }

    public Musica buscarMusica(int id){
        for(int i=0; i<acervoMusicas.size(); i ++){
            if(this.acervoMusicas.get(i).getId() == id){
                return this.acervoMusicas.get(i);
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo){
        for(int i=0; i<this.acervoMusicas.size(); i ++){
            if(this.acervoMusicas.get(i).getTitulo().equalsIgnoreCase(titulo)){
                return this.acervoMusicas.get(i);
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int id){
        if(this.acervoUsuarios.size() == 0){
            throw new IllegalStateException("Não foi criado nenhum usuário ainda.");
        }
        for(int i=0; i<this.acervoUsuarios.size(); i ++){
            if(this.acervoUsuarios.get(i).getId() == id){
                return this.acervoUsuarios.get(i);
            }
        }
        return null;
    }
}   
