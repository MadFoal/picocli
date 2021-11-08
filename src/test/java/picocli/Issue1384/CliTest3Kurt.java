package picocli.Issue1384;

import java.util.Arrays;
import java.util.List;
import picocli.CommandLine;
import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

@Command(name = "CLI Test 2", mixinStandardHelpOptions = true)
public class CliTest3Kurt implements Runnable {
	static class StudentGrade {
		@Parameters(index = "0") String name;
		@Parameters(index = "1") int grade;
	}

	@ArgGroup(exclusive = false, multiplicity = "1..*")
	 List<StudentGrade> gradeList;

	@Override
	public void run() {
		gradeList.forEach(e -> System.out.println(e.name + ": " + e.grade));
	}

	public static void main(String[] args) {
		System.exit(new CommandLine(new CliTest3Kurt()).execute(args));
	}
}