package picocli.Issue1384;

import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "CLI Test 3", mixinStandardHelpOptions = true)
public class CliTest3 implements Runnable {
	private static class MyArgGroup {
		@Parameters(index = "0", arity = "1", description = "parameter 0")
		String param0;
		@Parameters(index = "1", arity = "1", description = "parameter 1")
		String param1;
		@Parameters(index = "2", arity = "1", description = "parameter 2")
		String param2;
	}

	@ArgGroup(order = 0, exclusive = false, multiplicity = "1")
	private MyArgGroup argGroup;

	@Override
	public void run() {
		System.out.println("***------------CLI TEST 3");
		System.out.println("param0: " + argGroup.param0);
		System.out.println("param1: " + argGroup.param1);
		System.out.println("param2: " + argGroup.param2);
		System.out.println("***------------done done done");
	}

	public static void main(String[] args) {
		int exitCode = new CommandLine(new CliTest2()).execute(args);
		System.exit(exitCode);
	}



	private static void printArray(String[] arg){
		int c = 0;
		for (String s : arg)
		{
			System.out.println("***count: " + c++ + "val: " + s);
		}
		System.out.println("***ender");
	}
}