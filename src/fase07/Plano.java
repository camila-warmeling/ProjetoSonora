package fase07;

public abstract class Plano {

    private String nome;
    private int maxDispositivos;

    public Plano(String nome, int maxDispositivos) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser vazio.");
        } else if (maxDispositivos < 1) {
            throw new IllegalArgumentException("O número máximo de dispositivos deve ser maior que 0.");
        }
        this.nome = nome;
        this.maxDispositivos = maxDispositivos;
    }

    public String getNome() {
        return nome;
    }

    public int getMaxDispositivos() {
        return maxDispositivos;
    }

    public abstract boolean temAnuncios();

    public abstract double calcularMensalidade();

    public String resumo() {
        return nome + ": R$ " + calcularMensalidade()
                + " por mes, " + maxDispositivos + " dispositivo(s)";
    }
}
