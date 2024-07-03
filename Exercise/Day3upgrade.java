package Exercise;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
//Determine your age and print if you are an adult
//Aks user for name and then date of birth
public class Day3upgrade {

    private int age;
    private String name;
    private boolean isAdult;
    private LocalDate dateOfBirth; //the value 2nd October 2007 can be stored in a LocalDate object

    public Day3upgrade(String name, LocalDate dateOfBirth) {
        this.age = age;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        updateAgeAndisAdult(); //Calculate age and isAdult status
    }

    private void updateAgeAndisAdult() { //calculate age and isAdult
        LocalDate currentDate = LocalDate.now();
        this.age = Period.between(dateOfBirth, currentDate).getYears();
        this.isAdult = this.age >= 18;
    }

    //Getter
    public int getAge() {
        return age;
    }
    //Getter
    public String getName() {
        return name;
    }
    //Getter isAdult
    public boolean getIsAdult() {
        return isAdult;
    }
    public void print() {
        System.out.println("Your name is " + name + " and you are " + age + " years old.");
        if (isAdult) { //true
            System.out.println("You are an adult.");
        }
        else {
            System.out.println("You are not an adult.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        try {
            System.out.println("Type your name:");
            String userName = scanner.nextLine();
            System.out.println("Type your date of birth (dd/mm/yyyy):");
            String userDateOfBirth = scanner.nextLine();

            LocalDate parseDate = LocalDate.parse(userDateOfBirth, formatter); //the String has to be parsed otherwise it will throw an exception
            Day3upgrade person = new Day3upgrade(userName, parseDate);         //Text '01/03/2001' could not be parsed at index 0
            person.print();
            scanner.close();
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

    }
    
}
