import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class GameProgress implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private final int health;
    private final int weapons;
    private final int lvl;
    private final double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    public static void saveGame(String path, GameProgress game) throws IOException {
        File file = new File(path, "saving");
        System.out.println(file.createNewFile());

        try (FileOutputStream fileOutput = new FileOutputStream(file)) {
            byte[] text = game.toString().getBytes();
            fileOutput.write(text);
        } catch (IOException er) {
            System.out.println(er.getMessage());
        }
    }

    public static void zipFiles(String path, List<String> files) {
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(path))) {
            for (String file : files) {
                FileInputStream fis = new FileInputStream(file);
                ZipEntry entry = new ZipEntry("saving");
                zout.putNextEntry(entry);
                byte[] buffer = new byte[fis.available()];
                int isRead = fis.read(buffer);
                zout.write(buffer);
                zout.closeEntry();
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Game Progress{" +
                "health = " + health +
                ", weapons = " + weapons +
                ", lvl = " + lvl +
                ", distance = " + distance +
                "}";
    }
}