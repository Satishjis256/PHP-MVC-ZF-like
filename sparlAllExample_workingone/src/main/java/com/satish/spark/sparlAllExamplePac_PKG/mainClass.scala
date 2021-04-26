

package com.satish.spark.sparlAllExamplePac_PKG

object mainClass {
  
  def main(args:Array[String])
  {
    //Calling sparkfactory object  
    if(args.length == 0)
    {
      println("Please provide at least one arguments")
    }
    
    val config_file_name = args(0)
    println(" Value of config_file_name is : " +  config_file_name)
    val spark = sparkDriverFactory.spark
    println("Going to stop spark")
    println("Print the value of property COUNT_VALUE")
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
     val proObj:Property  = new Property()
     proObj.Property.load(config_file_name)
     println(proObj.Property.getCountValue)
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
    spark.stop()
   
  }
  
}