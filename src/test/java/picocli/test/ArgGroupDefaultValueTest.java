package picocli.test;

import picocli.CommandLine;
import picocli.CommandLine.*;
import org.junit.Test;
import static org.junit.Assert.*;




public class ArgGroupDefaultValueTest {




    @Test
    public void workingSimpleTest() {
        String[] a = new String[0];

        ArgGroupDefaultValue argGroupDefaultValue = new ArgGroupDefaultValue();
        String s = "Default X Default 2A Default 2B";
        int exitCode = new CommandLine(argGroupDefaultValue).execute(a);
        org.junit.Assert.assertEquals(s, argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(0, exitCode);
    }

    @Test
    public void SimpleFirstHalfTest() {
        String[] a = new String[] {"-x", "x_test", "-2a", "2a_test"};


        ArgGroupDefaultValue argGroupDefaultValue = new ArgGroupDefaultValue();
        String s = "x_test 2a_test Default 2B";
        int exitCode = new CommandLine(argGroupDefaultValue).execute(a);
        System.out.println(argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }




    @Test
    public void SimpleSecondHalfTest() {
        String[] a = new String[] {"-x", "x_test", "-2b", "2b_test"};


        ArgGroupDefaultValue argGroupDefaultValue = new ArgGroupDefaultValue();
        String s = "x_test Default 2A 2b_test";
        int exitCode = new CommandLine(argGroupDefaultValue).execute(a);
        System.out.println(argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }


    // BROKEN
    @Test
    public void SimpleTwoMissingTest() {
        String[] a = new String[] {"-x", "x_test"};


        ArgGroupDefaultValue argGroupDefaultValue = new ArgGroupDefaultValue();
        String s = "x_test Default 2A Default 2B";

        int exitCode = new CommandLine(argGroupDefaultValue).execute(a);
        System.out.println(argGroupDefaultValue.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultValue.returnString());
        
        org.junit.Assert.assertEquals(0,exitCode);
    }




    @Test
    public void workingComplexTest() {
        String[] a = new String[0];

        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        String s = "Default X null null Default 2A Default 2B";
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(a);
        org.junit.Assert.assertEquals(s,argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }


    @Test
    public void ComplexDefaultMissingTest() {
        String[] a = new String[] {"-x", "x_test", "-1a", "1a_test","-1b", "1b_test"};
        // OMIT 2A
        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        String s = "x_test 1a_test 1b_test Default 2A Default 2B";
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(a);
        System.out.println(argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }


    @Test
    public void ComplexNonDefaultMissingTest() {
        String[] a = new String[] {"-x", "x_test", "-2a", "2a_test", "-2b", "2b_test"};


        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        String s = "x_test null null 2a_test 2b_test";
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(a);
        System.out.println(argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }


    @Test
    public void ComplexDefaultMissingTestNoX() {
        String[] a = new String[] {"-1a", "1a_test","-1b", "1b_test"};
        // OMIT 2A
        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        String s = "Default X 1a_test 1b_test Default 2A Default 2B";
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(a);
        System.out.println(argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }

    @Test
    public void ComplexNonDefaultMissingTestNoX() {
        String[] a = new String[] {"-2a", "2a_test", "-2b", "2b_test"};
        // Omit 2b
        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        String s = "Default X null null 2a_test 2b_test";
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(a);
        System.out.println(argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(s,argGroupDefaultComplex.returnString());
        org.junit.Assert.assertEquals(0,exitCode);
    }


}
