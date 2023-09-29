import java.util.ArrayList;
import java.util.List;

public class ListaDeCompra {
    private String nome;
    private List<Produto> produtos;

    public ListaDeCompra(String nome) {
        this.nome = nome;
        this.produtos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public double calcularValorTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getValor();
        }
        return total;
    }

    public double calcularPesoTotal() {
        double total = 0;
        for (Produto produto : produtos) {
            total += produto.getPeso();
        }
        return total;
    }

    @Override
    public String toString() {
        String result = "Lista: " + nome + "\n";
        for (Produto produto : produtos) {
            result += produto.toString() + "\n";
        }
        result += "Valor Total: " + calcularValorTotal() + "\n";
        result += "Peso Total: " + calcularPesoTotal() + "\n";
        return result;
    }
}