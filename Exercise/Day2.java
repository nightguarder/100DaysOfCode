package Exercise;

public class Day2 {
    //Declare a variable
    int a;
    double d;
    String s;
    
    //Declare a method
    public int add(int a) {
        int b = 1;
        return a + b;
    }
    public double add(double a) {
        double b = 1.0;
        return a + b;
    }
    public String add(String a) {
        String b = "1";
        return a + b;
    }
    public static void main(String[] args) {
        System.out.println("3 types of addition:");
        System.out.println("add(1)  Integer = " + new Day2().add(1));
        System.out.println("add(1.0) Double = " + new Day2().add(1.0));
        System.out.println("add(\"1\") String = " + new Day2().add("1"));
    }
}

// 📌 Exercise 📝 🗑️
