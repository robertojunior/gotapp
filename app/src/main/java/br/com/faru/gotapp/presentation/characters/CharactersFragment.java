package br.com.faru.gotapp.presentation.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.github.rahatarmanahmed.cpv.CircularProgressView;

import java.util.List;

import javax.inject.Inject;

import br.com.faru.gotapp.R;
import br.com.faru.gotapp.di.Injector;
import br.com.faru.gotapp.model.view.CharacterViewModel;
import br.com.faru.gotapp.presentation.widget.EndlessGridScrollListener;
import br.com.faru.gotapp.presentation.widget.VerticalRecyclerView;
import br.com.faru.gotapp.util.Navigation;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CharactersFragment extends Fragment implements CharactersContract.View {

    @BindView(R.id.progress_view)
    CircularProgressView progressView;

    @BindView(R.id.list_view)
    VerticalRecyclerView characterList;

    @Inject
    CharactersPresenter presenter;

    private CharactersAdapter charactersAdapter;

    OnCharacterClickListener onCharacterClickListener = this::onClick;

    public interface OnCharacterClickListener {
        void onClick(CharacterViewModel character);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_characters, container, false);
        ButterKnife.bind(this, view);

        Injector.getInstance().getComponent().inject(this);

        charactersAdapter = new CharactersAdapter(onCharacterClickListener);
        characterList.setAdapter(charactersAdapter);

        characterList.addOnScrollListener(new EndlessGridScrollListener(presenter,
                characterList.getLinearLayoutManager()));

        presenter.setView(this);
        presenter.onCreate();

        return view;
    }

    public static CharactersFragment newInstance() {
        return new CharactersFragment();
    }

    @Override
    public void showResults(List<CharacterViewModel> characters) {
        charactersAdapter.add(characters);
    }

    @Override
    public void setProgressIndicator(boolean active) {
        charactersAdapter.addLoading();
        progressView.setVisibility(active ? View.VISIBLE : View.GONE);
    }

    @Override
    public void goToCharacter(CharacterViewModel character) {
        Navigation.goToCharacter(getContext(), character);
    }

    public void onClick(CharacterViewModel character) {
        presenter.onClick(character);
    }

}
