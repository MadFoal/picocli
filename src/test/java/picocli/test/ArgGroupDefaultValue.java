package picocli.test;

import picocli.CommandLine;
import picocli.CommandLine.*;

// Reworking some of ben's tests to further exam 1384

@Command(name = "mySimpleDefaultCommand",
        mixinStandardHelpOptions = true,
        description = "A command with default value in section ?")
public class ArgGroup1384Defaults implements Runnable {
    @ArgGroup(exclusive = false,
            heading = "%n@|italic " //
                    + "Arg Group for 1384 - Options." //
                    + "|@%n")
    public ArgGroup1384Defaults.OptXAndGroupOneOrGroupTwo optXAndGroupOneOrGroupTwo = new ArgGroup1384Defaults.OptXAndGroupOneOrGroupTwo();

    public static class OptXAndGroupOneOrGroupTwo {
        @Option(names = { "-x", "--option-x" }, required = true, defaultValue = "Default X", description = "option X")
        private String x;

        @ArgGroup(exclusive = true)
        private ArgGroup1384Defaults.OneOrTwo oneORtwo = new ArgGroup1384Defaults.OneOrTwo();
    }

    public static class OneOrTwo {

        @ArgGroup(exclusive = false,
                heading = "%n@|bold Group 2|@ %n%n"//
                        + "@|italic " //
                        + "Description of the group 2 ." //
                        + "|@%n")
        public ArgGroup1384Defaults.GroupTwo two = new ArgGroup1384Defaults.GroupTwo();
    }
    
    public void run() {

        System.out.println();
        System.out.println(" X = " + optXAndGroupOneOrGroupTwo.x);
        System.out.println("2A = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2a);
        System.out.println("2B = " + optXAndGroupOneOrGroupTwo.oneORtwo.two._2b);

    }

    public static void main(String... args) {
        //System.out.println(args);
        ArgGroup1384Defaults ArgGroup1384Defaults = new ArgGroup1384Defaults();
        int exitCode = new CommandLine(ArgGroup1384Defaults).execute(args);
        System.exit(exitCode);
    }


}