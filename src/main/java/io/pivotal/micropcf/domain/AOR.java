package io.pivotal.micropcf.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@Document()
public class AOR {

    @Id
    private BigInteger id;

    private String name;

    @DBRef
    private List<Track> tracks;

    private AOR() {
        tracks = new ArrayList<>();
    }

    public AOR(String name) {
        this();
        this.name = name;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Track> getTracks() {
        return tracks;
    }

    public void setTracks(List<Track> tracks) {
        this.tracks = tracks;
    }
}