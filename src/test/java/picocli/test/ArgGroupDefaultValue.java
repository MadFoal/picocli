package picocli.test;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "mySimpleDefaultCommand",
        mixinStandardHelpOptions = true,
        description = "A command with default value in section ?")
public class ArgGroupDefaultValue implements Runnable {
    @ArgGroup(exclusive = false,
            heading = "%n@|italic " //
                    + "Options to be used with group 1 OR group 2 options." //
                    + "|@%n")
    public ArgGroupDefaultValue.OptXAndGroupTwo optXAndGroupTwo = new ArgGroupDefaultValue.OptXAndGroupTwo();

    public static class OptXAndGroupTwo {
        @Option(names = { "-x", "--option-x" }, required = true, defaultValue = "Default X", description = "option X")
        private String x;

        @ArgGroup(exclusive = true,
                heading = "%n@|bold Group 2|@ %n%n"//
                        + "@|italic " //
                        + "Description of the group 2 ." //
                        + "|@%n")
        private ArgGroupDefaultValue.GroupTwo groupTwo = new ArgGroupDefaultValue.GroupTwo();
    }


    public static class GroupTwo {

        @Option(names = { "-2a", "--option-2a" },required=true, defaultValue = "Default 2A", description = "option A of group 2")
        private String _2a;


        @Option(names = { "-2b", "--option-2b" },required=true, defaultValue = "Default 2B", description = "option B of group 2")
        private String _2b;
    }
    public void run() {

        System.out.println();
        System.out.println(" X = " + optXAndGroupTwo.x);
        System.out.println("2A = " + optXAndGroupTwo.groupTwo._2a);
        System.out.println("2B = " + optXAndGroupTwo.groupTwo._2b);

    }
    public String returnString() {
        String s = optXAndGroupTwo.x + " "
                + optXAndGroupTwo.groupTwo._2a + " "
                + optXAndGroupTwo.groupTwo._2b;

        /*String s = "\n X = " + optXAndGroupOneOrGroupTwo.x + "\n2A = "
                + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a + "\n2B = "
                + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b + "\n";
        /*
        System.out.println();
        System.out.println(" X = " + optXAndGroupOneOrGroupTwo.x);
        System.out.println("2A = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a);
        System.out.println("2B = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b);
        */
        return s;
    }


    public static void main(String... args) {
        //System.out.println(args);
        ArgGroupDefaultValue argGroupDefaultValue = new ArgGroupDefaultValue();
        int exitCode = new CommandLine(argGroupDefaultValue).execute(args);
        System.exit(exitCode);
    }


}
/*
 *  Current issue appears to be related to how we handle the required arguments.
 *  During parsing we find that the required arguments are not processed, which
 *  leads to them being marked as null instead of their default values
 *
 *
 *
 *package picocli.test;

import picocli.CommandLine;
import picocli.CommandLine.*;
import org.junit.Test;
import static org.junit.Assert.*;




@Command(name = "myCommand",
        mixinStandardHelpOptions = true,
        description = "A command with default value in section ?")
public class ArgGroupDefaultValueTest implements Runnable {
    @ArgGroup(exclusive = false,
            heading = "%n@|italic " //
                    + "Options to be used with group 1 OR group 2 options." //
                    + "|@%n")
    public ArgGroupDefaultValueTest.OptXAndGroupOneOrGroupTwo optXAndGroupOneOrGroupTwo = new ArgGroupDefaultValueTest.OptXAndGroupOneOrGroupTwo();

    public static class OptXAndGroupOneOrGroupTwo {
        @Option(names = { "-x", "--option-x" }, required = true, defaultValue = "Default X", description = "option X")
        private String x;

        @ArgGroup(exclusive = true)
        private ArgGroupDefaultValueTest.OneOrTwo oneORtwo = new ArgGroupDefaultValueTest.OneOrTwo();
    }

    public static class OneOrTwo {

        @ArgGroup(exclusive = false,
                heading = "%n@|bold Group 1|@ %n%n"//
                        + "@|italic " //
                        + "Description of the group 1 ." //
                        + "|@%n")
        public ArgGroupDefaultValueTest.GroupOne one = new ArgGroupDefaultValueTest.GroupOne();

        @ArgGroup(exclusive = false,
                heading = "%n@|bold Group 2|@ %n%n"//
                        + "@|italic " //
                        + "Description of the group 2 ." //
                        + "|@%n")
        public ArgGroupDefaultValueTest.GroupTwo two = new ArgGroupDefaultValueTest.GroupTwo();
    }

    public static class GroupOne {
        @Option(names = { "-1a", "--option-1a" },required=true,description = "option A of group 1")
        private String _1a;

        @Option(names = { "-1b", "--option-1b" },required=true,description = "option B of group 1")
        private String _1b;
    }

    public static class GroupTwo {

        @Option(names = { "-2a", "--option-2a" },required=true, defaultValue = "Default 2A", description = "option A of group 2")
        private String _2a;


        @Option(names = { "-2b", "--option-2b" },required=true, defaultValue = "Default 2B", description = "option B of group 2")
        private String _2b;
    }

    public void run() {
        System.out.println();
        System.out.println(" X = " + optXAndGroupOneOrGroupTwo.x);
        System.out.println("1A = " + optXAndGroupOneOrGroupTwo.oneORtwo.one._1a);
        System.out.println("1B = " + optXAndGroupOneOrGroupTwo.oneORtwo.one._1b);
        System.out.println("2A = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a);
        System.out.println("2B = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b);
    }

    public static void main(String... args) {
        ArgGroupDefaultValueTest argGroupDefaultValueTest = new ArgGroupDefaultValueTest();
        int exitCode = new CommandLine(argGroupDefaultValueTest).execute(args);

        System.exit(exitCode);
    }

}
/*
 *  Current issue appears to be related to how we handle the required arguments.
 *  During parsing we find that the required arguments are not processed, which
 *  leads to them being marked as null instead of their default values
 *
 *
 *
 *
 *
 *
 */
