//$Id$
package myPost.beans.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

@Entity
@Table(name="test_table")
public class TestBean {

	@Column(name="test_name")
	@NotEmpty
	String name;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="test_id")
	Long id;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
