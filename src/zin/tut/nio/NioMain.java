package zin.tut.nio;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static zin.tools.ZIO.*;

public class NioMain {

	public void paths() {
		Path directoryOfThisFile = Paths.get("src", "zin", "tut", "nio");
		Path thisFile = directoryOfThisFile.resolve("NioMain.java");
		try (BufferedReader bufferedReader = Files.newBufferedReader(thisFile)) {
			for(String s = bufferedReader.readLine(); s != null ; s = bufferedReader.readLine()) {
				print(s);
			}
		} catch (Exception e) { }
		finally { }
	}
	
}
