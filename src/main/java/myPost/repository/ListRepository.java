//$Id$
package myPost.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import myPost.beans.list.Numbers;

@Repository
public interface ListRepository extends CrudRepository<Numbers, Long> {}


