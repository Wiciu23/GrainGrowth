package com.witek.placeholder;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Configuration {

    private String boundary;
    private String neighborhood;
    private int seeds;
    private int size;
    private boolean display;
    private String method;
    private int epochs;

    public Configuration() {
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public int getEpochs() {
        return epochs;
    }

    public void setEpochs(int epochs) {
        this.epochs = epochs;
    }

    public Configuration(String boundary, String neighborhood, int seeds, int size, boolean display, String method , int epochs) {
        this.boundary = boundary;
        this.neighborhood = neighborhood;
        this.seeds = seeds;
        this.size = size;
        this.display = display;
        this.method = method;
        this.epochs = epochs;

    }

    public void setDisplay(boolean display) {
        this.display = display;
    }

    public void setBoundary(String boundary) {
        this.boundary = boundary;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getBoundary() {
        return boundary;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public int getSeeds() {
        return seeds;
    }

    public int getSize() {
        return size;
    }

    public boolean isDisplay() {
        return display;
    }
}
