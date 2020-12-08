name := "flink-sample-app"

version := "0.1"

scalaVersion := "2.12.12"

val flinkVersion = "1.11.2"

val flinkDependencies = Seq(
  "org.apache.flink" %% "flink-scala"             % flinkVersion,
  "org.apache.flink" %% "flink-streaming-scala"   % flinkVersion,
  "org.apache.flink" %% "flink-connector-kinesis" % flinkVersion,
  "org.apache.flink" %% "flink-clients"           % flinkVersion,
  "org.apache.flink" %% "flink-runtime-web"       % flinkVersion,
  "ch.qos.logback"   % "logback-classic"          % "1.2.3"
)

libraryDependencies ++= flinkDependencies
