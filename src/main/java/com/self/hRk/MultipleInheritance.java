package com.self.hRk;

interface GPI
{
    // default method
    void abc();
    default void show()
    {
        System.out.println("Default GPI");
    }
}

interface PI1 extends GPI {

}

interface PI2 extends GPI { }

// Implementation class code
class MultipleInheritance implements PI1, PI2
{
    public static void main(String args[])
    {
        MultipleInheritance d = new MultipleInheritance();
        d.show();
        d.abc();
    }

    @Override
    public void abc() {
        System.out.println("GPI");
    }

    @Override
    public void show() {
        System.out.println("1 GPI");
    }
}