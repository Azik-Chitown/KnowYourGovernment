
package edu.depaul.knowyourgovernment.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Office {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("divisionId")
    @Expose
    private String divisionId;
    @SerializedName("levels")
    @Expose
    private List<String> levels = null;
    @SerializedName("roles")
    @Expose
    private List<String> roles = null;
    @SerializedName("officialIndices")
    @Expose
    private List<Integer> officialIndices = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Office() {
    }

    /**
     * 
     * @param officialIndices
     * @param roles
     * @param name
     * @param divisionId
     * @param levels
     */
    public Office(String name, String divisionId, List<String> levels, List<String> roles, List<Integer> officialIndices) {
        super();
        this.name = name;
        this.divisionId = divisionId;
        this.levels = levels;
        this.roles = roles;
        this.officialIndices = officialIndices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Office withName(String name) {
        this.name = name;
        return this;
    }

    public String getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(String divisionId) {
        this.divisionId = divisionId;
    }

    public Office withDivisionId(String divisionId) {
        this.divisionId = divisionId;
        return this;
    }

    public List<String> getLevels() {
        return levels;
    }

    public void setLevels(List<String> levels) {
        this.levels = levels;
    }

    public Office withLevels(List<String> levels) {
        this.levels = levels;
        return this;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public Office withRoles(List<String> roles) {
        this.roles = roles;
        return this;
    }

    public List<Integer> getOfficialIndices() {
        return officialIndices;
    }

    public void setOfficialIndices(List<Integer> officialIndices) {
        this.officialIndices = officialIndices;
    }

    public Office withOfficialIndices(List<Integer> officialIndices) {
        this.officialIndices = officialIndices;
        return this;
    }



}
