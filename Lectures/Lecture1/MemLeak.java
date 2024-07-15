package Lectures.Lecture1;
import java.util.HashMap;
import java.util.Map;
//https://www.toptal.com/java/hunting-memory-leaks-in-java#memleak

public class MemLeak {
    public final String key;

    //Define a method to put the key into a Map
    public MemLeak(String key) {
        this.key = key;
    }
    //*Don't define a method for equals() and hashCode()
    //*Limit your JVM heap size to 128MB with:
    // java -Xmx128m MemLeak
    public static void main(String[] args) {
        try {
            Map<Object, Object> map = new HashMap<>();
            int i = 0;
            //*Note: the memory leak is not due to the infinite loop on line 14: 
            //*the infinite loop can lead to a resource exhaustion, but not a memory leak. */
            //*The memory leak is due to not correctly implementing the MemoryLeak class.
            for (;; i++) {
                map.put(new MemLeak("key" + i), "value");
                // Print progress every 500000 iterations
                if (i % 500000 == 0) {
                    System.out.println("Added " + i + " elements to the map");
                }
            }
        } catch(Exception e) {
            System.out.println("Memory leak detected!");
            e.printStackTrace();
            //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
            //at java.base/jdk.internal.misc.Unsafe.allocateUninitializedArray(Unsafe.java:1380)
            //at java.base/java.lang.StringConcatHelper.newArray(StringConcatHelper.java:511)
        }
        
    }
}
