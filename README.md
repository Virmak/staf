# Stark test automation framework

**STAF** is a test automation framework that makes it easy to write tests in a Domain Specific Language written in JAVA

## Installation

Clone git repo and use maven to install dependencies.

```bash
git clone https://github.com/virmak/staf
cd staf
mvn install
./build.sh # build a fat jar
```

## Usage

```bash
java -jar staf-1.0-SNAPSHOT-jar-with-dependencies.jar config.json
```
Replace **config.json** with the config file

## Configuration

The framework is configured using a conf json file

Example:

```json
{
  "testDirectory": "test_suites",
  "logDirectory": "logs/app.log",
  "test_suites": [
      "testsuite1",
      "testsuite2"
  ]
}
```
- **testDirectory** : The directory where the test suites are placed
- **logDirectory** : Log file path
- **test_suites** : Test suites list to be executed

## Tests structure

To write the tests you need to define a specific structure. 
- First, you need to create a folder that contains all the test suites. You need to write the name of this folder in  the config file  ***testDirectory*** element
- Create a folder for each test suite defined in config file
- Every test suite folder need to have a ***main.staf*** script that contains test cases

**STAF** gives you the freedom to define whatever structure you need inside the test suites folders. But for better organization, you can use the structure below:

- Create a ***pages*** folder
- Write a ***\*.page*** file to define the UI element's selectors and keywords related to each web page. Generally, the keywords defined here are to check the presence of the defined elements selectors
- Create a ***steps*** folder
- Write a ***\*.steps*** file to define keywords that uses **.page** variables and keywords to replicate user actions

## Builtin keywords libraries
**STAF** framework uses libraries as a way to extend the framework capabilities in an easy way. The framework comes with a number of built-in libraries:

### Selenium Library
| Keyword       | Arguments | Description |
|---------------|-----------|-------------|
|Open browser   | browser: ***string***|Open browser|
|Close browser  |     | Close browser |
|Go to          | url: ***string***   | Open page with ***url***
|Input text     | selector: ***string*** | Set input text |
|Click element  | selector: ***string*** | Click specified element|
|Input value    | selector: ***string*** | Get input value attribute|
| Capture page screenshot | filename: ***string***| Take screenshot|
|Wait until element is visible | selector: ***string*** [timeout: ***int*** = 10 seconds] | This will make selenium wait for ***timeout*** seconds (default 10) until the element is visible|
|Wait until element is enabled | selector: ***string*** [timeout: ***int*** = 10 seconds] | This will make selenium wait for ***timeout*** seconds (default 10) until the element is enabled|
|Element should be visible| selector: ***string***|Element should be visible or an exception is raised|
|Element should contain|expected: ***string*** [message: ***string***]| Element should contain expected text or an error with ***message*** is raised|




## Contributing
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.

Please make sure to update the tests as appropriate.

## License
[MIT](https://choosealicense.com/licenses/mit/)