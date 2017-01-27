package br.com.faru.gotapp.client;

import java.util.List;

import javax.inject.Inject;

import br.com.faru.gotapp.client.callback.OnGetCharactersCallback;
import br.com.faru.gotapp.model.Character;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class GOTApi {

    private GOTService gotService;

    @Inject
    public GOTApi(Retrofit retrofit) {
        gotService = retrofit.create(GOTService.class);
    }

    public void getCharacters(int page, final OnGetCharactersCallback callback) {
        Call<List<Character>> call = gotService.getCharacters(page);
        call.enqueue(new Callback<List<Character>>() {
            @Override
            public void onResponse(Call<List<Character>> call,
                                   Response<List<Character>> response) {
                if (response.isSuccess()) {
                    List<Character> characters = response.body();
                    if (characters != null) {
                        callback.onGetCharactersSuccess(characters);
                    }
                } else {
                    callback.onGetCharactersFailure();
                }
            }

            @Override
            public void onFailure(Call<List<Character>> call, Throwable t) {
                callback.onGetCharactersFailure();
            }
        });
    }

}
