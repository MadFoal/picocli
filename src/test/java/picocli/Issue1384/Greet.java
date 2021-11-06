package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(name = "Greet", header = "%n@|green Hello world demo|@")
class Greet implements Runnable {

    @Option(names = {"-u", "--user"}, required = true, defaultValue = "Fred",description = "The user name.")
    String userName;

    public void run() {
        System.out.println("Hello, " + userName);
    }

    public static void main(String... args) {
        CommandLine.run(new Greet(), System.err, args);
    }
}