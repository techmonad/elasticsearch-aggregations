package com.techmonad.app

import com.techmonad.es.ReportService


object Demo extends App {

  val response = ReportService.getTopUsers(10)

  println(response)

}

/**
  *
  * 1433195173 --18
  * 1433195186 --16
  * 1433195179 --15
  * 1433195178 --14
  * 1433195177 --13
  * 1433195176 --12
  * 1433195175 --11
  * 1433195174 --10
  * 1433195184 --8
  * 1433195183 --7
  */
