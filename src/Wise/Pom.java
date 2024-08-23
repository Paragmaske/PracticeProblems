
package Wise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Pom {
public static void main(String[] args) {
	List<List<List<Integer>>> inputList = Arrays.asList(
            Arrays.asList(Arrays.asList(1,2,3)),
            Arrays.asList(Arrays.asList(3,3,4)),
            Arrays.asList(Arrays.asList(4,5,6))
            );
List<Integer> collect = inputList.stream().flatMap(List::stream).flatMap(List::stream).collect(Collectors.toList());
collect.stream().distinct().forEach(a->System.out.println(Math.sqrt(a)));
//System.out.println(collect.toString());
}
}
