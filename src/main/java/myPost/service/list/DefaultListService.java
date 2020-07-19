//$Id$
package myPost.service.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import myPost.beans.list.Numbers;
import myPost.beans.list.SortingAlgorithm;
import myPost.repository.ListRepository;
import myPost.util.list.ListSortingUtil;

@Service
public class DefaultListService implements ListService{

	@Autowired
	ListRepository listRepository;
	
	@Override
	public  void addToList(List<Numbers> list) {
		listRepository.saveAll(list);
	}

	@Override
	public List<Numbers> getAll() {
		// TODO Auto-generated method stub
		return (List<Numbers>) listRepository.findAll();
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		listRepository.deleteAll();
	}

	public List<Numbers> sort(SortingAlgorithm algorithm){
		List<Numbers> numbers=(List<Numbers>) listRepository.findAll();
		if(algorithm == null){
			return ListSortingUtil.doSelectionSort(numbers);
		}else{
		switch(algorithm){
		case SELECTIONSORT : 
		default:
			return ListSortingUtil.doSelectionSort(numbers);
		}
		}
	}
	
}
