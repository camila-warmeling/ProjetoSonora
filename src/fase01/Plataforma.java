package fase01;

public class Plataforma {
    private Musica[] acervoMusicas = new Musica[500];
    private Usuario[] acervoUsuarios = new Usuario[500];
    private int quantMusicas = 0;
    private int quantUsuarios = 0;

    public boolean cadastrarMusica(Musica musica){
        if(musica != null && this.quantMusicas < this.acervoMusicas.length){
            this.acervoMusicas[this.quantMusicas] = musica;
            this.quantMusicas ++;
            return true;
        }
        return false;
    }

    public boolean cadastrarUsuario(Usuario usuario){
        if(usuario != null && this.quantUsuarios < this.acervoMusicas.length){
            this.acervoUsuarios[this.quantUsuarios] = usuario;
            this.quantUsuarios ++;
            return true;
        }

        return false;
    }

    public Musica buscarMusicaPorId(int id){
        for(int i=0; i<this.quantMusicas; i ++){
            if(this.acervoMusicas[i].getId() == id){
                return this.acervoMusicas[i];
            }
        }
        return null;
    }

    public Musica buscarMusica(String titulo){
        for(int i=0; i<this.quantMusicas; i ++){
            if(this.acervoMusicas[i].getTitulo() == titulo){
                return this.acervoMusicas[i];
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
