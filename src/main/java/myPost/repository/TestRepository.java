//$Id$
package myPost.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myPost.beans.test.TestBean;

@Repository
public interface TestRepository extends CrudRepository<TestBean, Long> {}


