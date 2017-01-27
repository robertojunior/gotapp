package br.com.faru.gotapp.util;


import android.content.Context;
import android.content.Intent;

import br.com.faru.gotapp.model.view.CharacterViewModel;
import br.com.faru.gotapp.presentation.characters.CharacterDetailActivity;

public class Navigation {

    public static void goToCharacter(Context ctx, CharacterViewModel character) {
        Intent intent = new Intent(ctx, CharacterDetailActivity.class);
        intent.putExtra(Constants.CHARACTER, character);
        ctx.startActivity(intent);
    }


}
