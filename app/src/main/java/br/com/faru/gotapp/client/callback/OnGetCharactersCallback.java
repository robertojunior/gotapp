package br.com.faru.gotapp.client.callback;

import java.util.List;

import br.com.faru.gotapp.model.Character;

public interface OnGetCharactersCallback {

    void onGetCharactersSuccess(List<Character> characters);

    void onGetCharactersFailure();

}
