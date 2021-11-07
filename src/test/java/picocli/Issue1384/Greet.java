package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

@Command(
        name = "helloName",
     //   header = "%n@|green Hello world demo|@",
        description="Says hello to [name]"
)
class Greet implements Runnable {

    @Parameters(index="0", description = "Name to print out")
    private String name;
    @Parameters(index = "0", arity = "1", description = "parameter 0")
    String param0;
    @Parameters(index = "1", arity = "0..1", description = "parameter 1")
    String param1;
    @Parameters(index = "2", arity = "0..1", description = "parameter 2")
    String param2;

    public static void main(String[] args) {
        new CommandLine(new Greet()).execute(args);
    }

    @Override
    public void run() {
        System.out.println("Hello, " + name);
    }
}