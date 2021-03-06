package com.engim;

public class Nil extends List{

    @Override
    public String toString() {
        return "";
    }

    @Override
    public List addLast(int x) {

        return new Node(x, this);
    }

    @Override
    public void addLast2(int x) {
    }

    @Override
    public List add(int x, int i) {
        return new Node(x, this);
    }

    @Override
    protected boolean contiene(int x) {
        return false;
    }

    @Override
    public List remove(int x) {
        return null;
    }

    @Override
    public List removeAtIndex(int i) {
        return null;
    }

    @Override
    public List doppio() {
        return new Nil();
    }
}
