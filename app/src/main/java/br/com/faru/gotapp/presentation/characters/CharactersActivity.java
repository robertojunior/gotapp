package br.com.faru.gotapp.presentation.characters;

import android.os.Bundle;
import android.support.v4.app.Fragment;

import br.com.faru.gotapp.R;
import br.com.faru.gotapp.presentation.BaseActivity;

public class CharactersActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blank);
        showCharactersFragment();
    }

    private void showCharactersFragment() {
        Fragment currentFragment = getFragmentByTag(CharacterDetailFragment.class.getCanonicalName());
        if (currentFragment == null) {
            currentFragment = CharactersFragment.newInstance();
        }

        replaceFragmentWithTag(currentFragment, R.id.container);
    }

}
