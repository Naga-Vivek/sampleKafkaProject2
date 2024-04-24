# Complete Flow to Run a Springboot - Kafka Project on Windows with kafka server running on WSL(Ubuntu/Linux)

## Prerequisite

* [How to install Apache Kafka on Windows using WSL](https://www.conduktor.io/kafka/how-to-install-apache-kafka-on-windows/)

## Guide

### After Installing Kafka Server on WSL, Follow the below steps:

_Add the Environment Variables in WSL terminal_
*   `export JAVA_HOME=/usr/lib/jvm/java-11-amazon-corretto`
*   `export PATH=$JAVA_HOME/bin:$PATH`
*   `export KAFKA_HOME=~/kafka_2.13-3.0.0`
*   `export PATH=$KAFKA_HOME/bin:$PATH`

_Disable IPv6 for WSL for Local Springboot Application to access Kafka or other services running inside WSL_

* `sudo sysctl -w net.ipv6.conf.all.disable_ipv6=1`
* `sudo sysctl -w net.ipv6.conf.default.disable_ipv6=1`

_Run the below command in WSL to start Zookeeper server_
* `zookeeper-server-start.sh $KAFKA_HOME/config/zookeeper.properties`

_Open second WSL terminal and start Kafka server_
* `kafka-server-start.sh $KAFKA_HOME/config/server.properties`

_On third WSL terminal , Verify whether Zookeeper and Kafka servers are up and running_
* `sudo ss -tulwnp`
* Default port for Zookeeper : 2181
* Default port for Kafka : 9092

_Fetch the IP address from WSL terminal using below command_
*  `ip addr | grep "eth0"`
*   The above command gives the output like 172.x.y.z which is used in the next step.

_Open Windows Cmd Prompt/Powershell as Administrator and run the below command_
* `netsh interface portproxy add v4tov4 listenport=9092 listenaddress=0.0.0.0 connectport=9092 connectaddress=172.x.y.z`

_Start the Springboot Application on Windows, which will connect to Kafka server(localhost:9092) running inside WSL._
