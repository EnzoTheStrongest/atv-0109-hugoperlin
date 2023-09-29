public class Produto {
    // Atributos do produto
    private String nome;
    private double valor;
    private double peso;

    // Construtor do produto,definirá o que é necessário para criar um objeto
    // produto.
    public Produto(String nome, double valor, double peso) {
        this.nome = nome;
        this.valor = valor;
        this.peso = peso;
    }

    // Métodos get para retornar os valores para classe produto.
    public String getNome() {
        return nome;
    }

    public double getValor() {
        return valor;
    }

    public double getPeso() {
        return peso;
    }

    // Método set para definir os valores para classe produto.
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // Método toString para retornar os valores da classe produto, para mostrá-los.
    @Override
    public String toString() {
        return "Nome: " + nome + " Valor: " + valor + " Peso: " + peso;
    }
}