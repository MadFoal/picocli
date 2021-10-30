package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "CLI Test 1", mixinStandardHelpOptions = true)
public class CliTest1 implements Runnable {
	@Parameters(index = "0", arity = "1", description = "parameter 0")
	String param0;
	@Parameters(index = "1", arity = "0..1", description = "parameter 1")
	String param1;
	@Parameters(index = "2", arity = "0..1", description = "parameter 2")
	String param2;

	@Override
	public void run() {
		System.out.println("param0: " + param0);
		System.out.println("param1: " + param1);
		System.out.println("param2: " + param2);
	}

	public static void main(String[] args) {
		System.out.println("Arguments: " + String.join(", ", Arrays.asList(args)));
		int exitCode = new CommandLine(new CliTest1()).execute(args);
		System.exit(exitCode);
	}
}