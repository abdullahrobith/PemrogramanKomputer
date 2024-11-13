

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 *
 * @author LABKOM
 */
public class function {

    static String folder = ".LoggingProgramKasir";
    static String home = System.getProperty("user.home");
    static String pathFolder = home + File.separator + folder;

    static String logFile = "Log.txt";
    static String pathLog = pathFolder + File.separator + logFile;

    public static void logActivity(String activity) {
        try {
            File folder = new File(pathFolder);
            folder.mkdir();

            File fileLog = new File(pathLog);
            if (!fileLog.exists()) {
                fileLog.createNewFile();
            }

            Files.write(
                    Paths.get(pathLog),
                    activity.getBytes(),
                    StandardOpenOption.APPEND);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
