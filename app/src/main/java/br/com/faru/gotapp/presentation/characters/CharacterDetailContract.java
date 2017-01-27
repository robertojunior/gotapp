package br.com.faru.gotapp.presentation.characters;

import br.com.faru.gotapp.model.view.CharacterViewModel;

public interface CharacterDetailContract {

    interface View {

        void showInfo(CharacterViewModel character);

    }

    interface UserInteractions {

        void setView(CharacterDetailContract.View view);

        void onCreate(CharacterViewModel character);

    }

}
