/**
 * 
 * Lesson4
 * 
 * Hashing (Frequency Counting)
 * Hashing allows us to store and retrieve data in nearly constant time, making many problems much faster.
 * 
 * HashMap in Java
 * The most commonly used hashing structure is: HashMap<Key, Value>
 * 
 * map.put(num, map.getOrDefault(num,0)+1);
 * 
 * Understanding getOrDefault()
 * 
 * The getOrDefault(Object key, V defaultValue) method in Java belongs to the Map interface and retrieves the value mapped to a specified key, or returns a fallback default value if the key does not exist. 
 * 
 * Character Hashing
 * 
 * Interview Insight

Whenever you hear:
    "Count frequency"
    "Occurrences"
    "Duplicates"
    "Repeated values"
    "Unique elements"

first thought should be: Can I solve this efficiently using a HashMap or a frequency array?

In many cases, hashing reduces an O(n²) solution to O(n).

 */
import java.util.HashMap;
public class Lesson4 {

    //basic frequency counter
    public static void freqCounter(int[] arr){

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : arr){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        System.out.println(map);
    }

    //character frequency counter
    public static void charFreqCounter(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        // s.toCharArray() use this for forEach loop
        for (int i = 0; i < s.length(); i++) { 
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0)+1);
        }

        System.out.println(map);

        //without hash map
        /* 
        String s = "banana";

        int[] hash = new int[26];

        for(char ch : s.toCharArray()){

            hash[ch-'a']++;

        }
        */
    }

    //most frequent elemet
    public static void mostFrequent(int[] arr){
        
        HashMap<Integer, Integer> map = new HashMap<>();

        int maxFreq = 0;
        int answer = -1;

        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (int key : map.keySet()) {
            
            if(map.get(key)>maxFreq){
                maxFreq = map.get(key);
                answer = key;
            }
        }

        System.out.println(answer);

    }

    //Highest and Lowest Frequency Character
    public static void highestAndLowestFrequencyCounter(String s){
        //map
        //track max and min

        HashMap<Character, Integer> map = new HashMap<>();

        int maxFreq = Integer.MIN_VALUE;
        int minFreq = Integer.MAX_VALUE;

        char mostFreq = ' ';
        char leastFreq = ' ';

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (char key : map.keySet()) {
            
            if (map.get(key) > maxFreq) {
                maxFreq = map.get(key);
                mostFreq = key;
            }

            if (map.get(key) < minFreq) {
                minFreq = map.get(key);
                leastFreq = key;
            }
        }

        System.out.println(mostFreq + " == " + leastFreq);

    }

    //check anagram
    public static void isAnagram(String s1, String s2){
        
        //if a string is anagram then length is always equal
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        boolean flag = true;

        for (char ch : s1.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0)+1);
        }
        
        for (char ch : s2.toCharArray()) {
            map2.put(ch, map2.getOrDefault(ch, 0)+1);
        }

        for(char key : map1.keySet()){
            if(map1.get(key) != map2.get(key)){
                flag = false;
            }
        }
        
        if (flag) {
            System.out.println("Given string "+ s1 +" and "+ s2 +" is anagram.");
        }
    }

    // Find the first non-repeating character in a string.
    public static void nonRepeatFirst(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        char ans = ' ';

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                ans = s.charAt(i);
                break;
            }
        }

        System.out.println(ans);
    }

        // Find the first non-repeating character in a string.
    public static void repeatFirst(String s){

        HashMap<Character, Integer> map = new HashMap<>();

        char ans = ' ';

        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) != 1) {
                ans = s.charAt(i);
                break;
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        
        int[] arr = {2,5,2,8,5,6,2};

        freqCounter(arr);
        charFreqCounter("helloworld");
        mostFrequent(arr);
        highestAndLowestFrequencyCounter("abbcccdddd");
        isAnagram("look", "olok");
        nonRepeatFirst("abbcccdddd");
        nonRepeatFirst("helloworld");
        nonRepeatFirst("impractical");

        System.out.println("=========");

        repeatFirst("abbcccdddd");
        repeatFirst("helloworld");
        repeatFirst("impractical");
    }
}
