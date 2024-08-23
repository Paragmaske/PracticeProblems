package LcDaily;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class St {
	public static void main(String[] args) {
		List<String> list = Arrays
				.asList(new String[] { "mango", "mango", "mango", "apple", "apple", "apple", "apple" });
		Map<String, Long> collect = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		Optional<Long> max = collect.values().stream().max(Long::compare);
		System.out.println(max.get());
	}
}
