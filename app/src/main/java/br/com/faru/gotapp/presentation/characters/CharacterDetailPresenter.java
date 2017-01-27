package br.com.faru.gotapp.presentation.characters;

import javax.inject.Inject;

import br.com.faru.gotapp.model.view.CharacterViewModel;

public class CharacterDetailPresenter implements CharacterDetailContract.UserInteractions {

    private CharacterDetailContract.View view;

    @Inject
    public CharacterDetailPresenter() {
    }

    @Override
    public void setView(CharacterDetailContract.View view) {
        this.view = view;
    }

    @Override
    public void onCreate(CharacterViewModel character) {
        view.showInfo(character);
    }

}
