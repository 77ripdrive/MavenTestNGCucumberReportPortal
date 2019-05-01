

Java
==       project  --->:

set PATH=%PATH%;C:\soft\maven\bin

run NOW  in master branch
 mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=hC clean test
https://mva.microsoft.com/MyMVA/Dashboard.aspx

BDD_Cucumber branch

mvn -Dbrowser=chrome verify

https://github.com/ashenwgt/awesome-bdd-with-cucumber