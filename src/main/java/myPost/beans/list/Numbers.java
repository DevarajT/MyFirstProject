//$Id$
package myPost.beans.list;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="numbers")
public class Numbers implements Comparable<Numbers>{

	@Column(name="number")
	Long number;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="id")
	Long id;

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public int compareTo(Numbers o) {
		if(number < o.number){
			return -1;
		}else if(number == o.number){
			return 0;
		}else {
			return 1;
		}
	}
	
	@Override
    public String toString() { 
        return number.toString(); 
    }
}
