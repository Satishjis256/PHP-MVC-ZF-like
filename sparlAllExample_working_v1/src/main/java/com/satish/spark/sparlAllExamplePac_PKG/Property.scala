package com.satish.spark.sparlAllExamplePac_PKG
import java.io.File
import java.io.FileInputStream
import java.util.Properties
import java.io.IOException
import java.time.Instant
import java.nio.file.Files
import java.nio.file.Paths

class Property {
  object Property{
    
    val prop:Properties = new Properties()
    
    def load(config_file_name:String){      
    try{
      val file = new File("").getAbsolutePath() + "/src/main/resources/" + config_file_name + ".properties"
      
      if(Files.exists(Paths.get(file))){
        println("If ----------------prop load")
        prop.load(new FileInputStream(file))
      }else{
        println("else --------------prop load")
        println("Absolute path")
        println(new File("").getAbsolutePath()+ "\\" + config_file_name + ".properties")
        
        println("Property file path")
        println(new FileInputStream(new File("").getAbsolutePath()+ "\\" + config_file_name + ".properties"))
        
       
        
        prop.load(new FileInputStream(new File("").getAbsolutePath()+ "\\"+  config_file_name + ".properties"))
        println("Property file path")
        println(new FileInputStream(new File("").getAbsolutePath()+ "\\" +config_file_name + ".properties"))
      }
      
    }catch{
      case e: IOException => println("Exception + e")
    }
      
    }
    
    def getCountValue = prop.getProperty("COUNT_VALUE").toString()
    def getSOURCE_DIRECTORY_PATH = prop.getProperty("SOURCE_DIRECTORY_PATH").toString()
    def getCUSTOMER_FILE_NAME = prop.getProperty("CUSTOMER_FILE_NAME").toString()
    def getEMPLOYEES_FILE_NAME = prop.getProperty("EMPLOYEES_FILE_NAME").toString()
    def getCATEGORIES_FILE_NAME = prop.getProperty("CATEGORIES_FILE_NAM").toString()
    def getORDERDETAILS__FILE_NAM = prop.getProperty("ORDERDETAILS__FILE_NAM").toString()
    def getORDERS__FILE_NAM = prop.getProperty("ORDERS__FILE_NAM").toString()
    def getPRODUCT__FILE_NAM = prop.getProperty("PRODUCT__FILE_NAM").toString()
    def getSHIPPER__FILE_NAM = prop.getProperty("SHIPPER__FILE_NAM").toString()
    def getSUPLLIERS__FILE_NAM = prop.getProperty("SUPLLIERS__FILE_NAM").toString()
    
    

    
    
  }
  
}