package com.company;

public class Main {

    public static void dumpArray(Object[] theObject)
    {
        for(int n = 0; n < theObject.length; n++)
        {
            System.out.println(theObject[n].toString());
        }
    }

    public static void main(String[] args)
    {
        Object[] newObject = {"thisIsAString", 779, "thisIsAlsoAString", 873};
        dumpArray(newObject);
    }
}
