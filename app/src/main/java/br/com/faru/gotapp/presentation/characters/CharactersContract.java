package br.com.faru.gotapp.presentation.characters;

import java.util.List;

import br.com.faru.gotapp.model.view.CharacterViewModel;

public interface CharactersContract {

    interface View {

        void showResults(List<CharacterViewModel> characters);

        void setProgressIndicator(boolean active);

        void goToCharacter(CharacterViewModel character);

    }

    interface UserInteractions {

        void setView(View view);

        void onCreate();

        void onClick(CharacterViewModel character);
    }

}
