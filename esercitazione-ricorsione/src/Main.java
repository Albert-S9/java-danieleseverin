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

    //Scrivere un metodo ricorsivo che conti il numero di cifre dispari in un numero.
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
    }
}
