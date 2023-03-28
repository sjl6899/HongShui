package club.hongshui.domain;

import org.springframework.stereotype.Component;

@Component
public class Site {
    private String rainsitename;
    private String longitude;
    private String latitude;

    @Override
    public String toString() {
        return "Site{" +
                "rainsitename='" + rainsitename + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                '}';
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
