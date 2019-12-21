package edu.depaul.knowyourgovernment;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AsyncLoaderTask1  extends AsyncTask<String, Void, String> {

    private static final String TAG = "AsyncLoaderTask";
    @SuppressLint("StaticFieldLeak")
    private MainActivity mainActivity;
    private HashMap<String, String> hashMap = new HashMap<>();
    private List<HashMap<String, String>> dummyArr=new ArrayList<HashMap<String, String>>();

    private static final String civicURL = "https://www.googleapis.com/civicinfo/v2/representatives";

    private static final String civicAPIKey = "AIzaSyAHOMxfd0KCkrghdTaNaOzgjdngJvymCRY";
    //////////////////////////////////////////////////////////////////////////////////



    AsyncLoaderTask1(MainActivity ma) {
        mainActivity = ma;
    }

    @Override
    protected void onPostExecute(String s) {
        mainActivity.updateData(hashMap,dummyArr );
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
           hashMap.put("normalizedInput", normalizedInput.getString("city") + ", " +
                    normalizedInput.getString("state") + " " +
                    normalizedInput.getString("zip"));

           // ArrayList<Official> officialsArr = new ArrayList<>();
            JSONArray officials = jObjMain.getJSONArray("officials");
            for (int k = 0; k < officials.length(); k++) {
                JSONObject official = (JSONObject)officials.get(k);
                HashMap <String, String> o = new HashMap <String, String>();
                o.put("name",official.getString("name"));
                o.put("party", official.getString("party"));
                JSONObject address = official.getJSONObject("address");
                o.put("address", address.getString("line1") + " " +
                        address.getString("line2") + " " +
                        address.getString("line3") + " " +
                        address.getString("city") + ", " +
                        address.getString("state") + " " +


                //InputStream input = new java.net.URL(official.getString("photoUrl")).openStream();
                o.put("photoUrl", official.getString("photoUrl")));
                dummyArr.add(o);
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

