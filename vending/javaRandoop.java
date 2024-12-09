public class javaRandoop {

    public void runRandoop() {
        String[] randoopArgs = {
                "gentests",
                "--classlist=VMlist.txt",
                "--time-limit=3"
        };

        try {
            randoop.main.Main.main(randoopArgs);
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
