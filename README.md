これはFlinkを使ったサンプルコードです。

[Apache Flinkを使いKinesisストリームデータを処理する](https://zenn.dev/taketora/articles/bb0c2b6e963c37)


## 必要な環境変数

- AWS_ACCESS_KEY_ID
  - AWSのアクセスキー
- AWS_SECRET_ACCESS_KEY
  - AWSのシークレットキー
- KINESIS_STREAM_NAME
  - Kinesisのストリーム名

### 起動

```shell script
% sbt run
```

### 動作確認

```shell script
# streamを作成
% aws kinesis create-stream --stream-name sample-stream --shard-count 1

# データレコードをストリームに配置
% aws kinesis put-record --stream-name sample-stream --partition-key 001 --data 'this is sample'

# クリーンアップ
% aws kinesis delete-stream --stream-name sample-stream
```
