package com.example.retrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class pokemonPojo {

    @SerializedName("Pokemon")
    @Expose
    private List<pokemon> pokemon = null;

    public List<pokemon> getPokemon() {
        return pokemon;
    }

    public void setPokemon(List<pokemon> pokemon) {
        this.pokemon = pokemon;
    }

}
