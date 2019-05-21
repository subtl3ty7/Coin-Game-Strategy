import exercise.GameExercise;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Test {
	public static void main(String[] args) {
		System.out.println("Dynamic Programming");
		System.out.println();

		Path instances = FileSystems.getDefault().getPath("instances/");
		Path solutions = FileSystems.getDefault().getPath("solutions/");

		GameExercise exercise = new GameExercise(instances, solutions);//bla
		try {
			exercise.run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
