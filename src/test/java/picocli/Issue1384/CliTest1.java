package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "CLI Test 1", mixinStandardHelpOptions = true)
public class CliTest1 implements Runnable {
	@Parameters(index = "0", arity = "1", description = "parameter 0")
	String param0;

	@Parameters(paramLabel = "<word>", defaultValue = "hello, world",
			description = "Words to be translated into ASCII art.")
	private String[] words = { "fun,", "fred" };


	@Override
	public void run() {
		System.out.println("param0: " + param0);
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new CliTest1()).execute(args);
		System.out.println("**bye now");
		System.exit(exitCode);
	}
}

/*
// original

package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "CLI Test 1", mixinStandardHelpOptions = true)
public class CliTest1 implements Runnable {
	@Parameters(index = "0", arity = "1", description = "parameter 0")
	String param0;

	@Parameters(paramLabel = "<word>", defaultValue = "hello, world",
			description = "Words to be translated into ASCII art.")
	private String[] words = { "fun,", "fred" };


	@Override
	public void run() {
		System.out.println("param0: " + param0);
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new CliTest1()).execute(args);
		System.out.println("**bye now");
		System.exit(exitCode);
	}
}
 */