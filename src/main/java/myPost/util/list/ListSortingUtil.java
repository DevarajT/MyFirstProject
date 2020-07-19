//$Id$
package myPost.util.list;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myPost.beans.list.Numbers;
import myPost.beans.list.SortingAlgorithm;
import myPost.repository.ListRepository;


public class ListSortingUtil{

	
	public static List<Numbers> doSelectionSort(List<Numbers> numbers){
		int length = numbers.size();
		for(int i=0;i<length;i++){
			int min = i;
			for(int j=i+1;j<length;j++){
				if(numbers.get(min).compareTo(numbers.get(j))>0){
					min = j;
				}
			}
			if(min!=i){
				Collections.swap(numbers, i, min);
			}
		}
		
		return numbers;
		
	}
	
}
