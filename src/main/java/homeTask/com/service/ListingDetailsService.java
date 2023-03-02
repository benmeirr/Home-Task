package homeTask.com.service;

import homeTask.com.model.ListingDetails;

import java.util.List;

public interface ListingDetailsService {
    List<ListingDetails> findAll(Double minPrice, Double maxPrice, Long minMinCpm, Long maxMinCpm);
}
