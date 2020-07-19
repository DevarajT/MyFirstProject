//$Id$
package myPost.controller.list;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myPost.beans.list.Numbers;
import myPost.beans.list.SortingAlgorithm;
import myPost.service.list.ListService;

@RestController
@RequestMapping(value="/v1/list")
public class ListController {

	 @Autowired
	 private ListService listService;
	
	@GetMapping("/numbers")
	public List<Numbers> getAllNumbers() {
		return listService.getAll();
	}
	
	@PostMapping("/numbers")
    public String addNumbersToList(@RequestBody  List<Numbers> numbers, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        listService.addToList(numbers);
        
        return "success";
    }
	
	@DeleteMapping("/numbers")
	public String deleteAll() {
		listService.deleteAll();
		return "success";
	}
	
	@PostMapping("/actions/sort")
	public List<Numbers> sortList(@RequestParam(name = "type", required = false) String type)
	{
		return listService.sort(SortingAlgorithm.get(type));
	}
	
}
