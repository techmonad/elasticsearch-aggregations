# elasticsearch-aggregations
  This is sbt project which explain how to write elasticsearch aggregation query with sorting using java client.



### Elasticsearch Setup
  i) [Download](https://download.elastic.co/elasticsearch/release/org/elasticsearch/distribution/zip/elasticsearch/2.4.4/elasticsearch-2.4.4.zip) the Elasticsearch 2.4.4 or latest version  and unzip it.

  ii) Run the following command

        $ bin/elasticsearch
        

### Getting Started:
 Clone and run  app:
  ```
  $ git clone git@github.com:techmonad/elasticsearch-aggregations.git
  $ cd elasticsearch-aggregations/src/main/resources
  $ sh create_index.sh
  $ sh insert.sh
  $ cd ../../../
  $ sbt run
  ```
