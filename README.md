

Java
==       project  --->:

set PATH=%PATH%;C:\soft\maven\bin

run NOW
 mvn -Dbrowser=chrome -Dsurefire.suiteXmlFiles=src\test\resources\testng-smoke.xml -Denvironment=hC clean test