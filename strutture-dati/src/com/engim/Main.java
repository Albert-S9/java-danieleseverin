package com.engim;

public class Main {

    public static void main(String[] args) {
        List l = new Node(1,new Node(2,new Node(3,new Nil())));
/*
        Nil nil = new Nil();
        Node n3 = new Node(3, nil);
        Node n2 = new Node(2, n3);
        Node n1 = new Node(1, n2);
        List l1 = n1;*/

        System.out.println("Lista: " + l);

        l = new Node(0, l);
        System.out.println("Aggiungi 0 all'inizio: " + l);

        l = l.addLast(4);
        System.out.println("addLast(4): " + l);

        l = l.add(3, 2); //aggiungo il parametro 3 alla seconda posizione
        System.out.println("add(3, 2): " + l); //output stimato: 0 1 3 2 3 4

        /*
        l = l.remove(3); //rimuove solo la prima occorrenza
        System.out.println(l);
         */

        //rimuove tutte le occorrenze di x
        int x = 3;
        boolean result = l.contiene(x);
        while(result){
            l = l.remove(x);
            result = l.contiene(x);
        }
        System.out.println("remove(3): " + l);

        l = l.removeAtIndex(0);
        System.out.println("removeAtIndex(0): " + l);

        l = l.doppio();
        System.out.println("doppio(): " + l);
    }
}
