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
    ArrayList<pokemon> pokemonArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getDataservices services = RetrofitClientInstnce.getRetrofitInstance().create(getDataservices.class);

/*
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
        });  */

        Call<pokemonPojo> call =services.getPokeobj();
        call.enqueue(new Callback<pokemonPojo>() {
            @Override
            public void onResponse(Call<pokemonPojo> call, Response<pokemonPojo> response) {

                pokemonPojo pojo = response.body();
                try
                {

                }
                catch (NullPointerException e){

                    System.out.println(e.getMessage());
                }
                pokemonArray = new ArrayList<>(pojo.getPokemon());
                generateData(pokemonArray);

            }

            @Override
            public void onFailure(Call<pokemonPojo> call, Throwable t) {


                Toast.makeText(getApplicationContext(),"tryagain",Toast.LENGTH_LONG).show();
            }
        });




    }

    public void generateData(ArrayList<pokemon> pokelist)/*(ArrayList<pokemon> pokelist)*/
    {
        /*ArrayList<pokemon> pokes= (ArrayList<pokemon>) pokemonList;*/
        adapter = new Pokemonadapter(pokelist,getApplicationContext());
        @SuppressLint("WrongConstant") LinearLayoutManager manager = new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false);
        RecyclerView recyclerView =findViewById(R.id.recycle_poke);
        recyclerView .setLayoutManager(manager);
        recyclerView.setAdapter(adapter);

    }




}
