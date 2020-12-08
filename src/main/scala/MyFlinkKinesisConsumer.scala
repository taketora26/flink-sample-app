
import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.kinesis.FlinkKinesisConsumer
import org.apache.flink.streaming.connectors.kinesis.config.{AWSConfigConstants, ConsumerConfigConstants}

object MyFlinkKinesisConsumer {

  def createKinesisSourceFrom(env: StreamExecutionEnvironment): DataStream[String] = {
    val consumerConfig = new Properties()
    consumerConfig.put(AWSConfigConstants.AWS_REGION, Config.awsCredential.region)
    consumerConfig.put(AWSConfigConstants.AWS_ACCESS_KEY_ID, Config.awsCredential.accessKeyId)
    consumerConfig.put(AWSConfigConstants.AWS_SECRET_ACCESS_KEY, Config.awsCredential.secretAccessKey)
    consumerConfig.put(ConsumerConfigConstants.STREAM_INITIAL_POSITION, "LATEST")

    env.addSource(new FlinkKinesisConsumer[String](Config.kinesis.streamName, new SimpleStringSchema, consumerConfig))
  }
}
