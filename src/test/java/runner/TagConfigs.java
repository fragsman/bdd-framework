package runner;

/**
 * This class will have different constants to be used in CucumberOptions to run
 * a specific group of tests or maybe ignore some others based on their tags
 * More configs can be added or removed as needed
 */
public class TagConfigs {

    //The following configs will run only one of type of test marked with one tag
    public static final String only_smoke = "@smoke";
    public static final String only_non_browser_tests = "@non_browser_tests";
    public static final String only_regression = "@regression";

    //The following configs will run such test that have either one of the defined tags
    public static final String smoke_or_non_browser_tests = "@smoke or @non_browser_tests";
    public static final String smoke_or_regression = "@smoke or @regression";

    //The following configs can be used to run all tests and except only one tag
    public static final String all_but_disabled = "not @disabled";
    public static final String all_but_regression = "not @regression";
    public static final String all_but_smoke = "not @smoke";
    public static final String all_but_non_browser_tests = "not @non_browser_tests";
}

