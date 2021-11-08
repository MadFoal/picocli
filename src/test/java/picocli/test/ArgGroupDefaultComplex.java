package picocli.test;

import picocli.CommandLine;
import picocli.CommandLine.*;

@Command(name = "myCommand",
        mixinStandardHelpOptions = true,
        description = "A command with default value in section ?")
public class ArgGroupDefaultComplex implements Runnable {
    /*
    private static class MyArgGroup {
		@Parameters(index = "0", arity = "1", description = "parameter 0")
		String param0;
		@Parameters(index = "1", arity = "0..1", description = "parameter 1")
		String param1;
		@Parameters(index = "2", arity = "0..1", description = "parameter 2")
		String param2;
	}
     */
    @ArgGroup(exclusive = false,
            heading = "%n@|italic " //
                    + "Options to be used with group 1 OR group 2 options." //
                    + "|@%n")
    public ArgGroupDefaultComplex.OptXAndGroupOneOrGroupTwo optXAndGroupOneOrGroupTwo = new ArgGroupDefaultComplex.OptXAndGroupOneOrGroupTwo();

    public static class OptXAndGroupOneOrGroupTwo {
        @Option(names = { "-x", "--option-x" }, required = true, defaultValue = "Default X", description = "option X")
        private String x;

        @ArgGroup(exclusive = true)
        private ArgGroupDefaultComplex.OneOrTwo oneORtwo = new ArgGroupDefaultComplex.OneOrTwo();
    }

    public static class OneOrTwo {

        @ArgGroup(exclusive = false,
                heading = "%n@|bold Group 2|@ %n%n")//
                    //    + "@|italic " //
                     //   + "Description of the group 2 ." //
                 //       + "|@%n")
        public ArgGroupDefaultComplex.GroupTwo two = new ArgGroupDefaultComplex.GroupTwo();
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

        System.out.println("2A = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a);
        System.out.println("2B = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b);
    }
    public String returnString() {
        String s = optXAndGroupOneOrGroupTwo.x + " "

                + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a + " "
                + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b;
        return s;
    }
    public static void main(String... args) {
        ArgGroupDefaultComplex argGroupDefaultComplex = new ArgGroupDefaultComplex();
        int exitCode = new CommandLine(argGroupDefaultComplex).execute(args);

        System.exit(exitCode);
    }

}