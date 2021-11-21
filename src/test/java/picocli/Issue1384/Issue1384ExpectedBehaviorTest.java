package picocli.Issue1384;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

/**
 * Issue 1384 https://github.com/remkop/picocli/issues/1384
 * Details: Test class is to demonstrations successful matches, the behavior that fails in the bug test
 *
 * Given: Multiple parameters as an array of strings
 * Expected successful execution (avoids error due to passing an array instead of argument group)
 * Result: Successful execution demonstrating the expected behavior
 *
 */

@Command(name = "Issue 1384 Expected Behavior Test", mixinStandardHelpOptions = true)
public class Issue1384ExpectedBehaviorTest implements Runnable {
	@Parameters(index = "0", arity = "1", description = "parameter 0")
	String parameter0;
	@Parameters(index = "1", arity = "0..1", description = "parameter 1")
	String parameter1;
	@Parameters(index = "2", arity = "0..1", description = "parameter 2")
	String parameter2;

	@Override
	public void run() {
		System.out.println("parameter0: " + parameter0);
		System.out.println("parameter1: " + parameter1);
		System.out.println("parameter2: " + parameter2);
	}

	public static void main(String[] args) {
		System.out.println("Arguments: " + args.length);
		int result = new CommandLine(new Issue1384ExpectedBehaviorTest()).execute(args);
		System.exit(result);
	}
}