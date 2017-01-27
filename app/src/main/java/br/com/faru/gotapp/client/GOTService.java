package br.com.faru.gotapp.client;

import java.util.List;

import br.com.faru.gotapp.model.Character;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GOTService {

    @GET("/api/characters?pageSize=20")
    Call<List<Character>> getCharacters(@Query("page") int page);

}

