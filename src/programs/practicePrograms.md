1. convert list to set

   public class p1_convertListToSet {
   public static void main(String[] args) {
   List<Integer> list = Arrays.asList(1, 2, 2, 3, 3, 4);
   Set<Integer> s1=list.stream().collect(Collectors.toSet());
   System.out.println(s1);
   }
   }
2.  convert list to linkedHashSet to preserve the insertion order

    public static void main(String[] args) {
    List<Integer> list = Arrays.asList(3, 1, 2, 1, 3);
    Set<Integer> s1=list.stream().collect(Collectors.toCollection(()-> new LinkedHashSet<>()));
    System.out.println(s1);
    }
   basically while collectiong we dont have specific method to collect directlt to hashser
   so we used Collectors.toCollection .it will collect directly to based on provided supplier
   we are telling directly which collection need to use while collecting the elements

3. convert set into List
   public class p3_convertSetToList {

   public static void main(String[] args) {
   Set<String>set = new HashSet<>(Arrays.asList("banana", "apple", "cherry"));
   List<String> l1 = new ArrayList<>(set);
   System.out.println(l1);
   }
   }
4. convert set into SortedList
   public class p4_convertSetToSortedList {
   public static void main(String[] args) {
   Set<Integer> set = new HashSet<>(Arrays.asList(5, 3, 1, 4, 2));
   List<Integer> l1 = set.stream().sorted().collect(Collectors.toList());
   System.out.println(l1);
   }
   }
5. convert list into Map with String length
   public class p5_convertListIntoMapWithTheirLength {

   public static void main(String[] args) {
   List<String> words = Arrays.asList("apple", "banana", "kiwi");
   Map<String,Integer> m1  =words.stream().collect(Collectors.toMap(Function.identity(), String::length));
   System.out.println(m1);
   }
   }
6. convertmapintoTwoLists
   public static void main(String[] args) {
   Map<String, Integer> map1 = new HashMap<>();
   map1.put("Alice", 90);
   map1.put("Bob", 85);
   List<String> keys=map1.entrySet().stream().map(k -> k.getKey()).collect(Collectors.toList());
   List<Integer> values =map1.entrySet().stream().map(v -> v.getValue()).collect(Collectors.toList());
   System.out.println(keys);
   System.out.println(values);
   }
7. getHighFrequentElementFrom the list

   public static void main(String[] args) {
   List<String> list = Arrays.asList("a", "b", "a", "c", "a", "b");

        Optional<String> mostFreq=list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);

        System.out.println(mostFreq.get());
   }
8. GroupStringByFirstCharacterAndCount
   public static void main(String[] args) {
   List<String> words = Arrays.asList("apple","avocado","banana","blueberry","cherry");

        Map<Character, Long> res=words.stream().collect(Collectors.groupingBy(x-> x.charAt(0),Collectors.counting()));
        System.out.println(res);

   }
9. flattenAListAndSortedDistinctElements
   public static void main(String[] args) {
   List<List<Integer>> nested = Arrays.asList(
   Arrays.asList(3, 1, 2),
   Arrays.asList(5, 3, 4),
   Arrays.asList(2, 6, 1)
   );

        List<Integer> records =nested.stream().flatMap(x-> x.stream()).distinct().sorted().collect(Collectors.toList());
        System.out.println(records);
   }
10. PartitionAListIntoEvenAndOddNumber

    public static void main(String[] args) {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
    Map<Boolean,List<Integer>> res =numbers.stream().collect(Collectors.partitioningBy(x-> x%2==0));
    List<Integer> even = res.get(true);
    List<Integer> odd = res.get(false);
    System.out.println(even);
    System.out.println(odd);

    }
11.sumOfDigitsFromInt
    public static void main(String[] args) {
    int number = 12345; // how we can convert int into stream // first coonvert into String and then use chars
    Integer sum =String.valueOf(number).chars().map(x-> x-'0').sum();
    System.out.println(sum);

    }
12.  //
13. Reverse Each word in sentence
    public static void main(String[] args) {
    String sentence = "Java is awesome";
    String res=Arrays.asList(sentence.split(" ")).stream().map(x-> new StringBuilder(x).reverse().toString()).collect(Collectors.joining(" "));
    System.out.println(res);
    }
14. findDuplicateCharFrom String
    public static void main(String[] args) {
    String str = "programming";
    str.chars().mapToObj(x-> (char)x).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
    .entrySet().stream().filter(x-> x.getValue()>1).forEach(x-> System.out.println(x.getKey()));
    }
15. checkTwoStringsAreAnangrams/
    public class p15_checkTwoStrigsAreAnagrams {

    public static void main(String[] args) {
    String s1 = "listen";
    String s2 = "silent";
    List<Character> rs1=s1.chars().mapToObj(x-> (char)x).sorted().collect(Collectors.toList());
    List<Character> rs2=s2.chars().mapToObj(x-> (char)x).sorted().collect(Collectors.toList());
    System.out.println(rs1.equals(rs2));
    }
    }
16. top most frequent words in java
    public class p16_topMostFrequentWordsInJava {
    public static void main(String[] args) {
    String text = "java stream java lambda stream java amma amma";
    List<String> name= Arrays.asList(text.split(" ")).stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
    .entrySet().stream().sorted(Map.Entry.<String,Long>comparingByValue().reversed()).filter(x-> x.getValue()!=1).map(x->x.getKey()).collect(Collectors.toList());

        System.out.println(name);

    }
    }
17. filter a map using filter
    public class p17_FilterAMapUsingStreams {
    public static void main(String[] args) {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("Alice", 90);
    scores.put("Bob", 55);
    scores.put("Charlie", 80);

    Map<String,Integer> res=   scores.entrySet().stream().filter(x->x.getValue()>60).collect(Collectors.toMap(x-> x.getKey(), y->y.getValue()));
    System.out.println(res);
    }
    }
18. sort map with descending
    public class p18_sortAMapWithDescending {

    public static void main(String[] args) {
    Map<String, Integer> scores = new HashMap<>();
    scores.put("Alice", 90);
    scores.put("Bob", 55);
    scores.put("Charlie", 80);

        Map<String, Integer> res=scores.entrySet().stream().sorted(Map.Entry.<String, Integer>comparingByValue().reversed()).collect(Collectors.toMap(x-> x.getKey(), x->x.getValue(), (e1,e2)-> e2,LinkedHashMap::new));

        System.out.println(res);
    }
    }
19. mergeTwoMapsAndHandleDuplicates
    public static void main(String[] args) {
    Map<String, Integer> map1 = new HashMap<>();
    map1.put("Alice", 90);
    map1.put("Bob", 80);
    Map<String, Integer> map2 = new HashMap<>();
    map2.put("Bob", 95); // duplicate key
    map2.put("Charlie", 85);

        // first add one map into merged and another map also add into merge using foreach
        // here foreach will take bi consumer and merge option will have key value if any duplicates we have how we handled
        map2.forEach((key,value)-> map1.merge(key,value,Integer::min));
        System.out.println(map1);
    }
20. find prime numbers
    public static void main(String[] args) {
    int N= 50;
    // for example take num 14
    // IntStream.rangeClosed(2, (int) Math.sqrt(n)) with give stream of root 14 i.e 3.7 i.e 3
    // 14/2 = 0 then it is not prime number
    // for example take num 17
    // IntStream.rangeClosed(2, (int) Math.sqrt(n)) with give stream of root 14 i.e 3.7 i.e 4
    // 17/2=0 false 17/3 false 17/4 false then this is prime number
    List<Integer> res=IntStream.rangeClosed(2,N).filter(n->
    IntStream.rangeClosed(2, (int) Math.sqrt(n))
    .allMatch(i->n%i!=0)).boxed().collect(Collectors.toList());

        System.out.println(res);

    }
21. 