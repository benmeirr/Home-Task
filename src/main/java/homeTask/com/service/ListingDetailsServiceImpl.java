package homeTask.com.service;

import homeTask.com.model.ListingDetails;
import homeTask.com.repository.ListingDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class ListingDetailsServiceImpl implements ListingDetailsService {

    @Autowired
    private ListingDetailsRepository listingDetailsRepository;

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<ListingDetails> findAll(Double minPrice, Double maxPrice, Long minMinCpm, Long maxMinCpm) {
        Predicate predicates = criteriaBuilderHandler(minPrice, maxPrice, minMinCpm, maxMinCpm);
        return listingDetailsRepository.findAll(predicates);
    }

    private Predicate criteriaBuilderHandler(Double minPrice, Double maxPrice, Long minMinCpm, Long maxMinCpm){

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<ListingDetails> query = criteriaBuilder.createQuery(ListingDetails.class);
        Root<ListingDetails> root = query.from(ListingDetails.class);

        List<Predicate> predicates = new ArrayList<>();

        if (Objects.nonNull(minPrice)) {
            System.out.println("This is minPrice: " + minPrice);
            predicates.add(criteriaBuilder.ge(root.get("price"), minPrice));
        }
        if (Objects.nonNull(maxPrice)) {
            System.out.println("This is maxPrice: " + maxPrice);
            predicates.add(criteriaBuilder.le(root.get("price"), maxPrice));
        }
        if (Objects.nonNull(minMinCpm)) {
            System.out.println("This is minMinCpm: " + minMinCpm);
            predicates.add(criteriaBuilder.ge(root.get("minCpm"), minPrice));
        }
        if (Objects.nonNull(maxMinCpm)) {
            System.out.println("This is maxMinCpm: " + maxMinCpm);
            predicates.add(criteriaBuilder.ge(root.get("minCpm"), maxMinCpm));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
    }
}
