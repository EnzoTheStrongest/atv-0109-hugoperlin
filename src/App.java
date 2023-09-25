import java.util.Scanner;

public class App{
    private static Scanner scan;
    private static Banco1509 banco;

    private static String menu(){
        String str = "";
        str+="1 - Cadastrar Pessoa\n";
        str+="2 - Visualizar Pessoa\n";
        str+="3 - Cadastrar Conta Bancaria\n";
        str+="4 - Visualizar Conta Bancaria\n";
        str+="5 - Depositar Conta Bancaria\n";
        str+="6 - Sacar Conta Bancaria\n";
        
        str+="0 - Sair\n";

        return str;
    }

    private static void cadastrarPessoa(){
        String nome,cpf,email,telefone;
        Pessoa pessoa;

        System.out.println("###Cadastro de Pessoa###");
        System.out.println("Digite o nome:");
        nome = scan.nextLine();
        System.out.println("Digite o cpf:");
        cpf = scan.nextLine();
        System.out.println("Digite o e-mail:");
        email = scan.nextLine();
        System.out.println("Digite o telefone:");
        telefone = scan.nextLine();

        boolean ret = banco.cadastrarPessoa(nome, cpf, email, telefone);

        if(ret){
            System.out.println("Pessoa cadastrada!");
        }else{
            System.out.println("Problema ao cadastrar!");
        }


    }

    private static void cadastrarConta(){
        int numero,agencia;
        String cpf;

        System.out.println("###Cadastro de Conta###");
        System.out.println("Digite o número:");
        numero = scan.nextInt();scan.nextLine();
        System.out.println("Digite a agência:");
        agencia = scan.nextInt();scan.nextLine();
        System.out.println("Digite o cpf:");
        cpf = scan.nextLine();

        boolean ret = banco.cadastrarContaBancaria(numero, agencia, cpf);

        if(ret){
            System.out.println("Conta cadastrada!");
        }else{
            System.out.println("Problema ao cadstrar conta!");
        }
        
    }

    private static void depositar(){
        double valor;
        int numero,agencia;
        
        System.out.println("Depositar na conta");
        System.out.println("Digite o número:");
        numero = scan.nextInt();scan.nextLine();
        System.out.println("Digite a agência:");
        agencia = scan.nextInt();
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        String ret = banco.efetuarDeposito(agencia, numero, valor);
        System.out.println(ret);
    }

    private static void sacar(){
        double valor;
        int numero,agencia;
        
        System.out.println("Depositar na conta");
        System.out.println("Digite o número:");
        numero = scan.nextInt();scan.nextLine();
        System.out.println("Digite a agência:");
        agencia = scan.nextInt();
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        String ret = banco.efetuarSaque(agencia, numero, valor);
        System.out.println(ret);
    }

    private static void mostrarClientes(){
        System.out.println("Clientes");
        System.out.println(banco.mostrarDadosClientes());
    }

    private static void mostrarContas(){
        System.out.println("Contas");
        System.out.println(banco.mostrarDadosContas());
    }

    
    public static void main(String[] args) {
        
        scan = new Scanner(System.in);

        banco = new Banco1509();
        
        int opcao;


        do{
            System.out.println(menu());
            opcao = scan.nextInt(); scan.nextLine();

            switch(opcao){
                case 1:
                    cadastrarPessoa();
                break;
                case 2:
                    mostrarClientes();
                break;
                case 3:
                    cadastrarConta();
                break;
                case 4:
                    mostrarContas();
                break;
                case 5:
                    depositar();
                break;
                case 6:
                    sacar();
                break;
            }

        }while(opcao != 0);

    }


}


//git config --local user.name "Hugo"
//git config --local user.email "haperlin@gmail.com"
