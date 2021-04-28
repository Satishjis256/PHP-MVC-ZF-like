package com.satish.spark.DAO_PKG
import com.satish.spark.sparlAllExamplePac_PKG.Property
import com.satish.spark.sparlAllExamplePac_PKG.sparkDriverFactory
import com.satish.spark.sparlAllExamplePac_PKG.{Property,sparkDriverFactory}
import org.apache.spark.sql.SparkSession
import org.apache.spark.sql.{DataFrame, Dataset, SparkSession}
import org.apache.spark.sql.functions._
import com.crealytics.spark.excel._
import com.fasterxml.jackson.core.exc.InputCoercionException
import org.slf4j.MDC._
import org.slf4j._

class allMethodsDAO {
  object allMethodsDAO{
    
    val spark = sparkDriverFactory.spark
    
    import spark.implicits._
    
    def reaFileFromSource(config_file_name:String,fx:String):DataFrame =  {
      
       val proObj:Property  = new Property()
       proObj.Property.load(config_file_name)
       println(proObj.Property.getCountValue)
       val source_file_path_name = proObj.Property.getSOURCE_DIRECTORY_PATH
       println("source_file_path_name " + source_file_path_name)
       val file_name = fx
       println("file_name " + file_name)
       val final_path = source_file_path_name.concat(file_name) 
       println("final_path " + final_path)
       //val file_to_rdd  = spark.read.csv(final_path)
       val file_to_rdd = spark.read.format("com.crealytics.spark.excel")
       .option("header", "true")
       .option("inferSchema", "true")
       .load(final_path)
       return file_to_rdd
    }
    
    /*
      def reaFileFromSource(config_file_name:String):DataFrame =  {
      
       val proObj:Property  = new Property()
       proObj.Property.load(config_file_name)
       println(proObj.Property.getCountValue)
       val source_file_path_name = proObj.Property.getSOURCE_DIRECTORY_PATH
       println("source_file_path_name " + source_file_path_name)
       val file_name = proObj.Property.getCUSTOMER_FILE_NAME
       println("file_name " + file_name)
       val final_path = source_file_path_name.concat(file_name) 
       println("final_path " + final_path)
       //val file_to_rdd  = spark.read.csv(final_path)
       val file_to_rdd = spark.read.format("com.crealytics.spark.excel")
       .option("header", "true")
       .option("inferSchema", "true")
       .load(final_path)
       return file_to_rdd
    }*/
  }
}