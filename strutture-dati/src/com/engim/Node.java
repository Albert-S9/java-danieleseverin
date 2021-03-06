package com.engim;

public class Node extends List{
    private int value;
    private List next;
    private int contatore=0;

    public Node(int value, List next) {
        this.value = value;
        this.next = next;
    }

    @Override
    public String toString() {
        return value + " " + next.toString();
    }

    @Override
    public List addLast(int x) {
        this.next = next.addLast(x);
        return this;
    }

    @Override
    public void addLast2(int x){
        if(this.next instanceof Nil)
            this.next = new Node(x, this.next);
        else
            this.next.addLast2(x);
    }

    @Override
    public List add(int x, int i) {
        if (i == 0){
            this.next = new Node(this.value, this.next);
            this.value = x;
          }
        else
            this.next = next.add(x, i-1);
        return this;
    }

    //metodo che mi restituisce true se l'elemento è contenuto nella lista
    public boolean contiene(int x){
        if(this.value == x)
            return true;
        else
            return this.next.contiene(x);
    }

    @Override
    public List remove(int x) {
        if(this.value == x)
            return this.next;
        else
            this.next = next.remove(x);
        return this;
    }

    @Override
    public List removeAtIndex(int i) { //se viene inserito indice non esistente dà errore
        if (i == 0) {
            return this.next;
        } else
            this.next = next.removeAtIndex(i - 1);
        return this;
    }

    @Override
    public List doppio() {
        this.next.doppio();
        this.add(this.value, 0);
        return this;
    }
}
