package br.com.faru.gotapp.presentation.characters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.faru.gotapp.R;
import br.com.faru.gotapp.model.view.CharacterViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static br.com.faru.gotapp.R.id.character;

public class CharactersAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<CharacterViewModel> characterList;
    private CharactersFragment.OnCharacterClickListener onClickListener;

    private static final int LOADING = -1;

    public CharactersAdapter(CharactersFragment.OnCharacterClickListener onClickListener) {
        this.characterList = new ArrayList<>();
        this.onClickListener = onClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        if (characterList != null
                && !characterList.isEmpty()
                && characterList.get(position) == null) {
            return LOADING;
        }

        return super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case LOADING:
                return new LoadingViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.cell_loading, parent, false));
            default:
                return new ViewHolder(LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_character, parent, false), onClickListener);
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof ViewHolder) {
            ViewHolder viewHolder = (ViewHolder) holder;
            CharacterViewModel character = characterList.get(position);
            viewHolder.name.setText(character.getDisplayName());
        }
    }

    public void add(List<CharacterViewModel> characterList) {
        removeLoading();
        this.characterList.addAll(characterList);
        notifyDataSetChanged();
    }

    void addLoading() {
        if (characterList != null && !characterList.isEmpty()) {
            characterList.add(null);
            notifyDataSetChanged();
        }
    }

    private void removeLoading() {
        int lastOne = characterList.size() - 1;
        if (!characterList.isEmpty() && characterList.get(lastOne) == null) {
            characterList.remove(lastOne);
        }
    }

    @Override
    public int getItemCount() {
        return characterList == null ? 0 : characterList.size();
    }

    public CharacterViewModel getItem(int position) {
        return characterList.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.name)
        public TextView name;

        private CharactersFragment.OnCharacterClickListener categoryClickListener;

        public ViewHolder(View itemView, CharactersFragment.OnCharacterClickListener categoryClickListener) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            this.categoryClickListener = categoryClickListener;
        }

        @OnClick(character)
        public void onClick() {
            categoryClickListener.onClick(getItem(getAdapterPosition()));
        }

    }

    private class LoadingViewHolder extends RecyclerView.ViewHolder {
        LoadingViewHolder(View view) {
            super(view);
        }
    }

}
