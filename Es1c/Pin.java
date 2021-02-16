import java.util.Scanner;

public class Pin {

    public static void main(String args[]) {

        Scanner tastiera = new Scanner (System.in);
    
    //il pin è 12345
    int pin [] = new int[5];
    pin[0] = 1;
    pin[1] = 2;
    pin[2] = 3;
    pin[3] = 4;
    pin[4] = 5;

    //se il PIN è corretto a termine programma l'array test avrà solo valori true
    boolean test[] = new boolean[5];
    for(int i=0; i<test.length; i++)
        test[i] = false;

    String chiave [] = new String[10];

    System.out.println("Inserisci il tuo pin utilizzando la seguente chiave:");
    for(int i=0; i<10; i++) {
        System.out.print(i + " ");
    }

    System.out.println("");

    chiave = creaChiave(chiave); //riempe l'array chiave di numeri casuali da 0 a 3 (formato String)

    for(int i=0; i<10; i++) {
        System.out.print(chiave[i] + " ");
    }

    System.out.println("");
    System.out.println("Inserisci il PIN (12345): ");
    String pinInserito [] = new String [5];
    String temp = tastiera.nextLine();
    pinInserito = temp.split("");

    if(pinInserito.length==5) {
        
        for(int i=0; i<pinInserito.length; i++) {
            for(int j=0; j<chiave.length; j++) {
                if(pinInserito[i].equals(chiave[j])) {
                    if(j == pin[i]) {
                        test[i] = true;
                    }
                }
            }
        }
        convalida(test);
    }
    else
        System.out.println("Il pin dev'essere di 5 caratteri!");
}

    public static String[] creaChiave(String [] chiave) {
        for(int i=0; i<10; i++) {
            int temp = (int)(Math.random()*4);
            if(temp == 0)
                chiave[i] = "0";
            if(temp == 1)
                chiave[i] = "1";
            if(temp == 2)
                chiave[i] = "2";
            if(temp == 3)
                chiave[i] = "3";
        }
        return chiave;
    }

    public static void convalida(boolean [] test) {
        for(int i=0; i<test.length; i++) {
            if(test[i] == false) {
                System.out.println("PIN errato!");
                break;
            }
            else if(i == test.length-1)
            System.out.println("PIN corretto!");   
        }
    }
}