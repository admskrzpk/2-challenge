# Challenge #2: Kafka App
NOTE FIXME: app does not contain scopt implementation. All arguments needs to be passed manually, or hardcoded.
## About the Project
```text
Write a Kafka Streams application that does the following transformations:
Words to upper case letters
Multiplies positive numbers by a number given on command line
Adds “negative number: “ prefix to negative numbers
Assume that there are 2 input topics: one per words and the second for the numbers.

Expected results
All result groups should go to their respective topics.
Input and output topics should be specified on the command line using scopt.
Write tests.
Don’t forget about README with proper structure
Publish to a github repo

```
### How to run
(on linux, on windows commands may be different)
1. Go to Kafka directory
2. Establish Zookeeper
`bin/zookeeper-server-start.sh config/zookeeper.properties`
3. Establish Kafka boker
`bin/kafka-server-start.sh config/server.properties`
4. Create topics for each client using (change <name> to your liking:
- `console-producer.\bin\windows\kafka-console-producer.bat --bootstrap-server localhost:9092 --create --topic <name>`
5. Run clients:
- `bin\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic input-strings`
- `bin\kafka-console-producer.bat --bootstrap-server localhost:9092 --topic Input-ints`
- `bin\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic upper`
- `bin\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic multiplies`
- `bin\kafka-console-consumer.bat --bootstrap-server localhost:9092 --topic negative`
6. Run an App:
   1. clone this repository and run `sbt run` command in project directory.
   2. clone this repository and use IDE

## Troubleshooting
- Make sure that Zookeeper and Kafka Broker are active
- Sometime errors are due tmp - clean it if it happes
- 