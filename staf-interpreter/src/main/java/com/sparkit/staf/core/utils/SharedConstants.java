package com.sparkit.staf.core.utils;

public final class SharedConstants {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
    public static final String TEST_DIRECTORY_PROPERTY = "testDirectory";
    public static final String TEST_DIRECTORY_PROPERTY_VALUE = "${testDirectory}";
    public static final String LIBRARY = "Library";
    public static final String ERROR_RESULT_STRING = "error";
    public static final String OK_RESULT_STRING = "ok";
    public static final String USER_DIR = "user.dir";
    public static final String READING_FILE_ERROR = "Error reading file";

    public static final String RUNNING_PROJECT = "Running project '{}'";
    public static final String NO_TEST_CASE_FOUND = "No test cases found, terminating tests";
    public static final String STARTED_RUNNING_TESTS = "Started running tests at {}";
    public static final String STARTED_TEST_SUITE_EXECUTION = "Started executing test suite : [{}] {} Test cases found";
    public static final String SCRIPT_EXECUTION_STOPPED = "Script execution stopped";
    public static final String STARTED_EXECUTING_TEST_CASES = "Started executing test case : [{}]";
    public static final String FINISHED_EXECUTING_TEST_CASES = "Finished executing test case : [{}] {} ";
    public static final String RECEIVED_TEST_TERMINATION_SIGNAL = "Received test termination signal : stopping tests ...";
    public static final String EXECUTING_STATEMENT_FAILED = "Executing statement failed at [{}] : {} | {}";

    public static final String CANNOT_FIND_IMPORTED_FILE = "Cannot find imported file '{}' at file [{}] on line {}";

    public static final String SETUP_TEST_CASE = "setup";
    public static final String TEARDOWN_TEST_CASE = "teardown";

    public static final String SESSION_ID_MEMORY_KEY = "$__session__";
    public static final String LOOP_INDEX_VAR_MEMORY_KEY = "$__index__"; // current loop index
    public static final String CURRENT_KEYWORD_MEMORY_KEY = "__keyword__";
    public static final String WEB_DRIVER_MEMORY_KEY = "__web_driver__";

    public static final String TEST_CASE_IGNORED = "Test case [{}] Ignored";
    public static final String TEST_EXECUTION_TERMINATED_BY_USER = "Test execution terminated by user";
    public static final String FILE_ALREADY_EXISTS = "File already exists";
    public static final String CANNOT_CREATE_FILE = "Cannot create file";
    public static final String CANNOT_CREATE_DIRECTORY = "Cannot create directory";
    public static final String FINISHED_RUNNING_TESTS = "Finished running tests at {}";

    public static final String TEST_SUITE_MAIN_FILE = "main.staf";
    public static final String LIBRARY_NOT_FOUND = "Library not found";
    public static final String CANNOT_FIND_KEYWORD = "Cannot find keyword";
    public static final String CANNOT_WRITE_TEST_RESULTS = "Cannot write test result file : {}";
    public static final String CANNOT_RENAME_PROJECT = "Cannot rename project";
    public static final String UNSUPPORTED_FILE_FORMAT_ERROR = "Error : Unsupported file format!";
    public static final String INVALID_IMPORT_PATH = "Invalid import path";
    public static final String SYNTAX_ERROR_AT = "Syntax Error at {}";
    public static final String NO_BROWSER_OPEN_ERROR = "No opened browser";
    public static final String NOT_AVAILABLE = "N/A";
    public static final String DEFAULT_UI_TEST_SUITE_NAME = "UI test suite";
    public static final String DEFAULT_API_TEST_SUITE_NAME = "API test suite";
    public static final String PROJECT_CONFIG_TEMPLATE_CLASSPATH = "classpath:config_template.json";
    public static final String MAYBE_YOU_ARE_MISSING_AN_IMPORT = "maybe you are missing an import";
    public static final String APPLICATION_JSON = "application/json";
    public static final String LOGGER_LIB_TEMPLATE = "[Logger Library] {}";

    public static final String LIST_INDEX_OUT_OD_BOUNDS = "List index [{}] out of bounds";
    public static final String DICTIONARY_DOESNT_CONTAIN_KEY = "Dictionary doesn't contain key : {}";
    public static final String OBJECTS_TYPES_DOESNT_MATCH_AT_INDEX = "Objects types doesn't match at index [";
    public static final String OBJECTS_VALUE_DOESNT_MATCH_AT_INDEX = "Objects value doesn't match at index [";
    public static final String LISTS_SIZES_ARE_NOT_EQUAL = "Lists sizes are not equal";
    public static final String DICTIONARIES_SIZES_ARE_NOT_EQUALS = "Dictionaries sizes are not equal";
    public static final String UNDEFINED_VARIABLE = "Undefined variable {}";
    public static final String INVOKING_KEYWORD = "Invoking Keyword : {}";

    private SharedConstants() {
    }
}
