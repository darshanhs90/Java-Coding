package Warmup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _75yelpInterview {
	/*
	Write a function which takes a list of words and groups the anagrams together.
	input: ["cinema", "cat", "iceman", "act", "goat"]
	output: [["cinema", "iceman"], ["cat", "act"], ["goat"]]
	*/

	//cinema->aceimn
	//cat->act
	//iceman->aceimn
	//act->act
	//goat->agot


	public static ArrayList<ArrayList<String>> convertAnagram(ArrayList<String> inputList){
	  ArrayList<ArrayList<String>> outputList=new ArrayList<ArrayList<String>>();
	  HashMap<String,ArrayList<String>> stringMap=new HashMap<String,ArrayList<String>>();
	  
	  for(int i=0;i<inputList.size();i++){
	    String input=inputList.get(i);
	    char arr[]=input.toCharArray();
	    Arrays.sort(arr);
	    input=new String(arr);
	    if(stringMap.containsKey(input)){
	      ArrayList<String> list=stringMap.get(input);
	      list.add(inputList.get(i));
	      stringMap.put(input,list);
	    }
	    else{
	          ArrayList<String> list=new ArrayList<String>();
	          list.add(inputList.get(i));
	          stringMap.put(input,list);
	    }
	  }
	  
	  Map<String,ArrayList<String>> map=stringMap;
	  for(Map.Entry<String,ArrayList<String>> entry:map.entrySet())
	  {
	    outputList.add(entry.getValue());
	  }
	  
	  return outputList;
	}
}

