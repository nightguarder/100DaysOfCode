package Lectures;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MemLeakSolution {
    public final String key;
    //Define a method to put the key into a Map
    public MemLeakSolution(String key) {
        this.key = key;
    }

    //Define a method to remove the key from the Map
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        //logical equality comparison based on the key value.
        if (o == null || getClass() != o.getClass()) return false;

        MemLeakSolution that = (MemLeakSolution) o; //MemLeak solution instance

        return Objects.equals(key, that.key);
    }
    //Define a method to check if the key is in the Map
    @Override
    public int hashCode() { //Returns the hash code value for the key
        return Objects.hash(key);
    }

    //*This way the HashMap retains a single entry of key and value, preventing memory leaks */
    //*The GC can now effectively collect and reclaim memory from unused MemLeakSolution instances.
    public static void main(String[] args) {
        try {
            Map<Object, Object> map = new HashMap<>();
            int i = 0;

            for (; i< Integer.MAX_VALUE; i++) { //Run until INT 2147483647 overflows
                map.put(new MemLeakSolution("key"), "value");
                // Print progress every 1000000 iterations
                if (i % 1000000 == 0) {
                    System.out.println("Added " + i + " elements to the map");
                }
                //Added 2147000000 elements to the map
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}
