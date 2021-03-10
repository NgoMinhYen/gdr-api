package globedr.selenium.constants;

public class FilePath {
    public static String PROJECT = System.getProperty("user.dir") + System.getProperty("file.separator");
    public static String MAIN_RESOURCES = PROJECT + "src" + System.getProperty("file.separator") + "main"
            + System.getProperty("file.separator") + "resources" + System.getProperty("file.separator");
    public static String SYSTEM_FILE = MAIN_RESOURCES + "system.properties";

    public static String TARGET = PROJECT + "target/";
    public static String DATA_RESOURCES = PROJECT + "src/test/resources/data/";
}
