#!/bin/sh
#=====================================================================#
#---------------------------------------------------------------------#
#              Proprietary and Confidential Information               #
#                  and Intellectual Property of CA                    #
#                       Copyright (C) 2009 CA                         #
#                        All Rights Reserved.                         #
#---------------------------------------------------------------------#
#       NOTE : All lines that start with '#' are comment lines        #
#---------------------------------------------------------------------#
#=====================================================================#
# Save the current working directory
savecwd=`pwd`
#echo Current PWD is $savecwd

# Get the location of MSMDeploy.sh file location
localPath=`dirname $0`

# Change the directory to MSMDeploy.sh file location
cd $localPath
msmdir=`pwd`
# Argument $1
OptFilePath=./MSMSetupOptionsFile.properties

# Argument $1
FuncTyp=$1

checkArgs(){
   	echo "Usage: ./MSMDeploy.sh arg1 "
	echo "arg1  Function Type - deploy or backout "
	echo "e.g. ./MSMDeploy.sh deploy "
    exit 4
}
# Check whether Options file exists or not
if [ -s $OptFilePath ]
then
    #echo "$OptFilePath exists"
else
    echo "CA MSM options file $OptFilePath doesn't exist or the file may be empty.  "
    checkArgs
    exit 4
fi

# checking second arugument function type should not be blank
if [ $FuncTyp ]
then
 #echo ""
 else	
	echo "arg1 can not be blank (Possible values are deploy/backout)."
	checkArgs
	exit 4
fi



# java.prerequisite.version = 1.6
DefFile="$msmdir/lib/MSMSetupDefault.properties"
#REQ_VER=`grep "java.prerequisite.version" $DefFile | sed -n '/#/!p' | awk -F= '{print $2}' 
REQ_VER=1.6
VER=$REQ_VER
MODE=64
SignWord="equal"
Sign=

ComSign="EQ"

if [ $ComSign = 'EQ' ]
then
	Sign='eq'
	SignWord="equal"
else
	Sign='ge'
	SignWord="above"
fi
#echo $Sign




# Clearing the screen for viewing the full screen
clear
echo "--------------------------------------------------------------------------------"
echo "================================================================================"
echo "       *****    CA MSM (2.0) MAINFRAME SOFTWARE MANAGER UPDATE     *****        "
echo "================================================================================"
echo "                                                                                "
echo " This script verifies the below                                                 "
echo "                                                                                "
echo " 1. Existence of MSMSetupOptionsFile.properties file in current path.           "
echo " 2. Valid JAVAPATH parm field in Options file.                                  "
if [ $Sign = "eq" ]
then
	echo " 3. Java SDK $REQ_VER and AMODE 64-bit version.                             "
else
	echo " 3. Java SDK $REQ_VER or above and AMODE 64-bit version.                    "
fi
echo "                                                                                "
echo "================================================================================"
echo "                                                                                "
# Converting the String to Number by changing the . to 0
REQ_VER=`echo $REQ_VER | sed -e 's;\.;0;g'`


#echo MSMSetup directory is $msmdir

# Check whether option file exists
OptFile=$OptFilePath
#if [ -f $OptFile ] && [ -s $OptFile ]
if [ -s $OptFile ]
then
    #echo "$OptFile exists"
else
    echo "CA MSM options file $OptFile doesn't exist or the file may be empty.      "
    echo " Please check GIMUNZIP job for  successful extraction of options file.    "
    exit 4
fi

RunTimeUSSPath=`grep -i "RunTimeUSSPath=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`
if [ $RunTimeUSSPath ]
then
	echo "RunTimeUSSPath = $RunTimeUSSPath"
else
	echo "                                                                             "
	echo "RunTimeUSSPath is appeared blank in"
	echo "$OptFile"
	exit 4
fi

MSMPATH=`grep -i "MSMPATH=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`
if [ $MSMPATH ]
then
	echo "MSMPATH = $MSMPATH"
else
	echo "                                                                             "
	echo "MSMPATH is appeared blank in"
	echo "$OptFile"
	exit 4
fi

RunTimeMVSHLQPrefix=`grep -i "RunTimeMVSHLQPrefix=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`
if [ $RunTimeMVSHLQPrefix ]
then
	echo "RunTimeMVSHLQPrefix = $RunTimeMVSHLQPrefix"
else
	echo "                                                                             "
	echo "RunTimeMVSHLQPrefix is appeared blank in"
	echo "$OptFile"
fi

SMPOTHHLQ=`grep -i "SMPOTHHLQ=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`
if [ $SMPOTHHLQ ]
then
	echo "SMPOTHHLQ = $SMPOTHHLQ"
else
	echo "                                                                             "
	echo "SMPOTHHLQ is appeared blank in"
	echo "$OptFile"
	exit 4
fi

CCScaipdsedsn=`grep -i "CCScaipdsedsn=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`
if [ $CCScaipdsedsn ]
then
	echo "CCScaipdsedsn = $CCScaipdsedsn"
else
	echo "                                                                             "
	echo "CCScaipdsedsn is appeared blank in"
	echo "$OptFile"
	exit 4
fi

# Extract the JAVAPATH from Options file
dir1=`grep -i "JAVAPATH=" $OptFile | sed -n '/#/!p' | awk -F= '{print $2}' | awk '{print $1}'`



#if test $? -eq 0
#then
#    echo "Extraction of JAVAPATH= $dir1"
#else
#    echo "Extraction of JAVAPATH failed"
#fi

#if test -z $dir1
if [ -z $dir1 ]
then
    echo "JAVAPATH is null. Please provide the path in Options File"
    exit 4
fi

# Check if the JAVAPATH exists
#if [ -d $dir1 ] && [ -n $dir1 ]
if test -d $dir1
then
    #echo "Java $dir1 exists"
    export PATH=$dir1/bin:$PATH
else
    echo "The JAVAHOME path doesn't exist or the provided path is null. Please"
    echo "provide the path where the Java SDK Version >=1.6 & 64 bit is installed."
    exit 4
fi

# Check for JAVA 1.6 and 64 bit version using java -version cmd
#$java -version 1>$localPath/java.ver
java -version 2>java.ver
if [ $? -eq 0 ]
then
    #echo "java version command successful"
else
    echo "java -version check command failed"
    echo "Please check the Java home path provided in OptionsFile is a"

    if [ $Sign = "eq" ]
	then
	echo "valid Java SDK $VER and 64-bit addressing mode version. "
	else
	echo "valid Java SDK $VER or above and 64-bit addressing mode version. "
	fi

   rm java.ver
    exit 4
fi

#VERSION=`cat java.ver | grep "IBM" | awk '{print $7}'`
VERSION=`cat java.ver | grep "IBM" | awk '{print $7}'`
if test $? -eq 0
then
    #echo $VERSION found
else
    echo "unable to find the VERSION"
    exit 4
fi

AVL_VER=$VERSION
VERSION=`echo $VERSION | sed -e 's;\.;0;g'`

R="00"
REQ_VER=$REQ_VER$R

#if test $VERSION -ge $REQ_VER

if [ $VERSION -$Sign $REQ_VER ]
then
   #echo "Installed Java version $VERSION is, ok for Installing CA MSM"
else
	
	if [ $VERSION -lt $REQ_VER ]
	then
	
    echo "Installed Java $AVL_VER is less than SDK $VER version"
    echo "Please provide the SDK $VER version JAVAPATH in the Options file"
    echo "                             "
    echo "Exiting from CA MSM Installer..."
    else

    echo "Installed Java $AVL_VER is above than SDK $VER version"
    echo "Please provide the SDK $VER version JAVAPATH in the Options file"
    echo "                             "
    echo "Exiting from CA MSM Installer..."
    fi
    #rm java.ver
    exit 4
fi

#ODE1=`cat java.ver | grep "IBM" | awk '{print $12}' | awk -F- '{print $2}'`
MODE1=`cat java.ver | grep "IBM" | awk '{print $12}' |awk -F- '{print $ 2}'`
if test $? -eq 0
then
    #echo $MODE1 found
else
    echo "Unable to load JVM and find Java addressing mode from the command output."
    echo "Please provide a valid java SDK Version $VER and 64-bit AMODE"
    echo "version. Check TSO or BATCH region size. Min requirement is 128 MB."
    echo "Exiting the CA MSM Deploy Process."
    exit 4
fi

rm java.ver

#if test $MODE1 -eq $MODE
if [ $MODE1 -eq $MODE ]
then
    #echo "Java version is 64 bit AMODE"
else
    echo "  Installed Java version's AMODE is $MODE1"
    echo "  Please provide valid Java SDK V$VER or above and 64-bit AMODE"
    echo "  version. Exiting CA MSM Setup Process."
    exit 4
fi

loggermar=$MSMPATH/CEGPJAR/commons-logging-1.1.1.jar
log4jar=$MSMPATH/CEGPJAR/log4j-1.2.15.jar
#smdeployJar=$MSMPATH/CEGPJAR/MSMDeploy.jar
msmdeployJar=$MSMPATH/CEGPJAR/MSMDeploy.jar
ibmjar=$dir1/lib/ext/ibmjzos.jar

if [ -s $loggerJar ]
then
    #echo "$loggerJar exists"
else
    echo "$loggerJar doesn't exist or the file may be empty.      "
    exit 4
fi


if [ -s $log4jar ]
then
    #echo "$log4jar exists"
else
    echo "$log4jar doesn't exist or the file may be empty."
    exit 4
fi


if [ -s $ibmjar ]
then
    #echo "$ibmjar exists"
else
    echo "$ibmjar doesn't exist or the file may be empty."
    exit 4
fi

if [ -s $msmdeployJar ]
then
    #echo "$msmdeployJar exists"
else
    echo "$msmdeployJar doesn't exist or the file may be empty."
    exit 4
fi

# Set the PATHs required for the MSMInstaller invocation
export CLASSPATH=$CLASSPATH:$MSMPATH/CEGPJAR/log4j-1.2.15.jar
export CLASSPATH=$CLASSPATH:$MSMPATH/CEGPJAR/MSMDeploy.jar
export CLASSPATH=$CLASSPATH:$MSMPATH/CEGPJAR/commons-logging-1.1.1.jar
export CLASSPATH=$CLASSPATH:$dir1/lib/ext/ibmjzos.jar
export LIBPATH=$localPath
export LIBPATH=$LIBPATH:$MSMPATH/CEGPJAR

#Saving the default permission for logged user.
defaultPermission=`umask`
#Setting the 775 permssion for logged user.
umask 002

#Invoke MSM Deployer Component
java com.ca.mf20.msmsetup.cp.CopyFiles $FuncTyp ALL $RunTimeUSSPath $MSMPATH $RunTimeMVSHLQPrefix $SMPOTHHLQ $CCScaipdsedsn
exitcode=$?

#Resetting the default permission for logged user.
umask $defaultPermission

#!/bin/sh
if [ $exitcode -eq 4 ]
then
exit 4
fi
# Set the saved working directory
cd $savecwd

