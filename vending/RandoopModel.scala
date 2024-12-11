import modbat.dsl._


class RandoopModel extends Model {

def runRandoop(): Unit = {
    val randoopArgs = Array(
      "gentests", 
      "--classlist=VMlist.txt",  
      "--time-limit=3", 
      "--unchecked-exception=error"       
    )

   try {

      println("Running randoop ")
      //randoop.main.Main.main(randoopArgs)
      val mainInstance = new randoop.main.Main()
      mainInstance.nonStaticMain(randoopArgs)
      println("Randoop finished successfully???")
    } catch {
      case e: Exception =>
        println(s"Error invoking Randoop: ${e.getMessage}")
        e.printStackTrace()
    }
  }

  "init" -> "randoop" := {runRandoop()}

}