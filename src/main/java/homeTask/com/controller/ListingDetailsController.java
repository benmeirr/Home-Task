package homeTask.com.controller;

import homeTask.com.model.ListingDetails;
import homeTask.com.service.ListingDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ListingDetailsController {

    @Autowired
    private ListingDetailsService listingDetailsService;

    @GetMapping(value = "/listings")
    List<ListingDetails> getByEverything(
            @RequestParam(value = "min_price", required = false) Double minPrice,
            @RequestParam(value = "max_price", required = false) Double maxPrice,
            @RequestParam(value = "min_min_cpm", required = false) Long minMinCpm,
            @RequestParam(value = "max_min_cpm", required = false) Long maxMinCpm
    ){
        return listingDetailsService.findAll(minPrice, maxPrice, minMinCpm, maxMinCpm);
    }
}
