import java.util.ArrayList;
import java.util.List;

public class Gerenciador {
    private List<Produto> produtos;
    private List<ListaDeCompra> listas;

    public Gerenciador() {
        produtos = new ArrayList<>();
        listas = new ArrayList<>();
    }

    // Acão para cadastrar produtos.
    public String cadastrarProduto(String nome, double valor, double peso) {
        // for para percorrer "produto obejto" no vetor de "produtos"

        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome)) {
                return "Produto já existe";
            }
        }
        produtos.add(new Produto(nome, valor, peso));
        return "Cadastrado";
    }
    // * */

    // Acão para listar os produtos.
    public String listarProdutos() {
        String result = "";
        for (Produto produto : produtos) {
            result += produto.toString() + "\n";
        }
        return result;
    }
    /* */

    // Ação adicionar produtos na lista.
    public String adicionarProduto(String nomeProduto, String nomeLista) {
        Produto produtoAdicionar = null;
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nomeProduto)) {
                produtoAdicionar = produto;
                break;
            }
        }

        ListaDeCompra listaAdicionar = null;
        for (ListaDeCompra lista : listas) {
            if (lista.getNome().equals(nomeLista)) {
                listaAdicionar = lista;
                break;
            }
        }

        if (produtoAdicionar != null && listaAdicionar != null) {
            listaAdicionar.getProdutos().add(produtoAdicionar);
            return "Adicionado";
        } else if (produtoAdicionar == null) {
            return "Produto não encontrado";
        } else {
            return "Lista não encontrada";
        }
    }
    // * */

    // Ação excluir produto
    public String removeProduto(String nomeProduto, String nomeLista) {
        for (ListaDeCompra lista : listas) {
            if (lista.getNome().equals(nomeLista)) {
                List<Produto> produtosLista = lista.getProdutos();
                Produto produtoRemovido = null;

                for (Produto produto : produtosLista) {
                    if (produto.getNome().equals(nomeProduto)) {
                        produtoRemovido = produto;
                        break;
                    }
                }

                if (produtoRemovido != null) {
                    produtosLista.remove(produtoRemovido);
                    return "Removido";
                }
            }
        }
        return "Informações Inválidas";
    }
    // * */

    // Ação cadastrar lista.
    public String cadastrarLista(String nome) {
        for (ListaDeCompra lista : listas) {
            if (lista.getNome().equals(nome)) {
                return "Lista já existe";
            }
        }
        listas.add(new ListaDeCompra(nome));
        return "Criada";
    }
    // * */

    // Ação listar listas
    public String listarListas() {
        String result = "";
        for (ListaDeCompra lista : listas) {
            result += lista.getNome() + "\n";
        }
        return result;
    }
    // * */

    // Ação Buscar lista
    public String buscarDetalhesLista(String nome) {
        for (ListaDeCompra lista : listas) {
            if (lista.getNome().equals(nome)) {
                return lista.toString();
            }
        }
        return "Lista não encontrada";
    }
    // * */

}