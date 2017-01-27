package br.com.faru.gotapp.presentation.characters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import br.com.faru.gotapp.client.GOTApi;

import static org.mockito.Matchers.anyList;
import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;

/**
 * Created by faru on 27/01/17.
 */

@RunWith(MockitoJUnitRunner.class)
public class CharactersPresenterTest {

    @Mock
    GOTApi gotAPI;

    @Mock
    CharactersContract.View viewMock;

    private CharactersPresenter charactersPresenter;

    @Before
    public void setup() {
        charactersPresenter = new CharactersPresenter(gotAPI);
        charactersPresenter.setView(viewMock);
    }

    @Test
    public void shouldShowProgressOnCreate() {
        charactersPresenter.onCreate();
        verify(viewMock).setProgressIndicator(true);
    }

    @Test
    public void shouldGoToCharacterOnClick() {
        charactersPresenter.onClick(anyObject());
        verify(viewMock).goToCharacter(anyObject());
    }

    @Test
    public void shouldHideProgressOnGetCharactersSuccess() {
        charactersPresenter.onGetCharactersSuccess(anyList());
        verify(viewMock).setProgressIndicator(false);
    }

    @Test
    public void shouldShowResultsOnGetCharactersSuccess() {
        charactersPresenter.onGetCharactersSuccess(anyList());
        verify(viewMock).showResults(anyList());
    }

    @Test
    public void shouldHideProgressOnGetCharactersFailure() {
        charactersPresenter.onGetCharactersSuccess(anyList());
        verify(viewMock).setProgressIndicator(false);
    }
    
}
