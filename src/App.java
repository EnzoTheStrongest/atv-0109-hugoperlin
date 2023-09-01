import java.util.Scanner;

public class App{
    private static Scanner scan;

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

    private static Pessoa cadastrarPessoa(){
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

        pessoa = new Pessoa(nome, cpf, email, telefone);

        return pessoa;
    }

    private static ContaBancaria cadastrarConta(){
        ContaBancaria conta;
        int numero,agencia;
        String senha,cpf,email;

        System.out.println("###Cadastro de Conta###");
        System.out.println("Digite o número:");
        numero = scan.nextInt();scan.nextLine();
        System.out.println("Digite a agência:");
        agencia = scan.nextInt();scan.nextLine();
        System.out.println("Digite a senha:");
        senha = scan.nextLine();
        System.out.println("Digite o cpf:");
        cpf = scan.nextLine();
        System.out.println("Digite o e-mail:");
        email = scan.nextLine();

        conta = new ContaBancaria(numero, agencia, 0.0, cpf, senha, email);

        return conta;

    }

    private static void depositar(ContaBancaria conta){
        double valor;

        System.out.println("Depositar na conta");
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        System.out.println(conta.depositar(valor));
    }

    private static void sacar(ContaBancaria conta){
        double valor;

        System.out.println("Sacar da conta");
        System.out.println("Digite o valor:");
        valor = scan.nextDouble();

        System.out.println(conta.sacar(valor));
    }

    public static void main(String[] args) {
        
        scan = new Scanner(System.in);

        //declarar
        ContaBancaria conta=null;        
        Pessoa pessoa=null;
        
        
        int opcao;


        do{
            System.out.println(menu());
            opcao = scan.nextInt(); scan.nextLine();

            switch(opcao){
                case 1:
                    pessoa = cadastrarPessoa();
                break;
                case 2:
                    System.out.println("Dados da Pessoa");
                    System.out.println(pessoa.toString());
                break;
                case 3:
                    conta = cadastrarConta();
                break;
                case 4:
                    System.out.println("Dados da conta");
                    System.out.println(conta.toString());
                break;
                case 5:
                    depositar(conta);
                break;
                case 6:
                    sacar(conta);
                break;
            }

        }while(opcao != 0);

    }


}


//git config --local user.name "Hugo"
//git config --local user.email "haperlin@gmail.com"
