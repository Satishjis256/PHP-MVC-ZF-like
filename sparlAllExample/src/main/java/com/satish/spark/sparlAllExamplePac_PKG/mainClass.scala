

package com.satish.spark.sparlAllExamplePac_PKG

object mainClass {
  
  def main(args:Array[String])
  {
    //Calling sparkfactory object    
    val spark = sparkDriverFactory.spark
    println("Going to stop spark")
    spark.stop()
   
  }
  
}