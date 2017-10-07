package com.example.satoukanae.amiga;

import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by satoukanae on 2017/10/07.
 */

public class RecommendAPIInterface {
    public static Profile requestRecommendation(int userId) throws IOException{
        String url = String.format("http://localhost:8888/recommend?json={\"user\":%d}", userId);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                    .url(url)
                    .build();

        Response response = client.newCall(request).execute();

        client.newCall(request).enqueue(new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ObjectMapper mapper = new ObjectMapper();
                Profile profile = mapper.readValue(response.body().string(), Profile.class);
                
            }
        });

    }

}
