/*
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpecLike

class KafkaAppSpec extends AnyWordSpecLike with Matchers{


  import org.apache.kafka.common.serialization.{StringDeserializer, StringSerializer}
  import org.apache.kafka.streams.TopologyTestDriver

    private[this] val topologyTestDriver: TopologyTestDriver =
      new TopologyTestDriver(KafkaApp.topology, KafkaApp.properties)

    "ToUpperCase" should {

      "verify topology" in {
        val value         = "mY lower CAse valuE"
        val expectedValue = "MY LOWER CASE VALUE"

        val consumerRecordFactory = new ConsumerRecordFactory[String, String](
          KafkaApp.IN_TOPIC,
          new StringSerializer,
          new StringSerializer
        )
        topologyTestDriver.pipeInput(consumerRecordFactory.create(value))
        val producerRecord = topologyTestDriver.readOutput(
          KafkaApp.OUT_TOPIC,
          new StringDeserializer,
          new StringDeserializer
        )

        producerRecord.key() shouldBe null
        producerRecord.value() shouldBe expectedValue
      }
    }

  }
}
*/
