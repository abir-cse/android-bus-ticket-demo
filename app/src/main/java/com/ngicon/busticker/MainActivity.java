package com.ngicon.busticker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Spinner;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button button;
    Spinner spinner1, spinner2;
    DatePicker datePicker;
    String journeyDate, journeyFrom, journeyTo;
    ArrayList<String> cityList_1 = new ArrayList<>();
    ArrayList<String> cityList_2 = new ArrayList<>();
    ArrayAdapter<String> cityAdapter_1;
    ArrayAdapter<String> cityAdapter_2;
    RequestQueue requestQueue;
    String url= "http://demo.pigeon.com.bd/country.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("BOOK A TRIP");
        requestQueue = Volley.newRequestQueue(this);
        button = findViewById(R.id.button);
        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        datePicker = findViewById(R.id.datePicker);
        final JsonObjectRequest jsonObjectRequest= new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("cities");
                    for (int i=0;i<jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String cityName_1 = jsonObject.optString("name");
                        cityList_1.add(cityName_1);
                        cityAdapter_1 = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_spinner_item, cityList_1);
                        cityAdapter_1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner1.setAdapter(cityAdapter_1);
                    }
                    for (int j=0;j<jsonArray.length(); j++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(j);
                        String cityName_2 = jsonObject.optString("name");
                        cityList_2.add(cityName_2);
                        cityAdapter_2 = new ArrayAdapter<>(MainActivity.this,
                                android.R.layout.simple_spinner_item, cityList_2);
                        cityAdapter_2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        spinner2.setAdapter(cityAdapter_2);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }
        );


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                journeyFrom = spinner1.getSelectedItem().toString();
                journeyTo = spinner2.getSelectedItem().toString();
                journeyDate = datePicker.getDayOfMonth()+"/"+ (datePicker.getMonth() + 1)+"/"+datePicker.getYear();
                String data = journeyFrom+journeyTo+journeyDate;
                Log.e("data-----------", data);
                Intent intent = new Intent(MainActivity.this, SearchResult.class);
                intent.putExtra("text", "-----------------------");
                startActivity(intent);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}