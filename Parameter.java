public class Parameter{

    // Parameterized method
    static void add(int a, int b) {
        int sum = a + b;
        System.out.println("Sum = " + sum);
    }

    public static void main(String[] args) {

        // Passing arguments
        add(10, 20);
        add(50, 30);
    }
}