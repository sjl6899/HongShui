package club.hongshui.domain;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class Site implements Serializable {
    private int id;
    private String rainsitename;
    private String longitude;
    private String latitude;

    @Override
    public String toString() {
        return "Site{" +
                "id='" + id + '\'' +
                "rainsitename='" + rainsitename + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRainsitename() {
        return rainsitename;
    }

    public void setRainsitename(String rainsitename) {
        this.rainsitename = rainsitename;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }
}
