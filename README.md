# kafka-appender

This appender lets your application/microservice publish its logs directly to Apache Kafka.

## Integration example

1 - Build this project with maven :
```
mvn clean install
```
2 - Add this dependency to the project you want to publish its logs to Apache Kafka :
```xml
<dependency>
   <groupId>com.erpdhmit</groupId>
   <artifactId>kafka-appender</artifactId>
   <version>1.0</version>
</dependency>
```
3 - Add this configuration file to the classpath of the project you want to publish its logs to Apache Kafka:
```xml
[src/main/resources/logback-spring.xml]
<?xml version="1.0" encoding="UTF-8" ?>
<configuration>
    <springProfile name="local">
        <appender name="KAFKA"
                  class="com.erpdhmit.kafka.KafkaAppender">
            <topic>crm-logs</topic>
            <kafkaProducerProperties>
                bootstrap.servers=192.168.99.100:9092
                value.serializer=org.apache.kafka.common.serialization.StringSerializer
                key.serializer=org.apache.kafka.common.serialization.StringSerializer
            </kafkaProducerProperties>
        </appender>

        <appender name="KAFKA-ASYNC" class="ch.qos.logback.classic.AsyncAppender">
            <appender-ref ref="KAFKA"/>
        </appender>

        <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
            <encoder>
                <pattern>%d{HH:mm:ss.SSS} [%thread] %-5level %logger{36} - %msg%n</pattern>
            </encoder>
        </appender>

        <root level="info">
            <appender-ref ref="KAFKA-ASYNC"/>
            <appender-ref ref="STDOUT"/>
        </root>
    </springProfile>
</configuration>
```
In previous configuration file, i have added 2 appenders :

a - Console appender

b - Kafka appender

Don't forget to update **bootstrap.servers** URL,  **topic** name and **spring profile** with your own's.