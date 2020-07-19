//$Id$
package myPost.controller.test;

import java.util.concurrent.atomic.AtomicLong;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import myPost.beans.test.TestBean;
import myPost.repository.TestRepository;

@RestController
public class TestController {

	private static final String template = "Dei, %s!";
	private final AtomicLong counter = new AtomicLong();

	 @Autowired
	 private TestRepository testRepository;
	
	@GetMapping("/test")
	public TestBean greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		TestBean testBean = new TestBean();
		testBean.setId(counter.incrementAndGet());
		testBean.setName(String.format(template, name));
		return testBean;
	}
	
	@PostMapping("/addTest")
    public String addTest(@RequestBody @Valid TestBean test, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "error";
        }
        testRepository.save(test);
        model.addAttribute("test", testRepository.findAll());
        return model.toString();
    }
	
	@GetMapping("/test/{id}")
	public TestBean getTest(@PathVariable("id") long id) {
		TestBean testBean =testRepository.findById(id)
			      .orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		return testBean; 
	}
	
}
