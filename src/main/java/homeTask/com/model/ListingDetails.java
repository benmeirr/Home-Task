package homeTask.com.model;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListingDetails {
    @Id
    private String sessionId;
    private String advertiserId;
    private String country;
    private Double price;
    private Long eventTypeId;
    private Long gdpr;
    private Double minCpm;
    private Double priority;
    private Double bigPrice;

    public ListingDetails(String sessionId, String advertiserId, String country, Double price, Long eventTypeId, Long gdpr, Double minCpm, Double priority, Double bigPrice) {
        this.sessionId = sessionId;
        this.advertiserId = advertiserId;
        this.country = country;
        this.price = price;
        this.eventTypeId = eventTypeId;
        this.gdpr = gdpr;
        this.minCpm = minCpm;
        this.priority = priority;
        this.bigPrice = bigPrice;
    }

    public ListingDetails() {
    }

    public String getSessionId() {
        return sessionId;
    }

    public String getAdvertiserId() {
        return advertiserId;
    }

    public String getCountry() {
        return country;
    }

    public Double getPrice() {
        return price;
    }

    public Long getEventTypeId() {
        return eventTypeId;
    }

    public Long getGdpr() {
        return gdpr;
    }

    public Double getMinCpm() {
        return minCpm;
    }

    public Double getPriority() {
        return priority;
    }

    public Double getBigPrice() {
        return bigPrice;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public void setAdvertiserId(String advertiserId) {
        this.advertiserId = advertiserId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setEventTypeId(Long eventTypeId) {
        this.eventTypeId = eventTypeId;
    }

    public void setGdpr(Long gdpr) {
        this.gdpr = gdpr;
    }

    public void setMinCpm(Double minCpm) {
        this.minCpm = minCpm;
    }

    public void setPriority(Double priority) {
        this.priority = priority;
    }

    public void setBigPrice(Double bigPrice) {
        this.bigPrice = bigPrice;
    }
}
