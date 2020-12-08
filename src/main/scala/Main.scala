
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.api.windowing.time.Time

object Main {

  def main(args: Array[String]): Unit = {
    val env: StreamExecutionEnvironment = StreamExecutionEnvironment.getExecutionEnvironment
    env.setParallelism(1)
    val input = MyFlinkKinesisConsumer.createKinesisSourceFrom(env)

    val counts = input.flatMap { _.toLowerCase.split("\\W+") filter { _.nonEmpty } }
      .map { (_, 1) }
      .keyBy(_._1)
      .timeWindow(Time.seconds(5))
      .sum(1)
    counts.print()

    env.execute("run extractor example")
  }

}
