# assignment
For kafka related project, start the kafka message broker first by using below commands
  Move to bin folder and execute below command
    ./zookeeper-server-start.sh config/zookeeper.properties
  Next start the kafka server
    ./kafka-server-start.sh config/server.properties
  Execute below command to create topic named : exchange
    ./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic exchange
  Execute another command to create another topic named : converter
    ./kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic converter
  To check the list of all topic created 
    ./kafka-topics.sh --list --zookeeper localhost:2181
