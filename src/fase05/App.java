package fase05;

import fase05.utilitarios.Leitor;

public class App {
    private Plataforma plataforma;
    private Playlist playlist;
    private Leitor leitor;

    public App(){
        this.plataforma = new Plataforma();
        this.leitor = new Leitor();
        popularAcervo();
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
            new Musica("Long Symphony", "Orchestra", "Classic", 600),
            new Musica("Smells Like Teen Spirit", "Nirvana", "Nevermind", 301),
            new Musica("Shape of You", "Ed Sheeran", "Divide", 233),
            new Musica("Blinding Lights", "The Weeknd", "After Hours", 200),
            new Musica("Take On Me", "a-ha", "Hunting High and Low", 225),
            new Musica("Wonderwall", "Oasis", "(What's the Story) Morning Glory?", 258),
            new Musica("Sweet Child O' Mine", "Guns N' Roses", "Appetite for Destruction", 356),
            new Musica("Californication", "Red Hot Chili Peppers", "Californication", 321),
            new Musica("In the End", "Linkin Park", "Hybrid Theory", 216),
            new Musica("Fast Track", "Quick Band", "Single", 45)
        };

        for(Musica m : bancoDeTestesMusicas){
            plataforma.cadastrarConteudo(m);
        }

        Podcast[] bancoDeTestesPodcasts = new Podcast[] {
            new Podcast("Tech Cast", "João Silva", 1, 1800),
            new Podcast("História em Pauta", "Maria Souza", 12, 2400)
        };

        for(Podcast p : bancoDeTestesPodcasts){
            plataforma.cadastrarConteudo(p);
        }

        System.out.println("Acervo populado com sucesso!");
    }
    
    private void menu(){
        boolean continuar = true;
        int opcao;

        do{
            System.out.println("\n=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente"); 
            System.out.println("2 - Cadastrar podcast manualmente");
            System.out.println("3 - Cadastrar usuário");
            System.out.println("4 - Criar playlist e adicionar músicas");
            System.out.println("5 - Buscar conteúdo por id");
            System.out.println("6 - Buscar conteúdo por título");
            System.out.println("7 - Remover uma música da playlist");
            System.out.println("8 - Pesquisar música da playlist");
            System.out.println("9 - Reproduzir um conteúdo");
            System.out.println("10 - Listar acervo completo");
            System.out.println("11 - Seguir um usuário");
            System.out.println("12 - Deixar de seguir um usuário");
            System.out.println("13 - Quantidade de pessoas seguindo");
            System.out.println("0 - Sair");

            opcao = leitor.lerInteiro("Digite a opção:");
            switch(opcao){
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
                    removerMusicaPlaylist();
                    break;

                case 8:
                    pesquisarMusicaPlaylist();
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

                case 0:
                    System.out.println("Até a próxima!");
                    continuar = false;
                    break;

                default:
                    System.out.println("Opção invalida!");
                    break;
            }
        }while(continuar);
    }

    private void cadastrarMusicaManualmente(){
        System.out.println("\n ----- Cadastrar Nova Música -----");

        String titulo = leitor.lerTexto("Titulo:");
        String artista = leitor.lerTexto("Artista:");
        String album = leitor.lerTexto("Álbum:");      
        int duracaoSegundos = leitor.lerInteiro("Duração em segundos:");
      
        try{
            Musica novaMusica = new Musica(titulo, artista, album, duracaoSegundos);
            boolean sucesso = plataforma.cadastrarConteudo(novaMusica);
            if(sucesso){
                System.out.println("Música cadastrada com sucesso. Id: " + novaMusica.getId());
            }else{       
                System.out.println("Falha ao cadastrar a nova música.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao cadastrar música: " + e.getMessage());
        }finally{
            System.out.println("Cadastro de música finalizado!");
        }
    }

    private void cadastrarPodcastManualmente(){
        System.out.println("\n ----- Cadastrar Novo Podcast -----");

        String titulo = leitor.lerTexto("Titulo:");
        String apresentador = leitor.lerTexto("Apresentador:");
        int numeroEpisodio = leitor.lerInteiro("Número do Episódio:");
        int duracaoSegundos = leitor.lerInteiro("Duração em segundos:");
      
        try{
            Podcast novoPodcast = new Podcast(titulo, apresentador, numeroEpisodio, duracaoSegundos);
            boolean sucesso = plataforma.cadastrarConteudo(novoPodcast);
            if(sucesso){
                System.out.println("Podcast cadastrado com sucesso. Id: " + novoPodcast.getId());
            }else{       
                System.out.println("Falha ao cadastrar o novo podcast.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao cadastrar podcast: " + e.getMessage());
        }finally{
            System.out.println("Cadastro de podcast finalizado!");
        }
    }

    private void cadastrarUsuario(){
        System.out.println("\n ----- Cadastrar Novo Usuário -----");

        String nome = leitor.lerTexto("Nome:");
        String email = leitor.lerTexto("E-mail:");

        try{
            Usuario novoUsuario = new Usuario(nome, email);
            boolean sucesso = plataforma.cadastrarUsuario(novoUsuario);
    
            if(sucesso){
                System.out.println("Usuário cadastrado com sucesso. Id: " + novoUsuario.getId());
            }else{
                System.out.println("Falha ao cadastrar o novo usuário.");
            }
        }catch(IllegalArgumentException e){
            System.out.println("Erro ao cadastrar usuário: " + e.getMessage());
        }finally{
            System.out.println("Cadastro de usuário finalizado!");
        }
    }

    private void criarPlaylist(){
        System.out.println("\n ----- Criar Nova Playlist -----");

        String nomePlaylist = leitor.lerTexto("Digite o nome da playlist:");
        int idUsuario = leitor.lerInteiro("Digite o id do usuário criador da playlist:");
        
        try{
            Usuario donoEncontrado = plataforma.buscarUsuario(idUsuario);
            if (donoEncontrado == null) {
                System.out.println("Usuário com ID " + idUsuario + " não foi encontrado.");
                return;
            }
            this.playlist = new Playlist(nomePlaylist, donoEncontrado);
            System.out.println("Playlist criada com sucesso.");
            adicionarMusicas();
        }catch(IllegalStateException | IllegalArgumentException e){
            System.out.println("Erro ao criar a playlist: " + e.getMessage());
        }
    }

    private void adicionarMusicas(){
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist ativa.");
            return;
        }

        System.out.println("\n ----- Adicionar Músicas na Playlist -----");

        while(true){            
            int id = leitor.lerInteiro("Digite o id da música para adicionar (ou 0 para sair):");

            if(id == 0){
                System.out.println("Parando de adicionar músicas.");
                break;
            }

            Conteudo conteudoEncontrado = plataforma.buscarConteudo(id);

            if(conteudoEncontrado != null){
                if(conteudoEncontrado instanceof Musica){
                    Musica musicaEncontrada = (Musica) conteudoEncontrado;
                    boolean sucesso = playlist.adicionarMusica(musicaEncontrada);

                    if(sucesso){
                        System.out.println("Música '" + musicaEncontrada.getTitulo() + "' adicionada à playlist '" + playlist.getNome() + "'!");
                        System.out.println("Total de músicas na playlist agora: " + playlist.getQuantidadeMusicas());
                        System.out.println("Duração total da playlist: " + playlist.getDuracaoTotalSegundos() + "s\n");
                    }
                }else{
                    System.out.println("O ID informado pertence a um Podcast. Apenas músicas podem ser adicionadas à playlist.");
                }
            }else{
                System.out.println("Nenhum conteúdo encontrado com o id: " + id);
            }
        }
    }

    private void buscarConteudoId(){
        System.out.println("\n ----- Buscar Conteúdo por ID -----");

        int id = leitor.lerInteiro("Digite o id:");
        Conteudo conteudo = plataforma.buscarConteudo(id);

        if(conteudo == null){
            System.out.println("Não foi possível encontrar nenhum conteúdo com o id: " + id);
        }else{
            System.out.println(conteudo.toString());
            System.out.println("Duração formatada: " + conteudo.getDuracaoFormatada());
            
            if(conteudo instanceof Musica){
                Musica m = (Musica) conteudo;
                System.out.println("Artista: " + m.getArtista());
                System.out.println("Álbum: " + m.getAlbum());
                System.out.println("Reproduções: " + m.getReproducoes());
            } else if(conteudo instanceof Podcast){
                Podcast p = (Podcast) conteudo;
                System.out.println("Apresentador: " + p.getApresentador());
                System.out.println("Episódio: " + p.getNumeroEpisodio());
                System.out.println("Reproduções: " + p.getReproducoes());
            }
        }
    }

    private void buscarConteudoPorTitulo(){
        System.out.println("\n ----- Buscar Conteúdo pelo Título -----");

        String titulo = leitor.lerTexto("Digite o título:");
        Conteudo conteudo = plataforma.buscarConteudo(titulo);

        if(conteudo == null){
            System.out.println("Não foi possível encontrar nenhum conteúdo com o titulo: " + titulo);
        }else{
            System.out.println(conteudo.toString());
            System.out.println("Duração formatada: " + conteudo.getDuracaoFormatada());
            
            if(conteudo instanceof Musica){
                Musica m = (Musica) conteudo;
                System.out.println("Artista: " + m.getArtista());
                System.out.println("Álbum: " + m.getAlbum());
                System.out.println("Reproduções: " + m.getReproducoes());
            } else if(conteudo instanceof Podcast){
                Podcast p = (Podcast) conteudo;
                System.out.println("Apresentador: " + p.getApresentador());
                System.out.println("Episódio: " + p.getNumeroEpisodio());
                System.out.println("Reproduções: " + p.getReproducoes());
            }
        }
    }

    private void removerMusicaPlaylist(){
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist foi criada ainda.");
            return;
        }

        System.out.println("\n ----- Remover Música da Playlist -----");
        int posicao = leitor.lerInteiro("Digite o índice da música a ser removida (0 a 99):");

        try{
            playlist.removerMusicaNaPosicao(posicao);            
            System.out.println("Música removida da playlist com sucesso!");
        }catch(IndexOutOfBoundsException e) {
            System.out.println("Erro de posição: " + e.getMessage());
        }catch(Exception e) {
            System.out.println("Ocorreu um erro inesperado ao remover: " + e.getMessage());
        }
    }

    private void pesquisarMusicaPlaylist(){
        if (this.playlist == null) {
            System.out.println("Nenhuma playlist foi criada ainda.");
            return;
        }

        if (playlist.getQuantidadeMusicas() == 0) {
            System.out.println("A playlist '" + playlist.getNome() + "' está vazia.");
            return;
        }

        int indice = leitor.lerInteiro("\nDigite o índice da música na playlist para pesquisar (0 a 99):");
        try {
            Musica m = playlist.getMusicaNaPosicao(indice);
                
            System.out.println("Índice na playlist: " + indice);
            System.out.println(m.toString());
            System.out.println("Artista: " + m.getArtista());
            System.out.println("Álbum: " + m.getAlbum());
            System.out.println("Duração: " + m.getDuracaoFormatada());
            System.out.println("Reproduções: " + m.getReproducoes());
        
        }catch(IndexOutOfBoundsException e){
            System.out.println("Erro ao acessar posição da música na playlist: " + e.getMessage());
        }catch(Exception e){
            System.out.println("Erro inesperado ao exibir a música da playlist: " + e.getMessage());
        }
    }
    
    private void reproduzirConteudo(){
        System.out.println("\n ----- Reproduzir Conteúdo -----");

        int id = leitor.lerInteiro("Digite o id do conteúdo:");
        Conteudo conteudoEncontrado = plataforma.buscarConteudo(id);

        if(conteudoEncontrado != null){
            conteudoEncontrado.reproduzir();
        }else{
            System.out.println("Nenhum conteúdo encontrado com o id: " + id);
        }
    }

    private void listarAcervoConteudo(){
        System.out.println("\n ----- Acervo Completo de Conteúdos -----");
        if(plataforma.getTotalConteudos() == 0){
            System.out.println("Nenhum conteúdo cadastrado no acervo.");
        }else{
            // Como os IDs podem não ser sequenciais exatos ou podem ter espaçamentos,
            // testamos uma varredura por IDs seguros ou exibimos via método genérico.
            // Aqui buscamos de 1 até o total estimado ou testamos IDs sequenciais.
            for(int i = 1; i <= plataforma.getTotalConteudos() + 20; i++){
                Conteudo c = plataforma.buscarConteudo(i);
                if(c != null){
                    System.out.println("ID: " + c.getId() + " | " + c.toString() + " | Duração: " + c.getDuracaoFormatada());
                }
            }
        }
    }

 private Usuario pesquisarUsuario(String mensagemPersonalizada){
        int idUsuario = leitor.lerInteiro(mensagemPersonalizada);
        
        try{
            Usuario usuario = plataforma.buscarUsuario(idUsuario);
            return usuario;
        }catch(IllegalStateException e){
            System.out.println("Erro ao encontrar usuário: " + e.getMessage());
        }
        return null;
    }

    private void seguirOutroUsuario(){
        System.out.println("\n ----- Seguir Usuário -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário que vai SEGUIR:");
        if(usuarioConta == null){
            System.out.println("Não foi possível encontrar o usuário principal.");
        }else{
            Usuario outroUsuario = pesquisarUsuario("Digite o ID do usuário que VAI SER SEGUIDO:");
            if(outroUsuario == null) {
                System.out.println("Não foi possível encontrar o usuário a ser seguido.");
                return;
            }
            
            try {
                usuarioConta.seguir(outroUsuario);
                System.out.println("Usuário seguido com sucesso!");
            } catch (IllegalArgumentException e) {
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void deixarDeSeguirOutroUsuario(){
        System.out.println("\n ----- Deixar de Seguir Usuário -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário principal:");
        if(usuarioConta == null){ 
            System.out.println("Não foi possível encontrar o usuário principal.");
        }else{
            Usuario outroUsuario = pesquisarUsuario("Digite o ID do usuário que VAI DEIXAR DE SER SEGUIDO:");
            if(outroUsuario == null){
                System.out.println("Não foi possível encontrar o usuário alvo.");
                return;
            }
        
            try{
                usuarioConta.deixarDeSeguir(outroUsuario);
                System.out.println("Você deixou de seguir este usuário com sucesso!");
            }catch(IllegalArgumentException e){
                System.out.println("Erro: " + e.getMessage());
            }
        }
    }

    private void quantSeguindoUsuarios(){
        System.out.println("\n ----- Consultar Quem Está Segurando -----");
        Usuario usuarioConta = pesquisarUsuario("Digite o ID do usuário que deseja consultar:");
        if(usuarioConta == null){
            System.out.println("Não foi possível encontrar o usuário.");
        }else{
            System.out.println("A quantidade de usuários sendo seguidos por " + usuarioConta.getNome() + " é: " + usuarioConta.getQuantidadeSeguindo());
        }
    }
    
    public static void main(String[] args) {
        new App();
    }
}