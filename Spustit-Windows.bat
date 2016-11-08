@echo off

rem Je nutne nize nastavit CLASS_TO_BE_RUN na spravnou spousteci tridu!!!!
set "CLASS_TO_BE_RUN=net.sevecek.SpousteciTrida"
set "CLASSPATH=%~dp0lib\Sevecek.net Utils\sevecek-net-utils.jar"
set "APP_JAR=%~dp0dist\aplikace.jar"
set "BUILD_CLASSES_CLASSPATH=%~dp0build\classes"
set "PREFERRED_JDK_HOME=C:\Java-Training\JDK"
set "EXE_NAME=javaw"

if not exist "%APP_JAR%"    set EXE_NAME=java

if exist "%PREFERRED_JDK_HOME%\bin\%EXE_NAME%.exe" (
    set   "JAVA_HOME=%PREFERRED_JDK_HOME%"
)

if not "%JAVA_HOME%" == "" (
    set   "JAVA_EXE=%JAVA_HOME%\bin\%EXE_NAME%"
)

if exist "%JAVA_EXE%" (
    goto RUN
)


rem Detect Java on the computer
for /f "delims=" %%i in ('call "where"  "%EXE_NAME%"') do (
    set "JAVA_EXE=%%i"
    goto :RUN
)
msg   "%USERNAME%"   "Bohuzel jsme nenasli Javu na vasem pocitaci. Bud si ji nainstalujte z http://java.oracle.com/ nebo provedte instalaci podle stranek http://javabrno.czechitas.net/"
goto :EOF



:RUN
if exist "%APP_JAR%" (
    goto RUN_JAR
)


:RUN_BUILD_CLASSES
set "CLASSPATH=%CLASSPATH%;%BUILD_CLASSES_CLASSPATH%"
echo "%JAVA_EXE%"   -classpath "%CLASSPATH%"   %CLASS_TO_BE_RUN%
"%JAVA_EXE%"   -classpath "%CLASSPATH%"   %CLASS_TO_BE_RUN%

if not errorlevel 1   goto :EOF
echo.
echo.
echo Nejspis nastala nejaka chyba.
echo Pokud ta chyba je Could not find or load main class "%CLASS_TO_BE_RUN%":
echo     Main class byla hledana ve slozce %BUILD_CLASSES_CLASSPATH%
echo     Byl tam hledan soubor %CLASS_TO_BE_RUN:.=\%.class (trida %CLASS_TO_BE_RUN%)
echo     Pokud mate ve slozce %BUILD_CLASSES_CLASSPATH% jinou spousteci tridu, muzete ji nastavit na zacatku v tomto souboru (%~n0%~x0)
pause
goto :EOF


:RUN_JAR
set "CLASSPATH=%CLASSPATH%;%APP_JAR%"
echo "%JAVA_EXE%"   -classpath "%CLASSPATH%"   %CLASS_TO_BE_RUN%
start   "Java aplikace"   "%JAVA_EXE%"   -classpath "%CLASSPATH%"   %CLASS_TO_BE_RUN%
goto :EOF
