package fase07;

import fase07.utilitarios.Leitor;

public class App {
    private Plataforma plataforma;
    private Playlist playlist;
    private Leitor leitor;

    public App() {
        this.plataforma = new Plataforma();
        this.leitor = new Leitor();

        Conteudo c = new Podcast("Piloto", "Camila", 1, 120);
        // Conteudo - tipo estático
        // Podcast - tipo dinâmico

        // c.getApresentador();
        /*
        - A linha acima não compila pois é verificado primeiramente o tipo estático
        - (Conteúdo), para depois verificar o tipo dinâmico. Nesse caso, getApresentador 
        - não existe em Conteúdo, por isso ocorre o erro de compilação.
        */

        popularAcervo();
        popularAnunciosIniciais();
        menu();
    }

    private void popularAcervo() {
        System.out.println("\n----- Populando Acervo de Testes -----");

        Musica[] bancoDeTestesMusicas = new Musica[] {
                new Musica("Bohemian Rhapsody", "Queen", "A Night at the Opera", 354),
                new Musica("Song 2", "Blur", "Blur", 122),
                new Musica("Hotel California", "Eagles", "Hotel California", 390),
                new Musica("Billie Jean", "Michael Jackson", "Thriller", 294),
                new Musica("Short Song", "Test Band", "Test Album", 65),
        };

        for (Musica m : bancoDeTestesMusicas) {
            plataforma.cadastrarConteudo(m);
        }

        Podcast[] bancoDeTestesPodcasts = new Podcast[] {
                new Podcast("Tech Cast", "João Silva", 1, 1800),
                new Podcast("História em Pauta", "Maria Souza", 12, 2400),
                new Podcast("Tech Cast 2", "João Silva", 2, 1800)
        };

        for (Podcast p : bancoDeTestesPodcasts) {
            plataforma.cadastrarConteudo(p);
        }

        System.out.println("Acervo populado com sucesso!");
    }

    private void popularAnunciosIniciais() {
        try {
            plataforma.cadastrarAnuncio(new Anuncio("Torrefacao Serrana", "Cafe da Serra", 30, 15.0));
            plataforma.cadastrarAnuncio(new Anuncio("Tech Store", "Smartphone X", 30, 20.0));
        } catch (Exception e) {
            // Ignora se houver erro nos dados de teste predefinidos
        }
    }

    private void menu() {
        boolean continuar = true;
        int opcao;

        do {
            System.out.println("\n=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente");
            System.out.println("2 - Cadastrar podcast manualmente");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Criar playlist e adicionar conteúdos");
            System.out.println("5 - Buscar conteúdo por id");
            System.out.println("6 - Buscar conteúdo por título");
            System.out.println("7 - Remover um conteúdo da playlist");
            System.out.println("8 - Pesquisar conteúdo da playlist");
            System.out.println("9 - Reproduzir um conteúdo");
            System.out.println("10 - Listar acervo completo");
            System.out.println("11 - Seguir um usuário");
            System.out.println("12 - Deixar de seguir um usuário");
            System.out.println("13 - Quantidade de pessoas seguindo");
            System.out.println("14 - Alterar plano de um usuário");
            System.out.println("15 - Exibir resumo do plano do usuário");
            System.out.println("16 - Exibir receita mensal da plataforma");
            System.out.println("17 - Listar podcasts do apresentador");
            System.out.println("18 - Cadastrar anúncio");
            System.out.println("19 - Tocar playlist");
            System.out.println("0 - Sair");

            opcao = leitor.lerInteiro("Digite a opção:");
            switch (opcao) {
                case 1:
                    cadastrarMusicaManualmente();
                    break;
                case 2:
                    cadastrarPodcastManualmente();
                    break;
                case 3:
                    cadastrarUsuario();
                    break;
                case 4:
                    criarPlaylist();
                    break;
                case 5:
                    buscarConteudoId();
                    break;
                case 6:
                    buscarConteudoPorTitulo();
                    break;
                case 7:
                    removerConteudoPlaylist();
                    break;
                case 8:
                    pesquisarConteudoPlaylist();
                    break;
                case 9:
                    reproduzirConteudo();
                    break;
                case 10:
                    listarAcervoConteudo();
                    break;
                case 11:
                    seguirOutroUsuario();
                    break;
                case 12:
                    deixarDeSeguirOutroUsuario();
                    break;
                case 13:
                    quantSeguindoUsuarios();
                    break;
                case 14:
                    alterarPlanoUsuario();
                    break;
                case 15:
                    exibirResumoPlanoUsuario();
                    break;
                case 16:
                    exibirReceitaMensalPlataforma();
                    break;
                case 17:
                    listarPodcastDoApresentador();
                    break;
                case 18:
                    cadastrarAnuncioManualmente();
                    break;
                case 19:
                    tocarPlaylistParaUsuario();
                    break;
                case 0:
                    System.out.println("Até à próxima!");
                    continuar = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (continuar);
    }

    private void cadastrarMusicaManualmente() {
        System.out.println("\n ----- Cadastrar Nova Música -----");
        String titulo = leitor.lerTexto("Título:");
        String artista = leitor.lerTexto("Artista:");
        String album = leitor.lerTexto("Álbum:");
        int duracaoSegundos = leitor.lerInteiro("Duração em segundos:");

        try {
            Musica novaMusica = new Musica(titulo, artista, album, duracaoSegundos);
            boolean sucesso = plataforma.cadastrarConteudo(novaMusica);
            if (sucesso) {
                System.out.println("Música cadastrada com sucesso. ID: " + novaMusica.getId());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar música: " + e.getMessage());
        }
    }

    private void cadastrarPodcastManualmente() {
        System.out.println("\n ----- Cadastrar Novo Podcast -----");
        String titulo = leitor.lerTexto("Título:");
        String apresentador = leitor.lerTexto("Apresentador:");
        int numeroEpisodio = leitor.lerInteiro("Número do Episódio:");
        int duracaoSegundos = leitor.lerInteiro("Duração em segundos:");

        try {
            Podcast novoPodcast = new Podcast(titulo, apresentador, numeroEpisodio, duracaoSegundos);
            boolean sucesso = plataforma.cadastrarConteudo(novoPodcast);
            if (sucesso) {
                System.out.println("Podcast cadastrado com sucesso. ID: " + novoPodcast.getId());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar podcast: " + e.getMessage());
        }
    }

    private void cadastrarUsuario() {
        System.out.println("\n ----- Cadastrar Novo Usuário -----");
        String nome = leitor.lerTexto("Nome:");
        String email = leitor.lerTexto("E-mail:");

        try {
            Usuario novoUsuario = new Usuario(nome, email);
            boolean sucesso = plataforma.cadastrarUsuario(novoUsuario);

            if (sucesso) {
                System.out.println("Usuário cadastrado com sucesso. ID: " + novoUsuario.getId() + " (Plano inicial: Gratuito)");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }
    }

    private void cadastrarAnuncioManualmente() {
        System.out.println("\n ----- Cadastrar Novo Anúncio -----");
        String anunciante = leitor.lerTexto("Anunciante:");
        String titulo = leitor.lerTexto("Título do Anúncio:");
        int duracaoSegundos = leitor.lerInteiro("Duração em segundos:");
        double valorMil = leitor.lerDouble("Valor por mil impressões (R$):");

        try {
            Anuncio novoAnuncio = new Anuncio(anunciante, titulo, duracaoSegundos, valorMil);
            plataforma.cadastrarAnuncio(novoAnuncio);
            System.out.println("Anúncio cadastrado com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao cadastrar anúncio: " + e.getMessage());
        }
    }

    private void criarPlaylist() {
        System.out.println("\n ----- Criar Nova Playlist -----");
        String nomePlaylist = leitor.lerTexto("Digite o nome da playlist:");
        int idUsuario = leitor.lerInteiro("Digite o ID do usuário criador da playlist:");

        try {
            Usuario donoEncontrado = plataforma.buscarUsuario(idUsuario);
            if (donoEncontrado == null) {
                System.out.println("Usuário com ID " + idUsuario + " não foi encontrado.");
                return;
            }
            this.playlist = new Playlist(nomePlaylist, donoEncontrado);
            System.out.println("Playlist criada com sucesso.");
            adicionarConteudo();
        } catch (IllegalStateException | IllegalArgumentException e) {
            System.out.println("Erro ao criar a playlist: " + e.getMessage());
        }
    }

    private void adicionarConteudo() {
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist ativa.");
            return;
        }

        System.out.println("\n ----- Adicionar Conteúdo na Playlist -----");

        while (true) {
            int id = leitor.lerInteiro("Digite o ID do conteúdo para adicionar (ou 0 para sair):");

            if (id == 0) {
                System.out.println("Parando de adicionar conteúdos.");
                break;
            }

            Conteudo conteudoEncontrado = plataforma.buscarConteudo(id);

            if (conteudoEncontrado != null) {
                boolean sucesso = playlist.adicionarConteudo(conteudoEncontrado);

                if (sucesso) {
                    System.out.println("Conteúdo '" + conteudoEncontrado.getTitulo() + "' adicionado à playlist '"
                            + playlist.getNome() + "'!");
                    System.out.println("Total de itens na playlist agora: " + playlist.getQuantidadeConteudo());
                    System.out.println("Duração total da playlist: " + playlist.getDuracaoTotalSegundos() + "s\n");
                }
            } else {
                System.out.println("Nenhum conteúdo encontrado com o ID: " + id);
            }
        }
    }

    private void tocarPlaylistParaUsuario() {
        System.out.println("\n ----- Tocar Playlist para Usuário -----");
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist foi criada ainda. Crie uma primeiro (Opção 4).");
            return;
        }

        int idUsuario = leitor.lerInteiro("Digite o ID do usuário ouvinte:");
        Usuario ouvinte = plataforma.buscarUsuario(idUsuario);
        if (ouvinte == null) {
            System.out.println("Usuário não encontrado.");
            return;
        }

        System.out.println("\n--- [Demonstração] Receita mensal ANTES de tocar a playlist ---");
        exibirReceitaMensalPlataforma();

        System.out.println("\nReproduzindo playlist para " + ouvinte.getNome() + " (Plano: " + ouvinte.getPlano().getNome() + ")...");
        plataforma.tocarPlaylist(ouvinte, this.playlist);

        System.out.println("\n--- [Demonstração] Receita mensal DEPOIS de tocar a playlist ---");
        exibirReceitaMensalPlataforma();
    }

    private void buscarConteudoId() {
        System.out.println("\n ----- Buscar Conteúdo por ID -----");
        int id = leitor.lerInteiro("Digite o ID:");
        Conteudo conteudo = plataforma.buscarConteudo(id);

        if (conteudo == null) {
            System.out.println("Não foi possível encontrar nenhum conteúdo com o ID: " + id);
        } else {
            System.out.println(conteudo.toString());
            System.out.println("Duração formatada: " + conteudo.getDuracaoFormatada());
            System.out.println("Reproduções: " + conteudo.getReproducoes());

            if (conteudo instanceof Musica) {
                Musica m = (Musica) conteudo;
                System.out.println("Artista: " + m.getArtista());
                System.out.println("Álbum: " + m.getAlbum());
            } else if (conteudo instanceof Podcast) {
                Podcast p = (Podcast) conteudo;
                System.out.println("Apresentador: " + p.getApresentador());
                System.out.println("Episódio: " + p.getNumeroEpisodio());
            }
        }
    }

    private void buscarConteudoPorTitulo() {
        System.out.println("\n ----- Buscar Conteúdo pelo Título -----");
        String titulo = leitor.lerTexto("Digite o título:");
        Conteudo conteudo = plataforma.buscarConteudo(titulo);

        if (conteudo == null) {
            System.out.println("Não foi possível encontrar nenhum conteúdo com o título: " + titulo);
        } else {
            System.out.println(conteudo.toString());
            System.out.println("Duração formatada: " + conteudo.getDuracaoFormatada());
            System.out.println("Reproduções: " + conteudo.getReproducoes());

            if (conteudo instanceof Musica) {
                Musica m = (Musica) conteudo;
                System.out.println("Artista: " + m.getArtista());
                System.out.println("Álbum: " + m.getAlbum());
            } else if (conteudo instanceof Podcast) {
                Podcast p = (Podcast) conteudo;
                System.out.println("Apresentador: " + p.getApresentador());
                System.out.println("Episódio: " + p.getNumeroEpisodio());
            }
        }
    }

    private void removerConteudoPlaylist() {
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist foi criada ainda.");
            return;
        }

        System.out.println("\n ----- Remover Conteúdo da Playlist -----");
        int posicao = leitor.lerInteiro("Digite o índice do conteúdo a ser removido (0 a 99):");

        try {
            playlist.removerConteudoNaPosicao(posicao);
            System.out.println("Conteúdo removido da playlist com sucesso!");
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro de posição: " + e.getMessage());
        }
    }

    private void pesquisarConteudoPlaylist() {
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist foi criada ainda.");
            return;
        }

        if (playlist.getQuantidadeConteudo() == 0) {
            System.out.println("A playlist '" + playlist.getNome() + "' está vazia.");
            return;
        }

        int indice = leitor.lerInteiro("\nDigite o índice do conteúdo na playlist para pesquisar (0 a 99):");
        try {
            Conteudo m = playlist.getConteudoNaPosicao(indice);
            System.out.println("Índice na playlist: " + indice);
            System.out.println(m.toString());
            System.out.println("Reproduções: " + m.getReproducoes());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao acessar posição do conteúdo na playlist: " + e.getMessage());
        }
    }

    private void reproduzirConteudo() {
        System.out.println("\n ----- Reproduzir Conteúdo -----");
        int id = leitor.lerInteiro("Digite o ID do conteúdo:");
        Conteudo conteudoEncontrado = plataforma.buscarConteudo(id);

        if (conteudoEncontrado != null) {
            conteudoEncontrado.reproduzir();
        } else {
            System.out.println("Nenhum conteúdo encontrado com o ID: " + id);
        }
    }

    private void listarAcervoConteudo() {
        System.out.println("\n ----- Acervo Completo de Conteúdos -----");
        if (plataforma.getTotalConteudos() == 0) {
            System.out.println("Nenhum conteúdo cadastrado no acervo.");
        } else {
            for (int i = 1; i <= plataforma.getTotalConteudos(); i++) {
                Conteudo c = plataforma.buscarConteudo(i);
                if (c != null) {
                    System.out.println("ID: " + c.getId() + " | " + c.toString() + " | Reproduções: " + c.getReproducoes());
                }
            }
        }
    }

    private Usuario pesquisarUsuario(String mensagemPersonalizada) {
        int idUsuario = leitor.lerInteiro(mensagemPersonalizada);
        try {
            return plataforma.buscarUsuario(idUsuario);
        } catch (IllegalStateException e) {
            System.out.println("Erro ao encontrar usuário: " + e.getMessage());
        }
        return null;
    }

    private void seguirOutroUsuario() {
        System.out.println("\n ----- Seguir Usuário -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário que vai SEGUIR:");
        if (usuarioConta == null) return;

        Usuario outroUsuario = pesquisarUsuario("Digite o ID do usuário que VAI SER SEGUIDO:");
        if (outroUsuario == null) return;

        try {
            usuarioConta.seguir(outroUsuario);
            System.out.println("Usuário seguido com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void deixarDeSeguirOutroUsuario() {
        System.out.println("\n ----- Deixar de Seguir Usuário -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário principal:");
        if (usuarioConta == null) return;

        Usuario outroUsuario = pesquisarUsuario("Digite o ID do usuário que VAI DEIXAR DE SER SEGUIDO:");
        if (outroUsuario == null) return;

        try {
            usuarioConta.deixarDeSeguir(outroUsuario);
            System.out.println("Deixou de seguir este usuário com sucesso!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private void quantSeguindoUsuarios() {
        System.out.println("\n ----- Consultar Quantidade de Seguidos -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário que deseja consultar:");
        if (usuarioConta != null) {
            System.out.println("A quantidade de usuários seguidos por " + usuarioConta.getNome() + " é: "
                    + usuarioConta.getQuantidadeSeguindo());
        }
    }

    private void alterarPlanoUsuario() {
        System.out.println("\n ----- Alterar Plano do Usuário -----");
        Usuario usuario = pesquisarUsuario("Digite o ID do usuário:");
        if (usuario == null) return;

        System.out.println("Escolha o novo plano:");
        System.out.println("1 - Plano Gratuito");
        System.out.println("2 - Plano Individual (Pago)");
        System.out.println("3 - Plano Família (Pago)");
        int escolha = leitor.lerInteiro("Opção:");

        try {
            Plano novoPlano = null;
            if (escolha == 1) {
                novoPlano = new PlanoGratuito();
            } else if (escolha == 2) {
                double preco = leitor.lerDouble("Digite o preço mensal do plano individual:");
                novoPlano = new PlanoIndividual(preco);
            } else if (escolha == 3) {
                double preco = leitor.lerDouble("Digite o preço base mensal do plano família:");
                int membros = leitor.lerInteiro("Digite a quantidade de membros (1 a 6):");
                novoPlano = new PlanoFamilia(preco, membros);
            } else {
                System.out.println("Opção de plano inválida.");
                return;
            }

            usuario.assinar(novoPlano);
            System.out.println("Plano alterado com sucesso para " + usuario.getPlano().getNome() + "!");
        } catch (IllegalArgumentException e) {
            System.out.println("Erro ao assinar plano: " + e.getMessage());
        }
    }

    private void exibirResumoPlanoUsuario() {
        System.out.println("\n ----- Resumo do Plano do Usuário -----");
        Usuario usuario = pesquisarUsuario("Digite o ID do usuário:");
        if (usuario == null) return;

        System.out.println("Usuário: " + usuario.getNome());
        System.out.println("Plano Atual -> " + usuario.getPlano().resumo());
        System.out.println("Possui Anúncios - " + (usuario.getPlano().temAnuncios() ? "Sim" : "Não"));
    }

    private void exibirReceitaMensalPlataforma() {
        System.out.printf("A receita mensal da plataforma é: R$ %.2f\n", plataforma.calcularReceitaMensal());
    }

    private void listarPodcastDoApresentador() {
        String apresentador = leitor.lerTexto("Digite o nome do apresentador que deseja procurar: ");
        plataforma.listarEpisodiosDe(apresentador);
    }

    public static void main(String[] args) {
        new App();
    }
}