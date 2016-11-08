#!/bin/sh

JAVA_HOME="~/Java-Training/JDK/Contents/Home"
PRGDIR=`dirname "$0"`
CLASSPATH="$PRGDIR/lib/Sevecek.net Utils/sevecek-net-utils.jar":"$PRGDIR/dist/aplikace.jar"
CLASS_TO_BE_RUN=${IJ_BASE_PACKAGE}.SpousteciTrida



echo  $JAVA_HOME/bin/java   -classpath "$CLASSPATH"   $CLASS_TO_BE_RUN
$JAVA_HOME/bin/java   -classpath "$CLASSPATH"   $CLASS_TO_BE_RUN




echo -n -e "\033]0;PrvniAplikaceShellScript\007"
osascript -e 'tell application "Terminal" to close (every window whose name contains "PrvniAplikaceShellScript")' &
