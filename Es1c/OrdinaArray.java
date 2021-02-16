public class OrdinaArray {

    public static void main(String args[]) {

        int n = lunghezzaArray();
        int array [] = new int[n];
        System.out.println("Lunghezza Array: " + n);

        array = riempiArray(n, array);

        //stampa array iniziale
        System.out.print("Array iniziale: ");

        for(int i=0; i<n; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println("");
        
        int array2 [] = new int[n];
        array2 = insertionSort(n, array);

        //stampa array ordinato
        System.out.print("Array ordinato: ");

        for(int i=0; i<n; i++) {
            System.out.print(array2[i] + " ");
        }
    }

    //metodo lunghezzaArray
    public static int lunghezzaArray() {
        int n = (int)(Math.random()*10);
            while(n<=2) {
                n = (int)(Math.random()*10);
            }
        return n;
    }

    //metodo riempiArray
    public static int[] riempiArray(int n, int[] array) {
        for(int i=0; i<n; i++) {
            array[i] = (int)(Math.random()*10);
        }
        return array;
    }

    //metodo insertionSort
    public static int[] insertionSort(int n, int[] array) {

        int temp [] = new int[n];

        for(int i=0; i<array.length; i++) {
            temp[i] = array[i];
            if(i!=0) {
                for(int j=0; j<array.length; j++) {
                    if(j==i)
                        break;
                    if(temp[i-j] < temp[i-j-1]) {
                        int a = temp[i-j];
                        temp[i-j] = temp[i-j-1];
                        temp[i-j-1] = a;
                    }
                    else {
                        break;
                    }
                }
            }
        }

        for(int i=0; i<array.length; i++) {
            array[i] = temp[i];
        }
        return array;
    }

    public static void selectionSort(int[] unArray) {
        
        for(int indice = 0; indice < unArray.length -1; indice++) {
            int indiceDelSuccessivoPiuPiccolo = getIndiceDelPiuPiccolo (indice, unArray);
            scambio (indice, indiceDelSuccessivoPiuPiccolo, unArray);
        }
    }

    public static int getIndiceDelPiuPiccolo (int indiceInizio, int[] a) {
        int minimo = a[indiceInizio];
        int indiceDelMinimo = indiceInizio;

        for(int indice = indiceInizio + 1; indice < a.length; indice++) {
            if (a[indice] < minimo) {
                minimo = a[indice];
                indiceDelMinimo = indice;
            }
        }
        return indiceDelMinimo;
    }

    public static void scambio (int i, int j, int [] a) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}

