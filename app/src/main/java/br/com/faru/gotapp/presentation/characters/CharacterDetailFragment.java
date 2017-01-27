package br.com.faru.gotapp.presentation.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.inject.Inject;

import br.com.faru.gotapp.R;
import br.com.faru.gotapp.di.Injector;
import br.com.faru.gotapp.model.view.CharacterViewModel;
import br.com.faru.gotapp.util.Constants;
import butterknife.BindView;
import butterknife.ButterKnife;

public class CharacterDetailFragment extends Fragment implements CharacterDetailContract.View {

    @BindView(R.id.name)
    TextView name;

    @BindView(R.id.gender)
    TextView gender;

    @BindView(R.id.culture)
    TextView culture;

    @BindView(R.id.born)
    TextView born;

    @BindView(R.id.died)
    TextView died;

    @BindView(R.id.titles)
    TextView titles;

    @BindView(R.id.aliases)
    TextView aliases;

    @Inject
    CharacterDetailPresenter presenter;

    private CharacterViewModel character;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_character_detail, container, false);
        ButterKnife.bind(this, view);

        Injector.getInstance().getComponent().inject(this);

        if (getArguments().containsKey(Constants.CHARACTER)) {
            character = getArguments().getParcelable(Constants.CHARACTER);
        }

        presenter.setView(this);
        presenter.onCreate(character);

        return view;
    }

    public static CharacterDetailFragment newInstance(CharacterViewModel character) {
        CharacterDetailFragment fragment = new CharacterDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(Constants.CHARACTER, character);
        fragment.setArguments(bundle);

        return fragment;
    }


    @Override
    public void showInfo(CharacterViewModel character) {
        name.setText(character.getName());
        gender.setText(character.getGender());
        culture.setText(character.getCulture());
        born.setText(character.getBorn());
        died.setText(character.getDied());
        titles.setText(character.getTitles());
        aliases.setText(character.getAliases());
    }

}
