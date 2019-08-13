package com.example.retrofit;


import  java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface getDataservices {

    @GET("Vy2abloQD")
    Call<List<pokemon>> getPokemon();

    @GET("E14trR2lD")
    Call<pokemonPojo> getPokeobj();
}
