#!/bin/bash

if [[ $EUID -ne 0 ]]; then
  echo "You must be a root user" 2>&1
  exit 1
fi

COWD_HOME=$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )

MAIN_JAR=`ls -1tr ${COWD_HOME}/bin/cowd-*.jar|tail -1`

echo Creating directories...

if [ ! -d /var/log/cowd/ ]; then
    mkdir /var/log/cowd/
    echo /var/log/cowd DONE
fi

if [ ! -d /etc/cowd/ ]; then
    mkdir /etc/cowd/
    echo /etc/cowd DONE
fi


echo Copying...
cp ${MAIN_JAR} /usr/sbin
echo JAR in /usr/sbin DONE
cp ${COWD_HOME}/conf/config.properties /etc/cowd/
echo config.properties in /etc/cowd/ DONE
cp ${COWD_HOME}/bin/cowd /etc/init.d/
echo script service in /usr/sbin/ DONE

touch /var/log/cowd/cowd.log

echo Set permissions
chown root:root /usr/sbin/cowd-*.jar
chmod u+rwx,g+rx,o+rx /usr/sbin/cowd-*.jar
chmod =r,u+w /etc/cowd/config.properties
chown root:root /etc/init.d/cowd
chmod u+rwx,g+rx,o+rx /etc/init.d/cowd

echo Service cowd installed