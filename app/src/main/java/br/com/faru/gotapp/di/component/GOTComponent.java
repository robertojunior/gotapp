package br.com.faru.gotapp.di.component;

import br.com.faru.gotapp.di.scope.ActivityScope;
import br.com.faru.gotapp.presentation.characters.CharacterDetailFragment;
import br.com.faru.gotapp.presentation.characters.CharactersFragment;
import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class)
public interface GOTComponent {

    void inject(CharactersFragment charactersFragment);

    void inject(CharacterDetailFragment characterDetailFragment);
}
