export enum StafAPI {
  GET_PROJECTS = '/projects',
  CREATE_PROJECT = '/projects',
  UPDATE_PROJECT = '/projects',
  DELETE_PROJECT = "/projects",
  UPLOAD_PROJECT = '/projects/upload',
  UPDATE_PROJECT_CONFIG = '/projects/config',
  CREATE_FILE = '/create-file',
  SAVE_FILE = '/save-file',
  RENAME_FILE = '/rename-file',
  DELETE_FILE = '/delete-file',
  GET_TEST_SUITE_DETAILS = '/test-suite',
  CREATE_TEST_SUITE = '/test-suite',
  RENAME_TEST_SUITE = '/test-suite',
  DELETE_TEST_SUITE = '/test-suite',
  COMPILE_PROJECT = '/compile/project',
  COMPILE_FILE = '/compile/file',
  COMPILE_TEST_SUITE = '/compile/test-suite',
  GET_SCREENSHOT = '/screenshot',
  GET_PROJECT_REPORTS = '/project-reports',
  GET_REPORTS_DIRECTORY = '/projects/reports-directory',
  GET_TEST_REPORT_FILE = '/test-report',
  GET_DIRECTORY = "/directory",
  RUN_TEST = '/test/run',
  TERMINATE_TEST = '/test/terminate',
  BUILTIN_KEYWORD_DOCS = '/docs/builtin',
  GET_HOST_ADDRESS = '/host-address',
  LOGIN = "/auth/sign-in"
}