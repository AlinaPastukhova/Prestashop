# Final Project
To run this project you need to have installed:
* java 8
* allure-2.17.3
* apache-maven-4.0.0
------------------------------------------------------------

To start testing with default params you need simply run
in the root of a cloned Final Project :
```shell
mvn clean test
```
This command will start test with this default params:
* `suite` - testng
* `browser` - chrome
* `threads` - 1
* `resolution` - full

## Available params

### -Dsuite
Here you can set testng.xml file with tests configurations. Important! Use only file name without extension!

### -Dbrowser
Here you can set browser to run test, available browsers:
* `chrome`


### -Dthreads
Here you can set number of threads, that will be using all available cores.
Default value is `1`

### -Dresolution
Set resolution to start test with. Full screen is used by default.
You need to set resolution in format `{width}x{height}`
For example: `1024x768`

### For example
mvn clean test -Dresolution=1024x768 -Dbrowser=chrome -Dthreads=1

### For starting "allure" and check results
Simply run:
mvn allure::serve

