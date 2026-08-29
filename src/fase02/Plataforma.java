package fase02;

public class Plataforma {
    private Musica[] acervoMusicas = new Musica[500];
    private Usuario[] acervoUsuarios = new Usuario[500];
    private int quantMusicas = 0;
    private int quantUsuarios = 0;

    public boolean cadastrarMusica(Musica musica){
        if(musica == null){
            throw new IllegalArgumentException("Não é possível criar uma música vazio.");
        }
        if(this.quantMusicas < this.acervoMusicas.length){
            this.acervoMusicas[this.quantMusicas] = musica;
            this.quantMusicas ++;
            return true;
        }
        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if(usuario == null){
            throw new IllegalArgumentException("Não é possível criar um usuário vazio.");
        }
        if(this.quantUsuarios < this.acervoUsuarios.length){
            this.acervoUsuarios[this.quantUsuarios] = usuario;
            this.quantUsuarios ++;
            return true;
        }

        return false;
    }

    public Musica buscarMusica(int id){
        for(int i=0; i<this.quantMusicas; i ++){
            if(this.acervoMusicas[i].getId() == id){
                return this.acervoMusicas[i];
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo){
        for(int i=0; i<this.quantMusicas; i ++){
            if(this.acervoMusicas[i].getTitulo().equalsIgnoreCase(titulo)){
                return this.acervoMusicas[i];
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int id){
        for(int i=0; i<this.quantUsuarios; i ++){
            if(this.acervoUsuarios[i].getId() == id){
                return this.acervoUsuarios[i];
            }
        }
        return null;
    }

    public int getTotalMusicas(){
        return this.quantMusicas;
    }

    public int getTotalUsuarios(){
        return this.quantUsuarios;
    }
}   
