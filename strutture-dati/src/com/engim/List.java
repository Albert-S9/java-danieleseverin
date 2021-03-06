package com.engim;

public abstract class List {

    public abstract List addLast(int x);
    public abstract void addLast2(int x);

    public abstract List add(int x, int i);

    // rimuove tutte le occorrenze di x
    public abstract List remove(int x);

    protected abstract boolean contiene(int x);

    // rimuove l'elemento in posizione i
    public abstract List removeAtIndex(int i);

    // raddoppia tutti gli elementi della lista
    public abstract List doppio();

    // true se tutti gli elementi sono pari
    //public abstract boolean pari();

    // true se la lista è ordinata
    //public abstract boolean ordinata(int next);

    // per i forti: true se è ordinata crescente o descrescente, false altrimenti
    // public abstract boolean ordinataCrescenteDecrescente(....)
    // suggerimento: io definirei una enumerazione
}
