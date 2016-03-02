package io.pivotal.micropcf.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;

@Document
public class Track {

    @Id
    private BigInteger id;

    private String trackUUID;
    private String heading;
    private long latitude;
    private long longitude;
    private BigInteger aorId;

    private Track() {
    }

    public Track(String trackUUID, String heading) {
        this();
        this.trackUUID = trackUUID;
        this.heading = heading;
        this.aorId = BigInteger.ZERO;
        this.latitude = 0;
        this.longitude = 0;
    }

    public BigInteger getId() {return id;}

    public void setId(BigInteger id) {this.id = id;}

    public String getTrackUUID() {
        return trackUUID;
    }

    public void setTrackUUID(String trackUUID) {
        this.trackUUID = trackUUID;
    }

    public String getHeading() {
        return heading;
    }

    public void setHeading(String heading) {
        this.heading = heading;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public BigInteger getAorId() {
        return aorId;
    }

    public void setAorId(BigInteger aorId) {
        this.aorId = aorId;
    }

    @Override
    public String toString() {
        return "Track{" +
                "trackUUID='" + trackUUID + '\'' +
                ", heading='" + heading + '\'' +
                ", latitude='" + latitude + '\'' +
                ", longitude='" + longitude + '\'' +
                ", aorId=" + aorId +
                '}';
    }
}
