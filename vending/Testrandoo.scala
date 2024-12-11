
object Testrandoo {

 
  def runRandoop(): Unit = {
   
    val randoopArgs = Array(
      "gentests", 
      "--testclass=VendingMachine",  
      "--time-limit=3",
     "--no-error-revealing-tests=false", 
     "--no-regression-tests=false",
      "--unchecked-exception=error"   
    )

   try {
    //randoop.main.Main.main(randoopArgs)
    
      val mainInstance = new randoop.main.Main()
      mainInstance.nonStaticMain(randoopArgs)
      
    println("Randoop finished successfully???")
  } catch {
    case e: Exception =>
      println(s"Error invoking Randoop: ${e.getMessage}")
      e.printStackTrace()
  } finally {
    println("Finishing Randoop execution.")
  }
  }

  
  def main(args: Array[String]): Unit = {
    println("call runRandoop")
    runRandoop()
  }
}