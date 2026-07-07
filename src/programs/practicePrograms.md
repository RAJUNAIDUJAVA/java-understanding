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
11. 