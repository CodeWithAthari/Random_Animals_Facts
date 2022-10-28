package com.shiningdevelopers.randomanimalsfacts;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.shiningdevelopers.randomanimalsfacts.databinding.ActivityMainBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;

    ArrayList<MainModel> list;
    MainAdapter adapter;

    MainActivity activity = this;
    Gson gson = new Gson();

    final String api = "https://zoo-animal-api.herokuapp.com/animals/rand/10";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
initRv();

binding.swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
    @Override
    public void onRefresh() {
        gettingData();
    }
});

    }

    private void initRv() {
        list = new ArrayList<>();
        adapter = new MainAdapter(list, activity);
        binding.mainRv.setAdapter(adapter);
        gettingData();


    }
    void log(String tag,String msg){
        Log.d(tag,msg);
    }

    private void gettingData() {
        binding.swipe.setRefreshing(true);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, api, response -> {
            Toast.makeText(activity, "Loaded", Toast.LENGTH_SHORT).show();
            log("resp",response);

            try {
                JSONArray array = new JSONArray(response);
list.clear();
                for(int i = 0;i<array.length();i++){
                    JSONObject object = array.getJSONObject(i);
                    if(!object.getString("name").contains("pig")){
                        MainModel mainModel = gson.fromJson(String.valueOf(object),MainModel.class);
                        list.add(mainModel);
                    }

                    binding.swipe.setRefreshing(false);

                }
                adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
                binding.swipe.setRefreshing(false);

            }


        },
                error -> {
                    binding.swipe.setRefreshing(false);

                    Toast.makeText(activity, "Error", Toast.LENGTH_SHORT).show();
                });

        RequestQueue queue = Volley.newRequestQueue(activity);
        queue.add(stringRequest);


    }
}