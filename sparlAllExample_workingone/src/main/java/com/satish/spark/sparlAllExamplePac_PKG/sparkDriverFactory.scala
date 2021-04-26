package com.satish.spark.sparlAllExamplePac_PKG

import org.apache.spark.sql.SparkSession

object sparkDriverFactory {
  
  
  
    
    //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
    println("*****************************************************************************")
    val spark = SparkSession.builder().appName("my_app").master("local[*]").getOrCreate()
  
   
  
  
  
  
  
}