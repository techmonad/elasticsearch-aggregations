package com.techmonad.config

import java.net.InetAddress

import com.typesafe.config.{Config, ConfigFactory}
import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress

import scala.collection.JavaConverters._

trait ESConfig {

  private val config: Config = ConfigFactory.load()

  private val esConfig = config.getConfig("es")
  private val nodes = esConfig.getStringList("nodes")
  private val port = esConfig.getInt("port")
  private val hosts = nodes.asScala.map { host => new InetSocketTransportAddress(InetAddress.getByName(host), port) }
  private val settings = Settings.settingsBuilder().build()

  lazy protected val client: Client = TransportClient.builder().settings(settings).build().addTransportAddresses(hosts: _*)

  protected val indexName: String = esConfig.getString("index")

}