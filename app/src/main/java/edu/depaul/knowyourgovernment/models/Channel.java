
package edu.depaul.knowyourgovernment.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Channel {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("id")
    @Expose
    private String id;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Channel() {
    }

    /**
     * 
     * @param id
     * @param type
     */
    public Channel(String type, String id) {
        super();
        this.type = type;
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Channel withType(String type) {
        this.type = type;
        return this;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Channel withId(String id) {
        this.id = id;
        return this;
    }



}
