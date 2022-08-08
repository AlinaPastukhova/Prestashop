# Final Project
To run this project you need to have installed:
* java 8
* allure-2.17.3
------------------------------------------------------------

To start testing with default params you need simply run
in the root of a cloned Final Project :
```shell
mvn clean test
```

This command will start test with this default params:
* `suite`- testng
* `browser` - chrome
* `threads` - 1
* `resolution` - 1280X1024

To start testing with parameterize you need enter the command:
```shell
mvn clean test -Dsuite=testng -Dbrowser=chrome -DthreadCount=3 -DbrowserWidth=1280 -DbrowserHeight=1024
```

### -Dsuite 
`"testng"` this is name of the XML file to run.

### -Dbrowser
`"chrome"` this browser will open when we will run our test.

You can start test with other browser:

* `chrome (default)`
* `firefox`
* `safari`

### -DthreadCount
`"3"` we set 3 numbers of threads, that will be using when test will be run.

### -DbrowserWidth and -DbrowserHeight
`"1280X1024"` it is screen of a size.

### For starting "allure" and check results
Simply run:
`mvn allure::serve`