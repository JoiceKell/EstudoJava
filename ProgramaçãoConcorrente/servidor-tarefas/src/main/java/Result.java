public class Result {
    public static void fizzBuzz(int n) {
        int i;
        for (i=1; i<=n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("FizzBuzz");
            else if ((i % 3 == 0) && !(i % 5 == 0)) {
                System.out.println("Fizz");
            } else if ((i % 5 == 0) && !(i % 3 == 0)) {
                System.out.println("Buzz");
            } else {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        Result.fizzBuzz(15);
    }
}
