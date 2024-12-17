
object Testrandoo {

 
  def runRandoop(): Unit = {
   
    val randoopArgs = Array(
     "gentests",
                "--classlist=VMlist.txt",
                "--time-limit=3",
                "--unchecked-exception=error",
                "--progressdisplay=true",
                "--progressintervalmillis=60000",
                "--progressintervalsteps=1000",
                "--debug-checks=true",
                "--log=randoop-debugScala.log",
                "--selection-log=selectionScala.log",
                "--operation-history-log=operation-historyScala.log",
                "--print-non-compiling-file=true"  
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