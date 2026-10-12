package fase07;

import java.util.ArrayList;
import java.util.List;

public class Plataforma {
    private ArrayList<Conteudo> acervoConteudos = new ArrayList<>();
    private ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    private ArrayList<Anuncio> anunciosCadastrados = new ArrayList<>();

    public boolean cadastrarConteudo(Conteudo conteudo) {
        if (conteudo == null) {
            throw new IllegalArgumentException("Não é possível criar um conteúdo vazio.");
        }
        this.acervoConteudos.add(conteudo);
        return true;
    }

    public boolean cadastrarUsuario(Usuario usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("Não é possível criar um usuário vazio.");
        }
        this.listaUsuarios.add(usuario);
        return true;
    }

    public boolean cadastrarAnuncio(Anuncio anuncio) {
        if (anuncio == null) {
            throw new IllegalArgumentException("Não é possível criar um anúncio vazio.");
        }
        this.anunciosCadastrados.add(anuncio);
        return true;
    }

    public Conteudo buscarConteudo(int id) {
        for (int i = 0; i < acervoConteudos.size(); i++) {
            if (this.acervoConteudos.get(i).getId() == id) {
                return this.acervoConteudos.get(i);
            }
        }
        return null;
    }

    public Conteudo buscarConteudo(String titulo) {
        for (int i = 0; i < this.acervoConteudos.size(); i++) {
            if (this.acervoConteudos.get(i).getTitulo().equalsIgnoreCase(titulo)) {
                return this.acervoConteudos.get(i);
            }
        }
        return null;
    }

    public Usuario buscarUsuario(int id) {
        if (this.listaUsuarios.size() == 0) {
            throw new IllegalStateException("Não foi criado nenhum usuário ainda.");
        }
        for (int i = 0; i < this.listaUsuarios.size(); i++) {
            if (this.listaUsuarios.get(i).getId() == id) {
                return this.listaUsuarios.get(i);
            }
        }
        return null;
    }

    public int getTotalConteudos() {
        return this.acervoConteudos.size();
    }

    public int getTotalUsuarios() {
        return this.listaUsuarios.size();
    }

    public double calcularReceitaMensal() {
        List<Faturavel> faturaveis = new ArrayList<>();

        for (Usuario usuario : listaUsuarios) {
            if (usuario.getPlano() != null) {
                faturaveis.add(usuario.getPlano());
            }
        }
        
        faturaveis.addAll(anunciosCadastrados);

        double total = 0.0;
        for (Faturavel item : faturaveis) {
            total += item.calcularMensalidade();
        }

        return total;
    }

    public void listarEpisodiosDe(String apresentador) {
        boolean encontrouApresentador = false;

        for (Conteudo conteudo : acervoConteudos) {
            if (conteudo instanceof Podcast) {
                // downcasting (descer um nível) - sai do tipo genérico para um específico
                if (((Podcast) conteudo).getApresentador().equalsIgnoreCase(apresentador)) {
                    System.out.println(conteudo.toString());
                    encontrouApresentador = true;
                }
            }
        }

        if (encontrouApresentador == false) {
            System.out.println("Não foi possível encontrar nenhum podcast com o apresentador: " + apresentador);
        }
    }
}