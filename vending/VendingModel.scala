
import scala.sys.process._
import modbat.dsl._


object VendingModel {
  var vending: VendingMachine = _ // Statisk instans
    def sut: VendingMachine = {
    if (vending == null) {
      vending = new VendingMachine()  // Skapa instansen om den inte existerar
      println("Creating a new VendingMachine instance.") 
    } else {
      println("Using existing VendingMachine instance.")
     
    }
    vending
  }

}
 
class VendingModel extends Model {

  var choice = 0



def runRandoop(): Unit = {
    // Förbered argumenten för Randoop
    val randoopArgs = Array(
      "gentests", 
      "--classlist=VMlist.txt",  
      "--time-limit=3", 
      "--unchecked-exception=error",
      "--progressdisplay=true",
      "--debug-checks=true"       
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



  
  "init" -> "to_pay" := {
  
    VendingModel.sut.reset()
    choice = choose(1, 6) 
    VendingModel.sut.choose(choice) 
  }

  
  "to_pay" -> "init" := {
    VendingModel.sut.cancel() 
  }

  // Testa felaktig betalning
  "to_pay" -> "fail" := {
    VendingModel.sut.pay(4) 
    // assert(vending.isWrongpay())
  } throws "IllegalArgumentException"

  //Testa korrekt betalning
  "to_pay" -> "to-dispense" := {
    VendingModel.sut.pay(VendingModel.sut.exAmount()) 
    assert(VendingModel.sut.paymade()) 
    
 }

  "to_pay" -> "randoop" := {runRandoop()}

  // Dispensera varan vid lyckad betalning
  "to-dispense" -> "ok" := {
    VendingModel.sut.dispense() 
    assert(VendingModel.sut.isOk())
   
  }


  // "to-dispense" -> "fail2" := {
  //   vending.dispense() 
  //   assert(vending.isHardError()) 
  // }
}


