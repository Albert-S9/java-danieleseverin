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
    Suggerimento: dividere Tarray a metà e cercare rìcorsivamentc il valore massimo in ogni metà.
    Restituire il maggiore tra i due valori.
     */
    
    
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
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
        int n = array.length-1;

        System.out.println("sommaElementiArray: " + sommaElementiArray(array, n));

    }
}
