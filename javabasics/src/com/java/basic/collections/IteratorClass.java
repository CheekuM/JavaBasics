package com.java.basic.collections;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.List;

class CustomDataStructure{
	private String name ;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public CustomDataStructure(String name, int age)
	{
		this.name=name;
		this.age=age;
	}
}
class CustomIterable implements Iterable<CustomDataStructure>{

	CustomDataStructure[] elements;
	int size;
	int cursor;
	public CustomIterable() {
		// TODO Auto-generated constructor stub
		cursor=0;
		size=2;
		elements=new CustomDataStructure[size];
	}
	public void add(CustomDataStructure customDataStructure) {
		ensureCapacity(cursor+1);
		elements[++cursor]=customDataStructure;
		
	}
	private void ensureCapacity(int size) {
		if(size>this.size)
		 this.size=2*this.size;
		
		Arrays.copyOf(elements, this.size);
	}
	@Override
	public Iterator<CustomDataStructure> iterator() {
		// TODO Auto-generated method stub
		return new CustomIterator();
	}
	
}

class CustomIterator implements Iterator<CustomDataStructure>{

	public CustomIterator() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public CustomDataStructure next() {
		// TODO Auto-generated method stub
		return null;
	}
	
}

public class IteratorClass {
	
	
	// 3 ways of implementing iterable
	private void iterableExample() {
		Integer[] a={1,2,3,4,5,6};
		List<Integer> list=Arrays.asList(a);
		// Enhanced For loop 
		for(Integer i:list) {
			System.out.println(i);
		}
		// forEach implementation
		list.forEach(System.out::println);
		// Using Iterator interface
		Iterator<Integer> iter=list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
			iter.remove();
		}
		

	}
	
	
	public static void main(String[] args) {
		IteratorClass iteratorClass=new IteratorClass();
		iteratorClass.iterableExample();
		
	}
}
