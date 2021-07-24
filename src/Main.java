import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder logs = new StringBuilder();
        File file = new File("C://Games");
        logs.append(file.mkdir());

        File dir1 = new File(file, "src");
        logs.append(dir1.mkdir());
        File dir3 = new File(file, "saveGames");
        logs.append(dir3.mkdir());
        File dir2 = new File(file, "res");
        logs.append(dir2.mkdir());
        File dir4 = new File(file, "temp");
        logs.append(dir4.mkdir());

        File srcDir1 = new File(dir1, "main");
        logs.append(srcDir1.mkdir());
        File mainDir1 = new File(srcDir1, "Main.java");
        logs.append(mainDir1.mkdir());
        File mainDir2 = new File(srcDir1, "Utils.java");
        logs.append(mainDir2.mkdir());
        File srcDir2 = new File(dir1, "test");
        logs.append(srcDir2.mkdir());

        File resDir1 = new File(dir2, "drawables");
        logs.append(resDir1.mkdir());
        File resDir2 = new File(dir2, "vectors");
        logs.append(resDir2.mkdir());
        File resDir3 = new File(dir2, "icons");
        logs.append(resDir3.mkdir());

        File tempDir1 = new File(dir4, "temp.txt");
        logs.append(tempDir1.createNewFile());
        System.out.println(logs);
        FileWriter fileWriter = new FileWriter(tempDir1);
        fileWriter.write(logs.toString());
        fileWriter.flush();
        fileWriter.close();

        GameProgress game1 = new GameProgress(100, 3, 10, 20.0);
        GameProgress.saveGame("C://Games//saveGames", game1);
        List<String> paths = Collections.singletonList("C://Games//saveGames//saving");
        GameProgress.zipFiles("C://Games//saveGames//archievedSavings.zip", paths);
    }
}