
package edu.depaul.knowyourgovernment.models;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Official {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("address")
    @Expose
    private List<Address> address = null;
    @SerializedName("party")
    @Expose
    private String party;
    @SerializedName("phones")
    @Expose
    private List<String> phones = null;
    @SerializedName("urls")
    @Expose
    private List<String> urls = null;
    @SerializedName("photoUrl")
    @Expose
    private String photoUrl;
    @SerializedName("channels")
    @Expose
    private List<Channel> channels = null;
    @SerializedName("emails")
    @Expose
    private List<String> emails = null;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Official() {
    }

    /**
     * 
     * @param emails
     * @param photoUrl
     * @param urls
     * @param address
     * @param channels
     * @param name
     * @param phones
     * @param party
     */
    public Official(String name, List<Address> address, String party, List<String> phones, List<String> urls, String photoUrl, List<Channel> channels, List<String> emails) {
        super();
        this.name = name;
        this.address = address;
        this.party = party;
        this.phones = phones;
        this.urls = urls;
        this.photoUrl = photoUrl;
        this.channels = channels;
        this.emails = emails;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Official withName(String name) {
        this.name = name;
        return this;
    }

    public List<Address> getAddress() {
        return address;
    }

    public void setAddress(List<Address> address) {
        this.address = address;
    }

    public Official withAddress(List<Address> address) {
        this.address = address;
        return this;
    }

    public String getParty() {
        return party;
    }

    public void setParty(String party) {
        this.party = party;
    }

    public Official withParty(String party) {
        this.party = party;
        return this;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Official withPhones(List<String> phones) {
        this.phones = phones;
        return this;
    }

    public List<String> getUrls() {
        return urls;
    }

    public void setUrls(List<String> urls) {
        this.urls = urls;
    }

    public Official withUrls(List<String> urls) {
        this.urls = urls;
        return this;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Official withPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
        return this;
    }

    public List<Channel> getChannels() {
        return channels;
    }

    public void setChannels(List<Channel> channels) {
        this.channels = channels;
    }

    public Official withChannels(List<Channel> channels) {
        this.channels = channels;
        return this;
    }

    public List<String> getEmails() {
        return emails;
    }

    public void setEmails(List<String> emails) {
        this.emails = emails;
    }

    public Official withEmails(List<String> emails) {
        this.emails = emails;
        return this;
    }



}
