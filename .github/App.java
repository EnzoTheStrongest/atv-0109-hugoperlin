import java.util.Scanner;

public class App {

    static Scanner entrada = new Scanner(System.in);

    public static void main(String[] args) {
        Gerenciador gerenciador = new Gerenciador();
        int i;
        do {
            System.out.println("Digite 1 para cadastrar produto");
            System.out.println("Digite 2 para listar produtos");
            System.out.println("Digite 3 para adicionar produtos na lista");
            System.out.println("Digite 4 para excluir produto");
            System.out.println("Digite 5 para cadastrar lista");
            System.out.println("Digite 6 para listar listas");
            System.out.println("Digite 7 para buscar detalhes da lista");
            System.out.println("Digite 0 para sair");
            i = entrada.nextInt();

            switch (i) {
                case 0:
                    System.out.println("Saindo...");
                    break;
                case 1:
                    System.out.println(menuCadastraProduto(gerenciador));
                    break;
                case 2:
                    System.out.println(gerenciador.listarProdutos());
                    break;
                case 3:
                    entrada.nextLine();
                    System.out.println(menuAdcionaProduto(gerenciador));
                    break;
                case 4:
                    entrada.nextLine();
                    System.out.println(menuRemoveProduto(gerenciador));
                    break;
                case 5:
                    entrada.nextLine();
                    System.out.println(menuCadastraLista(gerenciador));
                    break;
                case 6:
                    System.out.println(gerenciador.listarListas());
                    break;
                case 7:
                    entrada.nextLine();
                    System.out.println(menubuscarDetalhesLista(gerenciador));
                    break;

                default:
                    System.out.println("Erro, opção inválida!");
                    break;
            }
        } while (i != 0);
    }

    private static String menuCadastraProduto(Gerenciador gerenciador) {
        System.out.println("Cadastro de produto");
        entrada.nextLine();

        System.out.println(" Digite o nome do produto: ");
        String nome = entrada.nextLine();
        System.out.println("Digite o valor do produto:");
        double valor = entrada.nextDouble();
        System.out.println("Digite o peso do produto:");
        double peso = entrada.nextDouble();

        entrada.nextLine();

        return "\n" + gerenciador.cadastrarProduto(nome, valor, peso);
    }

    private static String menuAdcionaProduto(Gerenciador gerenciador) {
        System.out.println("Adicionar produto a lista");

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = entrada.nextLine();
        System.out.println(" Digite o nome da lista: ");
        String nomeLista = entrada.nextLine();

        return "\n" + gerenciador.adicionarProduto(nomeProduto, nomeLista);
    }

    private static String menuRemoveProduto(Gerenciador gerenciador) {
        System.out.println("Remover produto");

        System.out.println("Digite o nome do produto: ");
        String nomeProduto = entrada.nextLine();
        System.out.println(" Digite o nome da lista: ");
        String nomeLista = entrada.nextLine();

        return "\n" + gerenciador.removeProduto(nomeProduto, nomeLista);
    }

    private static String menuCadastraLista(Gerenciador gerenciador) {
        System.out.println("Cadastro da lista");

        System.out.println(" Digite o nome da lista: ");
        String nome = entrada.nextLine();

        return "\n" + gerenciador.cadastrarLista(nome);
    }

    private static String menubuscarDetalhesLista(Gerenciador gerenciador) {
        System.out.println("Busca de detalhes da lista");

        System.out.println("Digite o nome da lista: ");
        String nome = entrada.nextLine();

        return "\n" + gerenciador.buscarDetalhesLista(nome);
    }
}
