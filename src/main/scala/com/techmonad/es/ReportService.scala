package com.techmonad.es

import com.techmonad.config.ESConfig
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.aggregations.AggregationBuilders
import org.elasticsearch.search.aggregations.bucket.nested.Nested
import org.elasticsearch.search.aggregations.bucket.terms.Terms
import org.elasticsearch.search.sort.{FieldSortBuilder, SortOrder}
import scala.collection.JavaConverters._

trait ReportService {
  this: ESConfig =>


  def getTopUsers(count: Int): List[String] = {
    val query = QueryBuilders.matchAllQuery()
    val sort = (new FieldSortBuilder("user.followers")).setNestedPath("user").order(SortOrder.DESC)
    val agg = AggregationBuilders
        .nested("all_users")
        .path("user")
        .subAggregation(
          AggregationBuilders.terms("group_by_user_id").field("user.id").size(count).order(Terms.Order.aggregation("user_sort_by_followers", false))
            .subAggregation(
              AggregationBuilders.max("user_sort_by_followers").field("user.followers")
            )
        )
    val response = client.prepareSearch(indexName).setSearchType("count").setQuery(query).addAggregation(agg).addSort(sort).execute().actionGet()
  response.getAggregations.get[Nested]("all_users").getAggregations.get[Terms]("group_by_user_id").getBuckets.asScala
      .map{user => user.getKeyAsString }.toList
  }


}

object ReportService extends ReportService with ESConfig