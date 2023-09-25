import java.util.ArrayList;
import java.util.Collections;

public class Banco1509 {

    private ArrayList<ContaBancaria> contas;
    private ArrayList<Pessoa> clientes;

    


    public Banco1509() {
        contas = new ArrayList<>();
        clientes = new ArrayList<>();
    }

    public Pessoa buscarPessoa(String cpf) {

        for (int i = 0; i < clientes.size(); i++) {
            Pessoa cliente = clientes.get(i);
            if (cliente != null) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
        }

        return null;
    }

    private boolean adicionarPessoaVetor(Pessoa nova) {

        /*for (int i = 0; i < clientes.length; i++) {
            if (clientes[i] == null) {
                clientes[i] = nova;
                return true;
            }
        }

        return false;*/

        return clientes.add(nova);

    }

    public boolean cadastrarPessoa(String nome, String cpf,
            String email, String telefone) {

        // verificar se o cpf já está cadastrado
        // se não estiver, criar um objeto da classe pessoa
        // inserir o objeto no vetor de clientes
        Pessoa pessoa = buscarPessoa(cpf);
        if (pessoa == null) {
            Pessoa nova = new Pessoa(nome, cpf, email, telefone);
            //return adicionarPessoaVetor(nova);
            return clientes.add(pessoa);
        }
        return false;
    }


    private boolean adicionarContaVetor(ContaBancaria nova){

        /*for(int i=0;i<contas.length;i++){
            if(contas[i] == null){
                contas[i] = nova;
                return true;
            }
        }
        return false;*/

        return contas.add(nova);
    }

    public ContaBancaria buscarConta(int numero, int agencia){
        //buscar uma conta no vetor de contas
        ContaBancaria encontrada = null;
        for(int i=0;i<contas.size();i++){
            ContaBancaria conta = contas.get(i);
            if(conta != null){
                if(conta.getNumero()==numero && conta.getAgencia()==agencia){
                    encontrada = conta;
                }
            }
        }

        return encontrada;
    }

    public boolean cadastrarContaBancaria(int numero, int agencia, 
                                          String cpf){
        
        //buscar uma conta no vetor de contas
        ContaBancaria encontrada = buscarConta(numero, agencia);
        Pessoa titular = buscarPessoa(cpf);

        if(titular == null){
            return false;
        }

        if(encontrada == null){
            ContaBancaria nova = new ContaBancaria(numero, agencia,
                                                    titular);
            return contas.add(nova);
        }

        return false;
    }

    public String efetuarDeposito(int agencia, int numero, double valor){
        //verificar se existe uma conta com a agencia e numero
        //buscar uma conta no vetor de contas
        ContaBancaria encontrada = buscarConta(numero, agencia);

        if(encontrada != null){
            return encontrada.depositar(valor);
        }

        return "Erro! Conta não encontrada";
    }

    public String efetuarSaque(int agencia, int numero, double valor){
        
        ContaBancaria encontrada = buscarConta(numero,agencia);

        if(encontrada != null){
            return encontrada.sacar(valor);
        }

        return "Erro! Conta não encontrada!";
    }


    public String listarNomes(){

        String auxiliar="";

        /*for(int i=0;i<clientes.size();i++){
            Pessoa pessoa = clientes.get(i);
            auxiliar = auxiliar + pessoa.getNome()+"\n";
            //auxiliar = auxiliar + clientes.get(i).getNome()+"\n";
        }*/

        for(Pessoa pessoa:clientes){
            auxiliar = auxiliar + pessoa.getNome()+"\n";
        }



        return auxiliar;



    }


    public String mostrarDadosClientes(){

        String str="";

        for(Pessoa p:clientes){
            str += p.toString()+"\n";
        }
        return str;
    }

    public String mostrarDadosContas(){
        
        String str="";

        for(ContaBancaria conta:contas){
            str += conta.toString()+"\n";
        }

        return str;
    }

}
