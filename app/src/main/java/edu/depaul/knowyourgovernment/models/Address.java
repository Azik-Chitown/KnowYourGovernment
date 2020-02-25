
package edu.depaul.knowyourgovernment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Address {

    @SerializedName("line1")
    @Expose
    private String line1;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("zip")
    @Expose
    private String zip;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Address() {
    }

    /**
     * 
     * @param zip
     * @param city
     * @param state
     * @param line1
     */
    public Address(String line1, String city, String state, String zip) {
        super();
        this.line1 = line1;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getLine1() {
        return line1;
    }

    public void setLine1(String line1) {
        this.line1 = line1;
    }

    public Address withLine1(String line1) {
        this.line1 = line1;
        return this;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Address withCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Address withState(String state) {
        this.state = state;
        return this;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public Address withZip(String zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("line1", line1).append("city", city).append("state", state).append("zip", zip).toString();
    }


}
