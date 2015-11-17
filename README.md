<b>COWD as a service</b><br><br>
[![Build Status](https://travis-ci.org/cosm0s/cowd.png)](https://travis-ci.org/cosm0s/cowd)

<p>chmod +x install-service.sh<br>
su/br (root) ./install-service.sh<br><br>

JAR /usr/sbin<br>
LOG /var/log/cowd<br>
CONF /etc/cowd<br><br>

service <br>
/etc/init.d/cowd start|stop|status<br>
or<br>
service cowd start|stop|status<br><br>

<b>COWD as a app</b><br><br>

cd $PATH COWD<br><br>

options -s--seconds<br>
        -h--help<br>
./cowd<br>
./cowd -s 2<br><br>

or use config<br><br>

JAR $PATH/bin<br>
LOG $PATH/logs<br>
CONF $PATH/conf<br>
