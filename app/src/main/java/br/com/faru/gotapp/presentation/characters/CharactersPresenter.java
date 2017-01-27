package br.com.faru.gotapp.presentation.characters;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import br.com.faru.gotapp.client.GOTApi;
import br.com.faru.gotapp.client.callback.OnGetCharactersCallback;
import br.com.faru.gotapp.model.Character;
import br.com.faru.gotapp.model.view.CharacterViewModel;
import br.com.faru.gotapp.presentation.widget.EndlessGridScrollListener;


public class CharactersPresenter implements CharactersContract.UserInteractions,
        EndlessGridScrollListener.OnEndlessGridScrollListener,
        OnGetCharactersCallback {

    GOTApi client;

    private CharactersContract.View view;

    private boolean isDownloading;
    private int page = 1;

    @Inject
    public CharactersPresenter(GOTApi client) {
        this.client = client;
    }

    @Override
    public void setView(CharactersContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        isDownloading = true;
        view.setProgressIndicator(isDownloading);
        client.getCharacters(page, this);
    }

    @Override
    public void onClick(CharacterViewModel character) {
        view.goToCharacter(character);
    }

    @Override
    public void onGetCharactersSuccess(List<Character> characters) {
        page++;
        isDownloading = false;
        view.setProgressIndicator(isDownloading);

        final List<CharacterViewModel> charactersViewModel = new ArrayList<>();
        for (Character character : characters) {
            final CharacterViewModel characterViewModel = new CharacterViewModel(character);
            charactersViewModel.add(characterViewModel);
        }

        view.showResults(charactersViewModel);
    }

    @Override
    public void onGetCharactersFailure() {
        isDownloading = false;
        view.setProgressIndicator(isDownloading);
    }

    @Override
    public void loadMoreIfItIsPossible() {
        if (!isDownloading()) {
            isDownloading = true;
            client.getCharacters(page, this);
        }
    }

    @Override
    public boolean isDownloading() {
        return isDownloading;
    }
}
