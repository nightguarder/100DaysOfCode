package Exercise;
import java.util.Scanner;

public class Day3 {

    private int age;
    private String name;

    public Day3(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public void print() {
        System.out.println("Your name is " + name + " and you are " + age + " years old.");
    }
    //Getter
    public int getAge() {
        return age;
    }
    //Getter
    public String getName() {
        return name;
    }

    public static void main(String[] args) {

        //Number Scanner
        Scanner scanner = new Scanner(System.in);
 
        System.out.println("Type your name:");
        String userName = scanner.nextLine();
        System.out.println("Type your age:");
        int userAge = scanner.nextInt();

        Day3 person = new Day3(userAge, userName);
        person.print();
        scanner.close();
    }
        
    
}
