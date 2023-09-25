import java.util.ArrayList;

public class AppTeste {
    
    public static void main(String[] args) {

        Banco1509 banco = new Banco1509();
        /* 
        boolean retorno = banco.cadastrarPessoa("Zé", "1234", 
                                                "ze@teste.com", "1234");
        System.out.println(retorno);

        retorno = banco.cadastrarPessoa("Maria", "678", 
                                                "maria@teste.com", "678");
        System.out.println(retorno);

        retorno = banco.cadastrarPessoa("Chico", "1234", 
                                                "chico@teste.com", "8677");
        System.out.println(retorno);
        */

        boolean retorno = banco.cadastrarContaBancaria(123, 321, "1234");
        System.out.println(retorno);

        retorno = banco.cadastrarContaBancaria(124, 321, "1234");
        System.out.println(retorno);

        retorno = banco.cadastrarContaBancaria(124, 321, "1234");
        System.out.println(retorno);

        System.out.println(ContaBancaria.getQuantidadeContas());

    }
}
