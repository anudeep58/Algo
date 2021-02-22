package com.self.hRk;

class SuperClass
{
    void fun()
    {
        System.out.println("Grandparent");
    }
}
// First Parent class
class A extends SuperClass
{
    void fun()
    {
        System.out.println("Parent1");
    }
}

class B extends SuperClass
{
    void fun()
    {
        System.out.println("Parent2");
    }
}

class Test extends A
{
    public static void main(String args[])
    {
        Test t = new Test();
        t.fun();
    }
}

public class DeadlyDiamond {
}
