package Lectures;
public class Lecture1 {
    //By making Bytecode a static nested class, 
    //you can instantiate it directly using new Bytecode()
    public  static class Bytecode { //Stack=2, Heap=1, Locals=3, Args_size=2
        public int plus (int a){    //0:  iconst_1
        int b = 1;                  //1:  istore_2
        return a + b;               //2:  iload_1 + iload_2 + iadd
        }                           //3:  ireturn
    }
    //By making Bytecode1 a non-static nested class, you need an outer class (Lecture 1) 
    //to create an instance to instantiate it 
    public class Bytecode1 {    
        public int plus (int a){
        int b = 2;
        return a + b;
        }
        
    }
    //Main method
    public static void main(String[] args) {
        System.out.println("Bytecode interpretation:");
        System.out.println("plus(1) = " + new Bytecode().plus(1));
        System.out.println("plus(2) = " + new Lecture1().new Bytecode1().plus(2));
    }
}
// 📌 Lecture 1 📝 🗑️
