package globedr.selenium.common;

public class OS {
    private static String OS = System.getProperty("os.name").toLowerCase();
    public static boolean IS_WINDOWS = (OS.indexOf("win") >= 0);
    public static boolean IS_MAC = (OS.indexOf("mac") >= 0);
    public static boolean IS_UNIX = (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0);
    public static boolean IS_SOLARIS = (OS.indexOf("sunos") >= 0);


    public static PLATFORM getCurrent() {
        if (IS_WINDOWS) {
            return PLATFORM.WINDOWS;
        } else if (IS_MAC) {
            return PLATFORM.MAC;
        } else if (IS_UNIX) {
            return PLATFORM.UNIX;
        } else if (IS_SOLARIS) {
            return PLATFORM.SOLARIS;
        } else {
            try {
                throw new Exception("Your OS is not support!!");
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
        return null;
    }


    public enum PLATFORM {
        WINDOWS,
        MAC,
        UNIX,
        SOLARIS
    }

    public static void main(String[] args) {

        System.out.println("os.name: " + OS);

        if (IS_WINDOWS) {
            System.out.println("This is Windows");
        } else if (IS_MAC) {
            System.out.println("This is Mac");
        } else if (IS_UNIX) {
            System.out.println("This is Unix or Linux");
        } else if (IS_SOLARIS) {
            System.out.println("This is Solaris");
        } else {
            System.out.println("Your OS is not support!!");
        }
    }

}
