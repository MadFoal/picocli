package picocli.Issue1384;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "Issue 1384 Expected Behavior Test", mixinStandardHelpOptions = true)
public class Issue1384_expectedBehaviorTest implements Runnable {
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
		int result = new CommandLine(new CliTest1()).execute(args);
		System.exit(result);
	}
}