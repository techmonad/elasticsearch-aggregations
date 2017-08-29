curl -XPUT 'http://localhost:9200/analysis_index' -d '{
  "settings" : {
        "number_of_shards" : 8
    },
  "mappings": {
    "_default_": {
      "dynamic": "strict",
      "properties": {
        "id": {
          "type": "string"
        },
        "sentiment": {
          "type": "string"
        },
        "text": {
          "type": "string"
        },
        "user": {
          "type": "nested",
          "properties": {
            "id": {
              "type": "string"
            },
            "name": {
              "type": "string"
            },
            "followers": {
              "type": "long"
            },
            "followings": {
              "type": "long"
            },
            "language": {
              "type": "string"
            }
          }
        }
      }
    }
  }
}'