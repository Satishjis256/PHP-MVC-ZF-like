package com.satish.spark.Data_Reader_PKG
import com.satish.spark.sparlAllExamplePac_PKG
import com.satish.spark.DAO_PKG.allMethodsDAO
import com.satish.spark.sparlAllExamplePac_PKG.mainClass._
import java.io.IOException
import org.apache.spark.sql.DataFrame

class DataReadeFactory extends App{
  object DataReadeFactory {
    
     try{
       
       //&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
       // Reading all source files from source directory
       //|-------------------------------------Customer---------------------------------------------------------|
        val objallMethodsDAO:allMethodsDAO = new allMethodsDAO()
        //val config_file_name = sparlAllExamplePac_PKG.mainClass.commandLineParameters
        val config_file_name = args(0)
        /*def methodCustomer():DataFrame = {
          
        val customer_df = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name)
        customer_df
        }*/
    }catch{
      case e: IOException => println("Exception + e")
    }
    
     
    
  }
}