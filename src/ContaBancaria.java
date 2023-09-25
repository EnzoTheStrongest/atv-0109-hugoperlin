public class ContaBancaria {
    
    //atributo
    private int numero;
    private int agencia;
    private double saldo;
    /*private String cpf;
    private String senha;
    private String email;*/
    private Pessoa titular;

    private static int quantidadeDeContas=0;

    public ContaBancaria(int numero, 
                         int agencia, 
                         double saldo, 
                         Pessoa titular){
        this.numero = numero;
        this.agencia = agencia;
        this.saldo = saldo;
        this.titular = titular;

        quantidadeDeContas += 1;
    }

    public ContaBancaria(int numero,
                         int agencia,
                         Pessoa titular){
        this.numero = numero;
        this.agencia = agencia;
        this.titular = titular;
        quantidadeDeContas += 1;
    }

    public static int getQuantidadeContas(){
        return quantidadeDeContas;
    }



    public void setNumero(int numero){
        this.numero = numero;
    }

    public int getNumero(){
        return numero;
    }

    public void setAgencia(int agencia){
        this.agencia = agencia;
    }

    public int getAgencia(){
        return agencia;
    }

    public Pessoa getTitular(){
        return titular;
    }

    public double getSaldo(){
        return saldo;
    }


    private boolean testarValor(double valor){
        if(valor > 0){
            return true;
        }else{
            return false;
        }
    }

    private boolean valorMenorOuIgualQueSaldo(double valor){
        return valor <= saldo;
    }

    private boolean valorValidoSaque(double valor){
        boolean maiorQueZero = testarValor(valor);
        boolean menorQueSaldo = valorMenorOuIgualQueSaldo(valor);

        if(maiorQueZero && menorQueSaldo){
            return true;
        }
        else{
            return false;
        }
    }



    //ações métodos funções
    public String sacar(double valor){
        if(valorValidoSaque(valor)){
            //registrar saque realizado
            saldo = saldo - valor;
            return "Saque realizado";
        }
        else{
            return "Valor inválido";
        }
        
    }

    public String depositar(double valor){
        if(testarValor(valor)){
            //registrar deposito realizado
            saldo = saldo + valor;
            return "Depósito realizado";
        }
        return "Valor inválido";
        
    }

    public String toString(){
        return "Número:" +numero+" Agência:"+agencia+
        " Saldo: R$"+saldo+" Titular:"+titular.toString();
    }


}
