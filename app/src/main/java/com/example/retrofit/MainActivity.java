package com.example.retrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import  java.util.List;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Pokemonadapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getDataservices services = RetrofitClientInstnce.getRetrofitInstance().create(getDataservices.class);


        Call<List<pokemon>> call = services.getPokemon();
        call.enqueue(new Callback<List<pokemon>>() {
            @Override
            public void onResponse(Call<List<pokemon>> call, Response<List<pokemon>> response) {
              generateData(response.body());

            }

            @Override
            public void onFailure(Call<List<pokemon>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"tryagain",Toast.LENGTH_LONG).show();

            }
        });

    }

    public void generateData(List<pokemon> pokemonList)
    {
        ArrayList<pokemon> pokes= (ArrayList<pokemon>) pokemonList;
        adapter = new Pokemonadapter(pokes,getApplicationContext());
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView =findViewById(R.id.recycle_poke);
        recyclerView .setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }




}
