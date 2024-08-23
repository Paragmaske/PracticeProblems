package Algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Empe{
	String name;
	List<String> cities;

	public Empe(String name, List<String> cities) {
		super();
		this.name = name;
		this.cities = cities;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

}

public class DEMO {
	public static void main(String[] args) {
		List<String> s1 = Arrays.asList("a", "b", "c", "d");
		List<String> s2 = Arrays.asList("b", "c", "d");
		List<String> s3 = Arrays.asList("d", "e", "f", "g");

		Empe e1 = new Empe("parag", s1);
		Empe e2 = new Empe("bala", s2);
		Empe e3 = new Empe("shan", s3);
		List<Empe> li = new ArrayList<Empe>();
		li.add(e1);
		li.add(e2);
		li.add(e3);
 li.stream().map(x -> {
			 
			 Map<String,String> cityUser=new HashMap<>();
	
			 List<String> cities = x.getCities();
			 for(String s :cities)
			 {
				 cityUser.put(s, x.getName());
			 }
			 return cityUser;
		}).collect(Collectors.toList())
		 
		.stream().filter(a->
		{
			for(Map.Entry<String, String> en:a.entrySet())
			{
				if("b"==en.getKey())
				{
					return true;
				}
			}
			return false;
		}).map(q->q.get(q)).distinct().collect(Collectors.toList()).forEach(a1->System.out.println(a1));;
			
				
		

		
		
		 
	}
}
