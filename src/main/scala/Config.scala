
import com.typesafe.config.ConfigFactory

object Config {

  case class KinesisConsumerConfig(streamName: String, streamInitialPosition: String, checkPointInterval: Long)
  case class AwsCredential(region: String, accessKeyId: String, secretAccessKey: String)

  private val config = ConfigFactory.load()

  lazy val kinesis = KinesisConsumerConfig(
    streamName = config.getString("kinesis.stream_name"),
    streamInitialPosition = "LATEST", // 最新のレコードから始まるすべてのストリームのすべてのシャードを読み取り
    checkPointInterval = 5000
  )

  lazy val awsCredential = AwsCredential(
    region = "ap-northeast-1",
    accessKeyId = config.getString("aws.credentials.access_key_id"),
    secretAccessKey = config.getString("aws.credentials.secret_access_key")
  )

}
