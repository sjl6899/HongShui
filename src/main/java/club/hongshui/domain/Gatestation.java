package club.hongshui.domain;

import org.springframework.stereotype.Component;

@Component
public class Gatestation {
    private int id;
    private String gatestationname;
    private String longitude;
    private String latitude;
    private String maxcapacity;

    @Override
    public String toString() {
        return "Gatestation{" +
                "id='" + id + '\'' +
                ",gatestationname='" + gatestationname + '\'' +
                ", longitude='" + longitude + '\'' +
                ", latitude='" + latitude + '\'' +
                ", maxcapacity='" + maxcapacity + '\'' +
                '}';
    }

    public String getGatestationname() {
        return gatestationname;
    }

    public void setGatestationname(String gatestationname) {
        this.gatestationname = gatestationname;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getMaxcapacity() {
        return maxcapacity;
    }

    public void setMaxcapacity(String maxcapacity) {
        this.maxcapacity = maxcapacity;
    }
}
