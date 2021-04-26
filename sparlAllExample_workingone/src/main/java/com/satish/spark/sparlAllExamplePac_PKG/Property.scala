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
        prop.load(new FileInputStream(new File("").getAbsolutePath()+ config_file_name + ".properties"))
      }
      
    }catch{
      case e: IOException => println("Exception + e")
    }
      
    }
    
    def getCountValue = prop.getProperty("COUNT_VALUE").toString()
    
    
   
  }
  
}