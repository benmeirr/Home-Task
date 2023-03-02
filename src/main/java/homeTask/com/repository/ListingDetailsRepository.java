package homeTask.com.repository;

import homeTask.com.model.ListingDetails;

import javax.persistence.criteria.Predicate;
import java.util.List;


public interface ListingDetailsRepository {
    List<ListingDetails> findAll(Predicate predicates);
}
