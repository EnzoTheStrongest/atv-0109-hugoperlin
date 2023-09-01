public class AppVetor {
    

    public static void main(String[] args) {
        int[] numeros;

        numeros = new int[5];
        System.out.println(numeros);
        
        for(int i=0;i<numeros.length;i++){
            numeros[i] = 1000 + i;
        }

        System.out.println(numeros);
    }

}
