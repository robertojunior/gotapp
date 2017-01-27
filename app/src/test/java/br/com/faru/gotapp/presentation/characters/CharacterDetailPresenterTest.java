package br.com.faru.gotapp.presentation.characters;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Matchers.anyObject;
import static org.mockito.Mockito.verify;

/**
 * Created by faru on 27/01/17.
 */
@RunWith(MockitoJUnitRunner.class)
public class CharacterDetailPresenterTest {

    @Mock
    CharacterDetailContract.View viewMock;

    private CharacterDetailPresenter presenter;

    @Before
    public void setup() {
        presenter = new CharacterDetailPresenter();
        presenter.setView(viewMock);
    }

    @Test
    public void shouldShowInfoOnCreate() {
        presenter.onCreate(anyObject());
        verify(viewMock).showInfo(anyObject());
    }

}
