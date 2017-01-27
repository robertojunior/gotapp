package br.com.faru.gotapp.presentation.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import br.com.faru.gotapp.R;
import br.com.faru.gotapp.model.view.CharacterViewModel;
import br.com.faru.gotapp.presentation.BaseActivity;
import br.com.faru.gotapp.util.Constants;
import butterknife.ButterKnife;

public class CharacterDetailActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_blank);
        ButterKnife.bind(this);

        if (getIntent().getExtras().containsKey(Constants.CHARACTER)) {
            CharacterViewModel character = getIntent().getExtras().getParcelable(Constants.CHARACTER);
            initToolbar(character);
            showCharacterFragment(character);
        } else {
            throw new IllegalArgumentException("Bundle must contains a \"character\" key");
        }
    }

    private void showCharacterFragment(CharacterViewModel character) {
        Fragment currentFragment = getFragmentByTag(CharacterDetailFragment.class.getCanonicalName());
        if (currentFragment == null) {
            currentFragment = CharacterDetailFragment.newInstance(character);
        }

        replaceFragmentWithTag(currentFragment, R.id.container);
    }

    private void initToolbar(CharacterViewModel character) {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(character.getDisplayName());
            getSupportActionBar().setDisplayShowTitleEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }

}
