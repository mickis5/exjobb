
object Testrandoo {

 
  def runRandoop(): Unit = {
   
    val randoopArgs = Array(
      "gentests", 
      "--classlist=VMlist.txt",  
      "--time-limit=3",
      "--no-error-revealing-tests=false", 
      "--no-regression-tests=false"
    )

   try {
    randoop.main.Main.main(randoopArgs)
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