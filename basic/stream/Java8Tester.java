import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Java8Tester {
    public static void main(String[] args) {
        System.out.println("使用Java8");
        List<String> strings = Arrays.asList("abc","","bc","efg","abcd","","jkl");
        System.out.println("List: "+ strings);

        long count = strings.stream().filter(string -> string.isEmpty()).count();
        System.out.println("Num of NULL strings: "+count);
        
        count = strings.stream().filter(string -> string.length() == 3).count();
        System.out.println("Num of 3 strings with: "+ count);

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("filtered strings: "+ filtered);
        
        String mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Combined Strings: " + mergedString);
        
        List<Integer> numbers = Arrays.asList(3,2,2,3,7,3,5);
        List<Integer> squaresList = numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList());
        System.out.println("Squares List: " + squaresList);

        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("List of Integer: " +integers);

        IntSummaryStatistics stats = integers.stream().mapToInt((x)->x).summaryStatistics();       
        System.out.println("列表中最大的数 : " + stats.getMax());
        System.out.println("列表中最小的数 : " + stats.getMin());
        System.out.println("所有数之和 : " + stats.getSum());
        System.out.println("平均数 : " + stats.getAverage());


        Random random = new Random();
        random.ints().limit(10).forEach(System.out::println);

        count = strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);
    }
}