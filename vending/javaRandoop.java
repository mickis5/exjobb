public class javaRandoop {

    public void runRandoop() {
        String[] randoopArgs = {
                "gentests",
                "--classlist=VMlist.txt",
                "--time-limit=1",
                "--unchecked-exception=error",
                "--progressdisplay=true",

                // "--debug-checks=true",
                "--log=randoop-debug.log",
                "--selection-log=selection.log",
                "--operation-history-log=operation-history.log",
                "--print-non-compiling-file=true",
                "--randomseed=12345"

        };

        try {
            // randoop.main.Main.main(randoopArgs);
            randoop.main.Main main = new randoop.main.Main();
            main.nonStaticMain(randoopArgs);
            System.out.println("Randoop finished successfully???");
        } catch (Exception e) {
            System.err.println("Error invoking Randoop: " + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("Finishing Randoop execution.");
        }
    }

    public static void main(String[] args) {
        javaRandoop jr = new javaRandoop();
        jr.runRandoop();
    }
}
