package com.java.basic.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class User{
	int id;
	int age;
	String name;
	User(int id, int age, String name){
		this.id=id;
		this.age=age;
		this.name=name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "[ User Id = "+id+", Name = "+name+", Age = "+age +"]";
	}
	
}
public class StreamExample {

	private void steamApiExample() {
		int[] arr= {1,2,3,4,5,6};
		Arrays.stream(arr).map(s->s*2).forEach(System.out::println);
		List<List<Integer>> twoD=new ArrayList<>();
		twoD.add(Arrays.asList(1,2,3,4,5,6));
		twoD.add(Arrays.asList(1,2,3,4,5,6));
		twoD.add(Arrays.asList(1,2,3,4,5,6));
	
		twoD.stream().flatMap(p->p.stream()).map(p->p*2).forEach(System.out::println);
		twoD.stream().findFirst().stream().forEach(System.out::println);
		  List<Integer> arr2 = List.of(1, 2, 3, 4, 5, 6, 7,0);
	        List<Integer> even
	            = arr2.stream().reduce(new ArrayList<Integer>(),
	                                  (a, b)
	                                      -> {
	                                      if (b % 2 == 0)
	                                          a.add(b);
	                                      return a;
	                                  },
	                                  (a, b) -> {
	                                      a.addAll(b);
	                                      return a;
	                                  });
	        System.out.println(even);
	        
	        
	        List<Integer> odd=arr2.stream().reduce(new ArrayList<Integer>(), (a,b)->{
	        	if(b%2!=0)
	        		a.add(b);
	        	
	        	return a;
	        },
	        		(a,b)->{
	        			a.addAll(b);
	        			return a;
	        		});
	        System.out.println(odd);
	        
	      
	        	int mod = arr2.stream().reduce((a,b)->{
	        	try {
	        		return a/b;
	        	}catch(ArithmeticException e) {
	        	System.out.println("Arithmetic Exception occured....");
	        		return 0;
	        	}
	        	}).get();
	        	
	        	System.out.println(mod);
	        	
	        	// return the first element in stream
	        	int first= arr2.stream().reduce((a,b)->a).get();
	        	System.out.println("first element"+first+ " "+twoD.stream().flatMap(p->p.stream()).findFirst().get());
	        	String input="Geeks for GeeksFor";
	        	Map<String,Integer> lengthMap=Arrays.stream(input.split(" ")).collect(Collectors.toMap(v->v, v->v.length()));
	        	System.out.println(lengthMap);
	        	
	}
	public static void main(String[] args) {
		StreamExample streamExample=new StreamExample();
		streamExample.steamApiExample();
		User user1=new User(1, 24, "Shikha");
		User user2=new User(2, 25, "Maurya");
		User user3=new User(3, 26, "Pradeep");
		User user4=new User(4, 26, "Maiya");
		User user5=new User(5, 25, "Harshit");
		Map<Integer, User> map=Arrays.asList(user1, user2, user3).stream().collect(Collectors.toMap(user->user.getId(), user->user));
		System.out.println(map);
		Map<Integer, List<User>> map2=Arrays.asList(user1, user2, user3, user4, user5)
				.stream().collect(Collectors.groupingBy(User::getAge));
		System.out.println(map2);
		Map<Integer, Long> map3=Arrays.asList(user1, user2, user3, user4, user5)
				.stream().collect(Collectors.groupingBy(User::getAge, Collectors.counting()));
		System.out.println(map3);
		
		
	}
}
