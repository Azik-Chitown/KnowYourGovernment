package edu.depaul.knowyourgovernment.models;

public class DummyObj {


    private String name;
    private String office;
    private String address;
    private String party;



    private String photoUrl;
public  DummyObj( String name,String office,  String address, String photoUrl, String party ) {

    this.office=office;
    this.name=name;
    this.address=address;
    this.photoUrl=photoUrl;
    this.party=party;
}

    public String getName() {
        return name;
    }

    public String getOffice() {
        return office;
    }

    public String getAddress() {
        return address;
    }

    public String getParty() {
        return party;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }
}
