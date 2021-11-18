package picocli.Issue1384;

import java.util.Arrays;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "Issue 1384 Negative Test", mixinStandardHelpOptions = true)
public class Issue1384_NegativeTest implements Runnable {
	private static class MyArgGroup {
		@Parameters(index = "0", arity = "1", description = "parameter 0")
		String parameter0;
		@Parameters(index = "1", arity = "0..1", description = "parameter 1")
		String parameter1;
		@Parameters(index = "2", arity = "0..1", description = "parameter 2")
		String parameter2;
	}

	@ArgGroup(order = 0, exclusive = false, multiplicity = "1")
	private MyArgGroup argGroup;

	@Override
	public void run() {
		System.out.println("parameter0: " + argGroup.parameter0);
		System.out.println("parameter1: " + argGroup.parameter1);
		System.out.println("parameter2: " + argGroup.parameter2);
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new CliTest2()).execute(args);
		System.exit(exitCode);
	}

	private static void printArray(String[] arg){
		int c = 0;
		for (String s : arg)
		{
			System.out.println("***Index: " + c++ + "val: " + s);
		}
	}
}