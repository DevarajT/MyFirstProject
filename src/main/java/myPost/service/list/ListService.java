//$Id$
package myPost.service.list;

import java.util.List;

import myPost.beans.list.Numbers;
import myPost.beans.list.SortingAlgorithm;

public interface ListService {

	public  void addToList(List<Numbers> list);
	public  List<Numbers> getAll();
	public void deleteAll();
	public List<Numbers> sort(SortingAlgorithm algorithm);
}
