package homeTask.com.handler;

import homeTask.com.model.ListingDetails;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CsvSourceHandler {

    private String csvFile = "listing-details.csv";

    @Bean
    public List<ListingDetails> init() throws IOException {

        List<ListingDetails> listingDetailsList = new ArrayList<ListingDetails>();

        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);
                System.out.println(data);
                ListingDetails newListingDetails = new ListingDetails(
                    data[0], // session_id
                    data[1], // advertiser_id
                    data[2], // country
                    Double.parseDouble(data[3]), // price
                    Long.parseLong(data[4]), // event_type_id
                    Long.parseLong(data[5]), // gdpr
                    Double.parseDouble(data[6]), // min_cpm
                    Double.parseDouble(data[7]), // priority
                    Double.parseDouble(data[8]) // bid_price
                );
                listingDetailsList.add(newListingDetails);
            }
            System.out.println(listingDetailsList.get(0).getSessionId());
            System.out.println(listingDetailsList.size());
            return listingDetailsList;
        } catch (IOException e) {
            throw e;
        }
    }
}
