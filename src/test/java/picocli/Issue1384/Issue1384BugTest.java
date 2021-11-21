package picocli.Issue1384;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

/**
 * Issue 1384 https://github.com/remkop/picocli/issues/1384
 * Details: Test class is used to reproduct the error described in issue 1384
 *
 * Given: Multiple parameters as an argument group
 * Expected successful matching allows for execution and the creation of a  single argument group
 * Result: Error: expected only one match but got multiple
 *
 */

@Command(name = "Issue 1384 Bug Test", mixinStandardHelpOptions = true)
public class Issue1384BugTest implements Runnable {
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
		assert (argGroup != null);
		// System.out.printf("parameter0: " + argGroup.parameter0);
		// System.out.println("parameter1: " + argGroup.parameter1);
		// System.out.println("parameter2: " + argGroup.parameter2);
	}

	public static void main(String[] args) {
		int result = new CommandLine(new Issue1384BugTest()).execute(args);
		System.exit(result);
	}

	/*
	Used for testing at times
	private static void printArray(String[] arg){
		int index = 0;
		for (String s : arg)
		{
			System.out.println("***index: " + index++ + " val: " + s);
		}
	}
	 */
}