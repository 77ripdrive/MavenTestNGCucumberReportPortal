

Java
==       project  --->:
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=hardCore clean test
mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-all -Denvironment=hardCore clean test
Now: mvn -Dbrowser=chrome  clean test
