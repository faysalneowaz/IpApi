package com.signatureocr.ipapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String apiUrl = "https://ipapi.co/json";
    RequestQueue queue;
//    TextView cotuntry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        queue = Volley.newRequestQueue(this);
//        cotuntry = findViewById(R.id.cotuntry);


        StringRequest stringRequest = new StringRequest(Request.Method.POST, apiUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                            try {
                                JSONObject object = new JSONObject(response);
                                Log.e("IP: ",object.getString("ip"));
                                Log.e("city: ",object.getString("city"));
                                Log.e("region: ",object.getString("region"));
                                Log.e("region code:",object.getString("region_code"));
                                Log.e("country",object.getString("country"));
                                Log.e("country code: ",object.getString("country_code"));
                                Log.e("country_code_iso3: ",object.getString("country_code_iso3"));
                                Log.e("country_capital: ",object.getString("country_capital"));
                                Log.e("country_tld: ",object.getString("country_tld"));
                                Log.e("country_name: ",object.getString("country_name"));
                                Log.e("continent_code: ",object.getString("continent_code"));
                                Log.e("in_eu: ",object.getString("in_eu"));
                                Log.e("postal: ",object.getString("postal"));
                                Log.e("latitude: ",object.getString("latitude"));
                                Log.e("longitude: ",object.getString("longitude"));
                                Log.e("timezone: ",object.getString("timezone"));
                                Log.e("utc_offset: ",object.getString("utc_offset"));
                                Log.e("country_calling_code: ",object.getString("country_calling_code"));
                                Log.e("currency: ",object.getString("currency"));
                                Log.e("currency_name: ",object.getString("currency_name"));
                                Log.e("languages: ",object.getString("languages"));
                                Log.e("country_area: ",object.getString("country_area"));
                                Log.e("country_population: ",object.getString("country_population"));
                                Log.e("asn: ",object.getString("asn"));
                                Log.e("org: ",object.getString("org"));
//                                Log.e("11",object.getString("country"));

//                                cotuntry.setText(object.getString("country"));

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

//                        }
//                        Log.e("ALLRESPONSE",response);






                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }){
            public Map<String,String> getHeaders(){

                Map<String, String> headers = new HashMap<String, String>();
                headers.put("User-agent", "java-ipapi-client");
                return headers;
            }
        };

        queue.add(stringRequest);

    }
}
