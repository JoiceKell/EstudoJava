public class Split {
    public static void main(String[] args) {
        String path = "/produto/1";
        String[] subPaths = path.replaceFirst("/", "").split("/");

        int i = 1;
        for(String print : subPaths) {
            System.out.println(i + ":" + print);
            i++;
        }

    }
}
