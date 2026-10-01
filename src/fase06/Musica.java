package fase06;

public class Musica extends Conteudo {

    private String artista;
    private String album;

    public Musica(String titulo, String artista, String album, int duracaoSegundos) {
        super(titulo, duracaoSegundos);
        if (artista == null || artista.trim().isEmpty()) {
            throw new IllegalArgumentException("O artista não pode ser vazio.");
        }
        setArtista(artista);
        setAlbum(album);
    }

    public String getArtista() {
        return this.artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getAlbum() {
        return this.album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    @Override
    public String toString() {
        return super.toString() + " - " + artista + " (" + album + ")";
    }

    @Override
    public String getCreditos() {
        return artista + " (" + album + ")";
    }
}
