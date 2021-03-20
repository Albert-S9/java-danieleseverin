//esercizi da pagina 297 (323)

import java.util.Arrays;

public class Main {

    public static int fattoriale(int n){
        if(n==0){
            return 1;
        }
        else{
            return fattoriale(n-1)*n;
        }
    }

    public static int fibonacci(int n){
        if(n==0 || n==1){
            return 1;
        }
        else{
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }

    public static void reverseString(String string, int i){
        if(i == 0) {
            System.out.print(string.charAt(i));
        }
        else{
            System.out.print(string.charAt(i));
            reverseString(string, i-1);
        }
    }

    //3. Scrivere un metodo ricorsivo che conti il numero di cifre dispari in un numero.
    public static int contaDispari (int n){
        if(n / 10 == 0){
            if(n % 2 != 0)
                return 1;
            else
                return 0;
        }
        else {
            if( (n%10) % 2 != 0)
                return 1 + contaDispari(n/10);
            else
                return contaDispari(n/10);
        }
    }

    //4. Scrivere un metodo ricorsivo che calcoli la somma delle cifre di un numero positivo.
    public static int sommaCifre (int n) {
        if (n /10 == 0)
            return n;
        else
            return (n%10) + sommaCifre(n/10);
    }

    //5. Completare la definizione ricorsiva del metodo seguente:
    /*
    Precondizione: n >= 0
    Restituisce 10 elevato alla potenza n.
    */
    public static int calcolaDieciAlla(int n){
        if (n==0)
            return 1;
        else
            return 10 * calcolaDieciAlla(n-1);
    }

    //6. Scrivere un metodo ricorsivo che calcoli la somma di tutti gli elementi di un array.
    public static int sommaElementiArray(int[] array, int n){
        if(n==0)
            return array[n];
        else
            return array[n] + sommaElementiArray(array, n-1);
    }

    /*7. Scrivere un metodo ricorsivo che trovi e restituisca il valore più grande in un array di interi.
    Suggerimento: dividere l'array a metà e cercare rìcorsivamente il valore massimo in ogni metà.
    Restituire il maggiore tra i due valori.
     */
    public static int trovaMax(int[] array){
        if(array.length==1)
            return array[0];
        if(array.length==2) {
            if (array[0] > array[1])
                return array[0];
            else
                return array[1];
        } else {
            int metaLunghezza = array.length / 2;
            int[] newArray1 = new int[metaLunghezza];
            int[] newArray2 = new int[array.length - metaLunghezza];

            for(int i=0; i<newArray1.length; i++)
                newArray1[i] = array[i];

            for(int j=0; j<newArray2.length; j++)
                newArray2[j] = array[j + newArray1.length];

            if(trovaMax(newArray1) > trovaMax(newArray2))
                return trovaMax(newArray1);
            else
                return trovaMax(newArray2);
        }
    }

    //Scrivere un algoritmo ricorsivo di ricerca ternaria che divida un array
    // in tre parti anziché le due utilizzate dalla ricerca binaria.

    public static int trovaMaxTernario (int[] array){
        if(array.length==1)
            return array[0];
        if(array.length==2) {
            if (array[0] > array[1])
                return array[0];
            else
                return array[1];
        } else {
            int terzoLunghezza = array.length/3;
            int[] newArray1 = new int[terzoLunghezza];
            int[] newArray2 = new int[terzoLunghezza];
            int[] newArray3 = new int[array.length - terzoLunghezza*2];

            for(int i=0; i<newArray1.length; i++)
                newArray1[i] = array[i];

            for(int j=0; j<newArray2.length; j++)
                newArray2[j] = array[j + newArray1.length];

            for(int k=0; k<newArray3.length; k++)
                newArray3[k] = array[k + newArray1.length*2];

            int[] newArray4 = new int[3];
            newArray4[0] = trovaMaxTernario(newArray1);
            newArray4[1] = trovaMaxTernario(newArray2);
            newArray4[2] = trovaMaxTernario(newArray3);

            Arrays.sort(newArray4);

            return newArray4[2];
        }
    }
    
    public static void main(String[] args) {

        //fattoriale(n) = fattoriale (n-1) * n
        // se n = 0, il fattoriale è 1

        System.out.println("Fattoriale: " + fattoriale(3));

        System.out.println("Fibonacci: " + fibonacci(6));

        System.out.print("ReverseString: ");
        String string = "Ciao";
        reverseString(string, string.length()-1);

        System.out.println("");

        System.out.println("Conta dispari: " + contaDispari(1357902441));

        System.out.println("Somma Cifre: " + sommaCifre(12345));

        System.out.println("calcolaDieciAlla: " + calcolaDieciAlla(4));

        int[] array = new int[5];
        array[0] = 5;
        array[1] = 2;
        array[2] = 6;
        array[3] = 4;
        array[4] = 5;
        int n = array.length-1;

        System.out.println("sommaElementiArray: " + sommaElementiArray(array, n));

        System.out.println("trovaMax: " + trovaMax(array));

        System.out.println("trovaMaxTernario: " + trovaMaxTernario(array));

    }
}
