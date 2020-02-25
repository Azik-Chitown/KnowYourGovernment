package edu.depaul.knowyourgovernment.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import edu.depaul.knowyourgovernment.network.AsyncLoaderTask1;
import edu.depaul.knowyourgovernment.adapters.CivicDataAdapter;
import edu.depaul.knowyourgovernment.R;
import edu.depaul.knowyourgovernment.models.DummyObj;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, View.OnLongClickListener {

    private static int MY_LOCATION_REQUEST_CODE_ID = 329;
    private LocationManager locationManager;
    private Criteria criteria;
    private TextView locTextView;
    private String zipCode="60645";
    private List<DummyObj> officialList;
    private RecyclerView recyclerView;
    private CivicDataAdapter mAdapter;

    private HashMap<String, String> hashMap = new HashMap<>();
    private List<HashMap<String, String>> dummyArr=new ArrayList<HashMap<String, String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        locTextView=findViewById(R.id.locTextView);
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        criteria = new Criteria();
        criteria.setPowerRequirement(Criteria.POWER_LOW);
        //criteria.setPowerRequirement(Criteria.POWER_HIGH);
        criteria.setAccuracy(Criteria.ACCURACY_MEDIUM);
        //criteria.setAccuracy(Criteria.ACCURACY_FINE);
        criteria.setAltitudeRequired(false);
        criteria.setBearingRequired(false);
        criteria.setSpeedRequired(false);
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PERMISSION_GRANTED) { ActivityCompat.requestPermissions( this, new String[]{  Manifest.permission.ACCESS_FINE_LOCATION }, MY_LOCATION_REQUEST_CODE_ID);
        } else { setLocation();  }
        officialList= new ArrayList<DummyObj>();
        recyclerView=findViewById(R.id.recycler);

        mAdapter=new CivicDataAdapter(officialList,this);
        recyclerView.setAdapter(mAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadDummyList();

    }

    public void loadData(String s){
        new AsyncLoaderTask1(this).execute(s);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Intent intent =new Intent (this, AboutActivity.class);
                startActivity(intent);
                return true;
            default:
                return super.onOptionsItemSelected(item);


        }
    }
    @Override
    public void onRequestPermissionsResult(
            int requestCode, @NonNull
            String[] permissions, @NonNull
                    int[] grantResults) {

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == MY_LOCATION_REQUEST_CODE_ID) {
            if (permissions[0].equals(Manifest.permission.ACCESS_FINE_LOCATION) &&
                    grantResults[0] == PERMISSION_GRANTED) {
                setLocation();

            }
        }

    }
    @SuppressLint("MissingPermission")
    private void setLocation() {
        String bestProvider = locationManager.getBestProvider(criteria, true);
        Location currentLocation = locationManager.getLastKnownLocation(bestProvider);
        if (currentLocation != null)
        {
            Geocoder geocoder = new Geocoder(this, Locale.getDefault());
            try {
                List<Address> addresses;
                StringBuilder sb = new StringBuilder();
                double lat = currentLocation.getLatitude();
                double longt=currentLocation.getLongitude();
                String city ="";
                String state="";
                String zip="";
                addresses =geocoder.getFromLocation(lat,longt,10);
                for (Address ad : addresses) {
                    city=ad.getLocality();
                    state=ad.getAdminArea();
                    zip=ad.getPostalCode().toString();
                    zipCode=zip;
                    break;}
                locTextView.setText(city+", "+state+", "+zip);
            }catch (IOException e) {e.printStackTrace(); }
        }
    }

    public void updateData(HashMap<String, String> hashMap1, List<HashMap<String, String>> dummyArr1) {
        for(int i=0; i<dummyArr1.size();i++){
            String name=dummyArr1.get(i).get("name");
            String office=dummyArr1.get(i).get("office");
            String party=dummyArr1.get(i).get("party");
            String address=dummyArr1.get(i).get("address");
            String photoUrl=dummyArr1.get(i).get("photoUrl");
            DummyObj off=new DummyObj( name, office, address, photoUrl,party );
            officialList.add(off);
            mAdapter.notifyDataSetChanged();
        }



    }
    private void loadDummyList(){

        DummyObj d1= new DummyObj("Donald J. Trump", "President of the United States","The White House\n Pennsylvania Ave NW\n Washington, DC, 20500", "https://www.whitehouse.gov/sites/whitehouse.gov/files/images/45/PE%20Color.jpg" , "Republican Party");
        DummyObj d2= new DummyObj("Mike Pence", "Vice President of the United States","The White House\n Pennsylvania Ave NW\n Washington, DC, 20500", "https://www.whitehouse.gov/sites/whitehouse.gov/files/images/45/VPE%20Color.jpg" , "Republican Party");
        DummyObj d3= new DummyObj("Dianne Feinstein", "United States Senate","One Post Street\n Suite 2450\n San Francisco, CA, 94104", "http://bioguide.congress.gov/bioguide/photo/F/F000062.jpg" , "Democratic Party");
        DummyObj d4= new DummyObj("Kamala D. Harris", "United States Senate","112 Hart Senate Office Building\n Washington, DC, 20510", "" , "Democratic Party");
        officialList.add(d1);
        officialList.add(d2);
        officialList.add(d3);
        officialList.add(d4);
        mAdapter.notifyDataSetChanged();

    }

    @Override
    public void onClick(View v) {
        int pos=recyclerView.getChildLayoutPosition(v);
        DummyObj d=officialList.get(pos);
        Intent intent =new Intent(this, FotoActivity.class);
        intent.putExtra("name", d.getName());
        intent.putExtra("office", d.getOffice());
        intent.putExtra("photoUrl", d.getPhotoUrl());
        startActivity(intent);

    }

    @Override
    public boolean onLongClick(View v) {
        return false;
    }
}

