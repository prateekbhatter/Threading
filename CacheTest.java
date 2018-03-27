package collection;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Random;
public class CacheTest {
	
	private static long lookups;
	
	private static long hits;
	
	private static RandomAccessFile in;
	


	public static void main(String[] args) {
		LRUCache<String, String> sCache = new LRUCache<String, String>(5);
		System.out.println("===========================================");
		System.out.println("START  : LRUCache <String, String> : Size 5");
		System.out.println("===========================================");
		System.out.println();
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=1;V=One)");
		sCache.put("1", "One");
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=2;V=Two)");
		sCache.put("2", "Two");
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=3;V=Three)");
		sCache.put("3", "Three");
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=4;V=Four)");
		sCache.put("4", "Four");
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=5;V=Five)");
		sCache.put("5", "Five");
		System.out.println(sCache);
		System.out.println();
		System.out.println("INSERT  : (K=6;V=Six) [evicts least recently used (K=1;V=One)]");
		sCache.put("6", "Six");
		System.out.println(sCache);
		System.out.println();
		System.out.println("UPDATE  : (K=4;V=4)");
		sCache.put("4", "4");
		System.out.println(sCache);
		System.out.println();
		System.out.println("===========================================");
		System.out.println("END    : LRUCache <String, String> : Size 5");
		System.out.println("===========================================");

		System.out.println();
		System.out.println();
		// Wrapper class Integer implements Comparable<Integer>
		LRUCache<Integer, String> iCache = new LRUCache<Integer, String>(10);
		// Wrapper class Double implements Comparable<Double>
		LRUCache<Double, String> dCache = new LRUCache<Double, String>(10);

		System.out.println();
		// Student implements Comparable<Student>
		LRUCache<Student, String> stCache = new LRUCache<Student, String>(5);
		System.out.println("===========================================");
		System.out.println("START  : LRUCache <Student, String> : Size 5");
		System.out.println("===========================================");
		System.out.println();
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=Pari];V=1)");
		stCache.put(new Student("pari"), "1");
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=Aisha];V=2)");
		stCache.put(new Student("Aisha"), "2");
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=phulan];V=3)");
		stCache.put(new Student("phulan"), "3");
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=Jackson];V=4)");
		stCache.put(new Student("jackson"), "4");
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=Rose];V=5)");
		stCache.put(new Student("Rose"), "5");
		System.out.println(stCache);
		System.out.println();
		System.out.println("INSERT  : (K=Student[name=Pinda];V=6) [evicts least recently used (K=Student[name=Mary];V=1)]");
		stCache.put(new Student("pinda"), "6");
		System.out.println(stCache);
		System.out.println();
		System.out.println("UPDATE  : (K=Student[name=Jackson];V=FOUR)");
		stCache.put(new Student("Jackson"), "FOUR");
		System.out.println(stCache);
		System.out.println();
		System.out.println("===========================================");
		System.out.println("END    : LRUCache <Student, String> : Size 5");
		System.out.println("===========================================");


		// LRUCache expects its object's key and value to be comparable.
		// Generics checks whether the parameter type implements Comparable at compile-time
		// Hence below doesn't compile
		// LRUCache<Person, String> pCache = new LRUCache<Person, String>();
	}
}

