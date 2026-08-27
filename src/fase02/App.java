package fase02;

import java.util.Scanner;

public class App {

    Scanner input = new Scanner(System.in);
    Plataforma plataforma;
    Playlist playlist;
    Usuario usuario;
    Musica musica;

    private App(){
        this.plataforma = new Plataforma();
        popularAcervo();
        menu();
    }

    private void popularAcervo() {
        System.out.println("\n----- Populando Acervo de Testes -----");

        Musica[] bancoDeTestes = new Musica[] {
            new Musica("Bohemian Rhapsody", "Queen", 354),        // 05:54
            new Musica("Song 2", "Blur", 122),                    // 02:02
            new Musica("Hotel California", "Eagles", 390),        // 06:30
            new Musica("Billie Jean", "Michael Jackson", 294),    // 04:54
            new Musica("Short Song", "Test Band", 65),            // 01:05 (Música curta / Duração limite)
            new Musica("Long Symphony", "Orchestra", 600),        // 10:00 (Música longa / Duração limite)
            new Musica("Smells Like Teen Spirit", "Nirvana", 301), // 05:01
            new Musica("Shape of You", "Ed Sheeran", 233),        // 03:53
            new Musica("Blinding Lights", "The Weeknd", 200),     // 03:20
            new Musica("Take On Me", "a-ha", 225),                // 03:45
            new Musica("Wonderwall", "Oasis", 258),               // 04:18
            new Musica("Sweet Child O' Mine", "Guns N' Roses", 356),// 05:56
            new Musica("Californication", "Red Hot Chili Peppers", 321), // 05:21
            new Musica("In the End", "Linkin Park", 216),         // 03:36
            new Musica("Fast Track", "Quick Band", 45)            // 00:45 (Abaixo de 1 min)
        };

        //cadastra cada objeto do vetor um por vez.
        for(Musica m : bancoDeTestes){ //: siginfica "em" ou "dentro de".
            plataforma.cadastrarMusica(m);
        }

        System.out.println("15 músicas cadastradas com sucesso no acervo!");
    }
    
    private void menu(){
        boolean continuar = true;
        int opcao;

        do{
            System.out.println("=== Sonora ===");
            System.out.println("1 - Cadastrar música manualmente"); 
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Criar playlist e adicionar músicas");
            System.out.println("4 - Buscar música por id");
            System.out.println("5 - Buscar música por título");
            System.out.println("6 - Reproduzir uma música");
            System.out.println("7 - Listar acervo de Músicas");
            System.out.println("0 - Sair");

            System.out.println("Digite a opção que deseja:");

            if(input.hasNextInt()){//verifica se a entrada é um número inteiro
                opcao = input.nextInt();
                input.nextLine(); //limpa o scanner
                
                switch(opcao){
                    case 1:
                        cadastrarMusicaManualmente();
                        break;
                
                    case 2:
                        cadastrarUsuario();
                        break;

                    case 3:
                        criarPlaylist();
                        break;

                    case 4:
                        buscarMusicaId();
                        break;

                    case 5:
                        buscarMusicaPorTitulo();
                        break;

                    case 6:
                        reproduzirMusica();
                        break;

                    case 7:
                        listarAcervoMusicas();
                        break;

                    case 0:
                        System.out.println("Até a próxima!");
                        continuar = false;
                        break;

                    default:
                        System.out.println("Opção invalida!");
                        break;
                }
            }
            else{
                System.out.println("Entrada inválida! Digite somente números inteiros.");
                input.nextLine();
            }
        }while(continuar);
    }

    private void cadastrarMusicaManualmente(){
        System.out.println("\n ----- Cadastrar Nova Música -----");

        System.out.println("Título:");
        String titulo = input.nextLine();
        System.out.println("Artista:");
        String artista = input.nextLine();
        System.out.println("Duração em segundos:");
        if (input.hasNextInt()) {
            int duracaoSegundos = input.nextInt();
            input.nextLine();

            Musica novaMusica = new Musica(titulo, artista, duracaoSegundos);
            boolean sucesso = plataforma.cadastrarMusica(novaMusica);

            if (sucesso) {
                System.out.println("Música cadastrada com sucesso. Id: " + novaMusica.getId());
            } else {
                System.out.println("Falha ao cadastrar a nova música.");
            }
        } else {
            System.out.println("Duração inválida! Digite apenas números inteiros.");
            input.nextLine();
        }
    }

    private void cadastrarUsuario(){
        System.out.println("\n ----- Cadastrar Novo Usuário -----");

        System.out.println("Nome:");
        String nome = input.nextLine();
        System.out.println("E-mail:");
        String email = input.nextLine();

        Usuario novoUsuario = new Usuario(nome,email);
        boolean sucesso = plataforma.cadastrarUsuario(novoUsuario);

        if(sucesso){
            System.out.println("Usuário cadastrado com sucesso. Id: " + novoUsuario.getId());
        }else{
            System.out.println("Falha ao cadastrar o novo usuário.");
        }
    }

    private void criarPlaylist(){
        System.out.println("\n ----- Criar Nova Playlist -----");

        System.out.println("Digite o nome da playlist:");
        String nomePlaylist = input.nextLine();
        System.out.println("Digite o id do usuário criador da playlist:");
        if(input.hasNextInt()){
            int idUsuario = input.nextInt();
            input.nextLine();
        
            Usuario buscarUsuario = plataforma.buscarUsuario(idUsuario);
            if(buscarUsuario != null){
                this.playlist = new Playlist(nomePlaylist, buscarUsuario);
                System.out.println("Playlist criada com sucesso.");
                adicionarMusicas();
            }else{
                System.out.println("Não foi possível encontrar o usuário com id: " + idUsuario);
                System.out.println("Playlist não foi criada");
            }
        }else{
            System.out.println("Id inválido! Digite somente números inteiros.");
            input.nextLine();
        }
    }

    private void adicionarMusicas(){
        System.out.println("\n ----- Adicionar Musicas na Playlist -----");

        while(true){
            System.out.println("Digite o id da música para adicionar (ou 0 para sair):");
            
            if(input.hasNextInt()){
                int id = input.nextInt();
                input.nextLine(); 

                if(id == 0){
                    System.out.println("Parando de adicionar músicas.");
                    break;
                }

                Musica musicaEncontrada = plataforma.buscarMusica(id);

                if(musicaEncontrada != null){
                    boolean sucesso = playlist.adicionar(musicaEncontrada);

                    if(sucesso){
                        System.out.println("Música '" + musicaEncontrada.getTitulo() + "' adicionada à playlist '" + playlist.getNome() + "'!");
                        System.out.println("Total de músicas na playlist agora: " + playlist.getQuantidade());
                        System.out.println("Duração total da playlist: " + playlist.getDuracaoTotalSegundos() + "s\n");
                    }else{
                        System.out.println("Não foi possível adicionar a música. A playlist pode estar cheia (limite de 100).");
                    }
                }else{
                    System.out.println("Nenhuma música encontrada com o id: " + id);
                }
            }else{
                System.out.println("Id inválido! Digite somente números inteiros.");
                input.nextLine(); // Limpa o texto incorreto
                }
        }
    }
    private void buscarMusicaId(){
        System.out.println("\n ----- Buscar Música por ID -----");

        System.out.println("Digite o id:");
        if(input.hasNextInt()){
            int id = input.nextInt();
            input.nextLine();

            Musica novaBuscaId = plataforma.buscarMusica(id);
            if(novaBuscaId == null){
            System.out.println("Não foi possível encontrar nenhuma música com o id: " + id);
            }else{
                System.out.println("ID: " + novaBuscaId.getId());
                System.out.println("Título: " + novaBuscaId.getTitulo());
                System.out.println("Artista: " + novaBuscaId.getArtista());
                System.out.println("Duração: " + novaBuscaId.getDuracaoFormatada());
                System.out.println("Reproduções: " + novaBuscaId.getReproducoes());
            }
        }else{
            System.out.println("Id inválido! Digite somente números inteiros!");
            input.nextLine();
        }
    }

    private void buscarMusicaPorTitulo(){
        System.out.println("\n ----- Buscar Música pelo Título -----");

        System.out.println("Digite o título:");
        String titulo = input.nextLine();

        Musica novaBuscaTitulo = plataforma.buscarMusica(titulo);
        if(novaBuscaTitulo == null){
            System.out.println("Não foi possível encontrar nenhuma música com o titulo: " + titulo);
        }else{
           System.out.println("ID: " + novaBuscaTitulo.getId());
            System.out.println("Título: " + novaBuscaTitulo.getTitulo());
            System.out.println("Artista: " + novaBuscaTitulo.getArtista());
            System.out.println("Duração: " + novaBuscaTitulo.getDuracaoFormatada());
            System.out.println("Reproduções: " + novaBuscaTitulo.getReproducoes());
        }
    }

    private void reproduzirMusica(){
        System.out.println("\n ----- Reproduzir Música -----");

        System.out.println("Digite o id da música:");
        if(input.hasNextInt()){
            int id = input.nextInt();
            input.nextLine();

            Musica musicaEncontrada = plataforma.buscarMusica(id);

            if(musicaEncontrada != null){
                musicaEncontrada.reproduzir();
                System.out.println("Tocando a música: " + musicaEncontrada.getTitulo() + " - " + musicaEncontrada.getArtista());
            }else{
                System.out.println("Nenhuma música encontrada com o id: " + id);
            }
        }else{
            System.out.println("Id inválido! Digite somente números inteiros.");
            input.nextLine();
        }
    }

    private void listarAcervoMusicas(){
        System.out.println("\n ----- Acervo de Músicas -----");
        if(plataforma.getTotalMusicas() == 0){
            System.out.println("Nenhuma música cadastrada no acervo.");
        }else{
            for(int i=1; i<=plataforma.getTotalMusicas(); i++){
                Musica buscarMusica = plataforma.buscarMusica(i);
                if(buscarMusica != null){
                    System.out.println("ID: " + buscarMusica.getId());
                    System.out.println("Título: " + buscarMusica.getTitulo());
                    System.out.println("Artista: " + buscarMusica.getArtista());
                    System.out.println("Duração: " + buscarMusica.getDuracaoFormatada());
                    System.out.println("Reproduções: " + buscarMusica.getReproducoes());
                    System.out.println("");
                }
            }
        }
    }

    public static void main(String[] args) {
        new App();
    }
}
