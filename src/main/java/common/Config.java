package common;

public class Config {

    /**
     * Specify the browser and platform for tests
     * CHROME_WINDOWS
     * CHROME_LINUX
     * MOZILLA_WINDOWS
     **/
    public static final String BROWSER_AND_PLATFORM = "CHROME_WINDOWS";

    /** Clear browser cookies after each iteration */
    public static final Boolean CLEAR_COOKIES = false;

    /** To keep the browser open after all tests */
    public static final Boolean HOLD_BROWSER_OPEN = false;

    /** Clear folders with screenshots before starting build */
    public static final Boolean CLEAR_REPORTS_FOLDER = true;
}
