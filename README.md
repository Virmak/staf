
# Stark test automation framework  
  
**STAF** is a test automation framework that makes it easy to write tests in a Domain Specific Language written in JAVA  
  
## Getting started  
  
### Prerequisites  
  
Before building the project you need to have JDK and maven installed  
  
### Installation  
  
Clone git repo and use maven to install dependencies.  
  
```bash  
git clone https://github.com/virmak/staf  
```  
  
Install maven dependencies  
```bash  
cd staf  
mvn install  
```  
  
To build the project run build.sh  
```  
./build.sh  
```  
  
### Usage  
  
```bash  
java -jar staf-1.0-SNAPSHOT-jar-with-dependencies.jar config.json  
```  
Replace **config.json** with the config file  
  
## Configuration  
  
The framework is configured using a conf json file  
  
Example:  
  
```json  
{  
	"testDirectory": "testSuites", 
	"logDirectory": "logs/app.log", 
	"testSuites": [ 
		"testsuite1", 
		"testsuite2"
	]
}  
```  
- **testDirectory** : The directory where the test suites are placed  
- **logDirectory** : Log file path  
- **testSuites** : Test suites list to be executed  
  
## Tests directory structure  
  
To write the tests you need to define a specific structure.   
- First, you need to create a folder that contains all the test suites. You need to write the name of this folder in  the config file  ***testDirectory*** element  
- Create a folder for each test suite defined in config file  
- Every test suite folder need to have a ***main.staf*** script that contains test cases  
  
**STAF** gives you the freedom to define whatever structure you need inside the test suites folders. But for better organization, you can use the structure below:  
  
- Create a ***pages*** folder  
- Write a ***\*.page*** file to define the UI element's selectors and keywords related to each web page. Generally, the keywords defined here are to check the presence of the defined elements selectors  
- Create a ***steps*** folder  
- Write a ***\*.steps*** file to define keywords that uses **.page** variables and keywords to replicate user actions  
  
## Built-in keywords libraries  
**STAF** framework uses libraries as a way to extend the framework capabilities in an easy way. The framework comes with a number of built-in libraries:  
  
### Selenium Library  
  
Usage :   
```  
IMPORT selenium  
```  
Keywords  
  
| Keyword       | Arguments | Description |  
|---------------|-----------|-------------|  
|Open browser   | `browser`: ***string***|Open browser|  
|Close browser  |     | Close browser |  
|Go to          | `url`: ***string*** | Open page with ***url***  
|Input text     | `selector`: ***string*** | Set input text |  
|Click element  | `selector`: ***string*** | Click specified element|  
|Input value    | `selector`: ***string*** | Get input value attribute|  
| Capture page screenshot | `filename`: ***string***| Take screenshot|  
|Wait until element is visible | `selector`: ***string*** [`timeout`: ***int*** = 10 seconds] | This will make selenium wait for ***timeout*** seconds (default 10) until the element is visible|  
|Wait until element is enabled | `selector`: ***string*** [`timeout`: ***int*** = 10 seconds] | This will make selenium wait for ***timeout*** seconds (default 10) until the element is enabled|  
|Element should be visible| `selector`: ***string***|Element should be visible or an exception is raised|  
|Element should contain|`expected`: ***string*** [`message`: ***string***]| Element should contain expected text or an error with custom ***message*** is raised|  
  
## Logger library  
  
Usage :   
```  
IMPORT logger  
```  
Keywords  
  
| Keyword       | Arguments | Description |  
|---------------|-----------|-------------|  
|Log            | `data`: ***string*** | Log to debug channel |  
|Log info       | `data`: ***string*** | Log to info channel |  
|Log warn       | `data`: ***string*** | Log to warn channel |  
|Log error      | `data`: ***string*** | Log to error channel |  
  
## JSON library  
  
Usage :   
```  
IMPORT json  
```  
Keywords  
  
| Keyword       | Arguments | Description |  
|---------------|-----------|-------------|  
|Read JSON      | `filePath`: ***string*** | Read a JSON file into a dictionary variable|  
|Write JSON     | `object`: ***dictionary &#124; list***, `filePath`: ***string***| Write dictionary or list to a json file  
  
## Web service library  
  
Usage :   
```  
IMPORT ws  
```  
Keywords  
  
| Keyword       | Arguments | Description |  
|---------------|-----------|-------------|  
|Get            | `url`: ***string***, `jsonPath`: ***string***, `condition`: ***string***, `expected`: ***object***, `expectedStatusCode`: ***int*** | Make a http GET request and verify if condition with expected value and status code are valid|  
|Post           | `url`: ***string***, `postDataDict`: ***dictionary***, `jsonPath`: ***string***, `condition`: ***string***, `expected`: ***object***, `expectedStatusCode`: ***int*** | Make a http POST request with a json payload if specified, and verify if condition with expected value and status code are valid|  
  
## The STAF language  
STAF is a domain-specific language to write tests in an easy language similar to writing English.   
### Sections  
A *.staf* file have 4 sections :   
1. **IMPORTS**: In this section, you can import libraries and **.staf** files  
2. **VARS**: Variables declaration section  
3. **KEYWORDS**: Keywords declaration  
4. **TEST CASES**: Test cases declaration  
  
  
> All sections are optional, a **.staf** file can contain one or more section from above  
  
### 1. IMPORTS Section  
  
In this section, we define imported .staf files and libraries.   
  
To import a staf file use   
```  
IMPORT "./relative_path.staf"  
```  
  
To import a built-in library use  
```  
IMPORT selenium  
```  
  
### 2. VARS Section  
  
In this section, we declare variables. A staf variable must begin with a '$' sign, followed by alphanumeric characters. A variable declaration is just an assignment. Example :  
```  
$element = "value"  
```  
  
### 3. KEYWORDS Section  
  
In this section, we will write user-defined keywords. A keyword is just like a function in programming languages, it may have arguments and a return value.   
  
A keyword is defined as follow :  
The keyword name, it can have spaces. Then we define arguments inside the parenthesis.   
  
The body of the keyword may contain any type of statement, `Assignment`, `Keyword Call`, `For Loop`, `Run keyword if` statement. If the keyword has a return value, we use `RETURN $val`. If the keyword does not return anything we write `END` to close the keyword declaration  
   
Example :  
```  
User Defined Keyword Name($arg1, $arg2)  
    STATEMENTS*  
END  
```  
  
### 4. TEST CASES  
  
Test cases are very similar to keywords, because both of their bodies have statements like `Assignment`, `Keyword Call`, `For Loop`... The only difference between them is that test cases don't have arguments nor return value. To write a test case just give it a name followed by `:` char. Example: `Test case name:`, then the body statements then use the `END` keyword  
  
Example :   
```  
Test case name:  
    STATEMENTS*  
END  
```  
  
## STAF Data types  
  
The STAF language defines primitive types and data structures.   
  
### Primitive data types  
  
- **String**: to define a string literal you can use `"` or `'` Example : `"string literal"`  
- **Integer**: to define an integer literal. Example: `132`  
- **Double**: to define a double literal. Example: `2.50`  
- **Boolean**: can have `true` or `false`  
  
### Data structure  
  
- **Dictionary**: to write a dictionary literal use: `{ item: "value", "item2": 987 }`  
- **List**: to write a list literal use: `[1, 2, "3"]` 
> The same list can have different items types  
  
### FOR loop  
  
The for-in loop is used to loop through a list items.  
  
Example:  
```  
FOR $i : $list  
    STATEMENT*  
END  
```  

## Full example
This is a small script that uses selenium library to open google.com then search for "test automation"
```
TEST SUITE "Google search"
IMPORTS
	IMPORT	selenium
VARS
	$url = "https://google.com" 	# variable declaration
	$search_input 		= "name:q"	# search input name selector
	$search_btn			= "name:btnK"
	$result_selector 	= "tag:h3"	# tag name selector
KEYWORDS
	Open google()
		Open browser()
		Go to($url)
	END

	Search($text)
		Wait until element is visible	($search_input)
		Input text						($text)
		Wait until element is visible	($search_btn)
		Click button					()
	END
TEST CASES
	Test google search:
		Open google				()
		Search					("test automation")
		Element should contain	($result_selector, "Test automation")
	END
```
## Built With

* [ANTLR](https://github.com/antlr/antlr4/blob/master/doc/index.md) - Parser generator
* [Maven](https://maven.apache.org/) - Dependency Management
* [Selenium](https://www.selenium.dev/docs/) - Browser automation
* [Reflections](https://github.com/ronmamo/reflections) - Reflections library
* [RestAssured](https://logging.apache.org/log4j/1.2/manual.html) - Java APIs testing library 
* [Json-Simple](https://code.google.com/archive/p/json-simple/) - Java JSON library
* [Log4J](https://logging.apache.org/log4j/1.2/manual.html) - Logging library
  
## Contributing  
Pull requests are welcome. For major changes, please open an issue first to discuss what you would like to change.  
  
Please make sure to update the tests as appropriate.  
  
## License  
[MIT](https://choosealicense.com/licenses/mit/)