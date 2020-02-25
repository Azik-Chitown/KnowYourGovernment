package edu.depaul.knowyourgovernment.models;

import java.util.HashMap;
import java.util.ArrayList;

/*

class CivicData1 {
    public String address;
    public ArrayList<Office> offices = new ArrayList<>();

}
class Office{
    public String name;
    public ArrayList<Official> officials = new ArrayList<>();
}
class Official  {
    public String name;
    public String address;
    public String party;
    public ArrayList<String> phones = new ArrayList<>();
    public ArrayList<String> emails = new ArrayList<>();
    public String photoUrl;
    public ArrayList<String> urls = new ArrayList<>();
    public HashMap<String,String> channels = new HashMap<>(); // type, id
}


*/


/*
public class AsyncLoaderTask  extends AsyncTask<String, Void, String> {

    private static final String TAG = "AsyncLoaderTask";
    @SuppressLint("StaticFieldLeak")
    private MainActivity mainActivity;
    private HashMap<String, String> wData = new HashMap<>();
    //private Bitmap bitmap;


    private CivicData1 civicData;
    //private Bitmap civicBitmap;

   // private static final String weatherURL = "http://api.openweathermap.org/data/2.5/weather";
    private static final String civicURL = "https://www.googleapis.com/civicinfo/v2/representatives";
    //private static final String iconUrl = "http://openweathermap.org/img/w/";
    //////////////////////////////////////////////////////////////////////////////////
    // Sign up to get your API Key at:  https://home.openweathermap.org/users/sign_up
    private static final String yourAPIKey = "6bfc226f3d6885de5b239a8c33047524";
    private static final String civicAPIKey = "AIzaSyAHOMxfd0KCkrghdTaNaOzgjdngJvymCRY";
    //////////////////////////////////////////////////////////////////////////////////



    AsyncLoaderTask(MainActivity ma) {
        mainActivity = ma;
    }

    @Override
    protected void onPostExecute(String s) {
       // mainActivity.updateData(civicData);
    }

    @Override
    protected String doInBackground(String... params) {

        // 0 == address

        Uri.Builder buildURL = Uri.parse(civicURL).buildUpon();

        buildURL.appendQueryParameter("key", civicAPIKey);
        buildURL.appendQueryParameter("address", params[0]);
        String urlToUse = buildURL.build().toString();
        Log.d(TAG, "doInBackground: " + urlToUse);

        StringBuilder sb = new StringBuilder();
        try {
            URL url = new URL(urlToUse);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            InputStream is = conn.getInputStream();
            BufferedReader reader = new BufferedReader((new InputStreamReader(is)));

            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append('\n');
            }

            Log.d(TAG, "doInBackground: " + sb.toString());

        } catch (Exception e) {
            Log.e(TAG, "doInBackground: ", e);
            return null;
        }

        parseJSON(sb.toString());

        return null;

    }

    private void parseJSON(String s) {

        try {
            JSONObject jObjMain = new JSONObject(s);

            JSONObject normalizedInput = jObjMain.getJSONObject("normalizedInput");
            // build normalized address
            civicData.address = normalizedInput.getString("city") + ", " +
                    normalizedInput.getString("state") + " " +
                    normalizedInput.getString("zip");

            ArrayList<Official> officialsArr = new ArrayList<>();
            JSONArray officials = jObjMain.getJSONArray("officials");
            for (int k = 0; k < officials.length(); k++) {
                JSONObject official = (JSONObject)officials.get(k);
                Official o = new Official();
                o.name = official.getString("name");
                o.party = official.getString("party");
                JSONObject address = official.getJSONObject("address");
                o.address = address.getString("line1") + " " +
                        address.getString("line2") + " " +
                        address.getString("line3") + " " +
                        address.getString("city") + ", " +
                        address.getString("state") + " " +
                        address.getString("zip");
                JSONArray channels = official.getJSONArray("channels");
                for (int i = 0; i < channels.length(); i++) {
                    JSONObject channel = channels.getJSONObject(i);
                    o.channels.put(channel.getString("type"),
                            channel.getString("id"));
                }
                JSONArray emails = official.getJSONArray("emails");
                for (int i = 0; i < emails.length(); i++) {
                    o.emails.add(emails.getString(i));
                }
                JSONArray phones = official.getJSONArray("phones");
                for (int i = 0; i < phones.length(); i++) {
                    o.phones.add(phones.getString(i));
                }
                JSONArray urls = official.getJSONArray("channels");
                for (int i = 0; i < urls.length(); i++) {
                    o.urls.add(urls.getString(i));
                }
                //InputStream input = new java.net.URL(official.getString("photoUrl")).openStream();
                o.photoUrl = official.getString("photoUrl");
                officialsArr.add(o);
            }

            JSONArray offices = jObjMain.getJSONArray("offices");
            for (int i = 0; i < offices.length(); i++) {
                JSONObject office = (JSONObject) offices.get(i);
                Office of = new Office();
                of.name = office.getString("name");
                JSONArray officialInds = office.getJSONArray("officialIndices");
                for (int j = 0; j < officialInds.length(); j++) {
                    of.officials.add(officialsArr.get(officialInds.getInt(j)));
                }
                civicData.offices.add(of);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}*/

