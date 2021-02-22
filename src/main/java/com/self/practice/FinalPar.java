package com.self.practice;

public class FinalPar {
    double attribute=8;
    final int finalAttribute=9;
    public void foo(final int finalAttribute){
//        this.finalAttribute = finalAttribute;
    }
    public void foo(final double attribute){
        this.attribute = attribute;
    }
    public void foo(final FinalPar finalPar){
        finalPar.attribute = 10.0;
//        finalPar.finalAttribute =11;
    }

    public static void main(String[] args) {
        FinalPar finalPar = new FinalPar();
        finalPar.foo(8.0);
        finalPar.foo(9);
        finalPar.foo(finalPar);
    }
}
