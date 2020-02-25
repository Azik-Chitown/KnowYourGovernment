
package edu.depaul.knowyourgovernment.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class CivicData {
/*
    @SerializedName("kind")
    @Expose
    private String kind;
    @SerializedName("normalizedInput")
    @Expose
    private NormalizedInput normalizedInput;

    @SerializedName("offices")
    @Expose
    private List<Office> offices = null;
    @SerializedName("officials")
    @Expose
    private List<Official> officials = null;

    *//**
     * No args constructor for use in serialization
     * 
     *//*
    public CivicData() {


    *//**
     * 
     * @param kind
     * @param normalizedInput
     * @param offices
     * @param officials
     *
     * *//*
    public CivicData(String kind, NormalizedInput normalizedInput, List<Office> offices, List<Official> officials) {

        this.kind = kind;
        this.normalizedInput = normalizedInput;

        this.offices = offices;
        this.officials = officials;
    }
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public CivicData withKind(String kind) {
        this.kind = kind;
        return this;
    }

    public NormalizedInput getNormalizedInput() {
        return normalizedInput;
    }

    public void setNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
    }

    public CivicData withNormalizedInput(NormalizedInput normalizedInput) {
        this.normalizedInput = normalizedInput;
        return this;
    }

    public Divisions getDivisions() {
        return divisions;
    }

    public void setDivisions(Divisions divisions) {
        this.divisions = divisions;
    }

    public CivicData withDivisions(Divisions divisions) {
        this.divisions = divisions;
        return this;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public void setOffices(List<Office> offices) {
        this.offices = offices;
    }

    public CivicData withOffices(List<Office> offices) {
        this.offices = offices;
        return this;
    }

    public List<Official> getOfficials() {
        return officials;
    }

    public void setOfficials(List<Official> officials) {
        this.officials = officials;
    }

    public CivicData withOfficials(List<Official> officials) {
        this.officials = officials;
        return this;
    }*/



}
