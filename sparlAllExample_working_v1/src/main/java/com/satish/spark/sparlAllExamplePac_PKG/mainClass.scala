

package com.satish.spark.sparlAllExamplePac_PKG
import com.satish.spark.Data_Reader_PKG.DataReadeFactory
import com.satish.spark.DAO_PKG.allMethodsDAO
import com.satish.spark.sparlAllExamplePac_PKG._
import org.apache.spark.sql.types.IntegerType
import org.apache.spark.sql.functions._

object mainClass  {
  
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
    
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
    val proObj:Property  = new Property()
    proObj.Property.load(config_file_name)
    println(proObj.Property.getCountValue)
    println("%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%")
    
    
    /* Here calling methoid  reaFileFromSource and passing config_file_name and method of property class whihc is used to
    *  these confige parametr value for different files , In this example i have used  function with function as parameters
    *  */
    //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    val objallMethodsDAO:allMethodsDAO = new allMethodsDAO()
    //Loading customer data into a dataframe
    val customer_df = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getCUSTOMER_FILE_NAME)
    customer_df.show()
    customer_df.printSchema()
    
    //Loading Employees data into a dataframe
    val employee_df = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getEMPLOYEES_FILE_NAME)
    employee_df.show()
    employee_df.printSchema()
    
    
    
    //Loading Categories data into a dataframe
    val categories_df = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getCATEGORIES_FILE_NAME)
    categories_df.show()
    categories_df.printSchema()
    
    //Loading Order data into a dataframe
    val Order_df = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getORDERS__FILE_NAM)
    Order_df.show()
    Order_df.printSchema()
    
    //Loading Order Details  data into a dataframe
    val OrderDetails_df  = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getORDERDETAILS__FILE_NAM)
    OrderDetails_df.show()
    OrderDetails_df.printSchema()
    
  
    
     //Loading Product Details  data into a dataframe
    val Products_df  = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getPRODUCT__FILE_NAM)
    Products_df.show()
    Products_df.printSchema()
    
     //Loading Shippers Details  data into a dataframe
    val Shippers_df  = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getSHIPPER__FILE_NAM)
    Shippers_df.show()
    Shippers_df.printSchema()
    
    //Loading Supplier  Details  data into a dataframe
    val Suplliers_df_tmp  = objallMethodsDAO.allMethodsDAO.reaFileFromSource(config_file_name , proObj.Property.getSUPLLIERS__FILE_NAM)
    Suplliers_df_tmp.show()
    Suplliers_df_tmp.printSchema()
    
    // Changing Data Type from Diuble to Integer into dataframe
    val Suplliers_df = Suplliers_df_tmp.withColumn("SupplierIDTmp", col("SupplierID").cast(IntegerType))
    .drop("SupplierID")
    .withColumnRenamed("SupplierIDTmp", "SupplierID")
    Suplliers_df.show()
    Suplliers_df.printSchema()
    
    /*
    *customer_df
    *employee_df 
    *categories_df
    *Order_df
    *OrderDetails_df
    *Products_df
    *Shippers_df
     * 
     * */
    // Select all orders with customer and shipper information
    
    Order_df.join(customer_df ,Order_df("CustomerID") ===customer_df("CustomerID") ).show()
    
    
    spark.stop()
   
  }
  
  /*
  def commandLineParameters:String = {
    val config_file_name1 = args(0)
    return config_file_name1
  }*/
  
}