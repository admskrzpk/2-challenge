import org.apache.kafka.streams.{KafkaStreams, StreamsConfig}

import java.util.Properties

object KafkaApp {
  def main(args: Array[String]): Unit = {

    import org.apache.kafka.streams.scala._
    import ImplicitConversions._
    import serialization.Serdes._

    val topicInputStrings = args(1)
    val topicInputInts = (args(2))
    val topicUpper = args(3)
    val topicMultiplies = args(4)
    val topicNegative = args(5)
    val multiplier = 5

    val properties = new Properties()
    properties.put(StreamsConfig.APPLICATION_ID_CONFIG, "scala-exam-adam")
    val bootstrapServers = if (args.length > 0) args(0) else "localhost:9092"
    properties.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)

    val builder = new StreamsBuilder()
    builder
      .stream[String, String](topicInputStrings)
      .flatMapValues(textLine => textLine.toUpperCase.split("\\W+"))
      .to(topicUpper)

    val builder2 = new StreamsBuilder()
    builder
      .stream[String, String](topicInputInts)
      .filter((_, v) => v.toInt >= 0).mapValues(_ (1) * multiplier).to(topicMultiplies)

    val builder3 = new StreamsBuilder()
    builder
      .stream[String, String](topicInputInts)
      .filter((_, v) => v.toInt < 0).mapValues(v => s"negative number $v").to(topicNegative)

    val streams: KafkaStreams = new KafkaStreams(builder.build(), properties)
    streams.start()
  }
}