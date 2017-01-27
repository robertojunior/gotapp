package br.com.faru.gotapp.presentation.widget;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class EndlessGridScrollListener extends RecyclerView.OnScrollListener {

    private static final int VISIBLE_THRESHOLD = 3;

    private final OnEndlessGridScrollListener onEndlessGridScrollListener;
    private final LinearLayoutManager linearLayoutManager;

    private int previousTotal;
    private boolean loading = true;

    public EndlessGridScrollListener(OnEndlessGridScrollListener onEndlessGridScrollListener,
                                     LinearLayoutManager linearLayoutManager) {
        this.onEndlessGridScrollListener = onEndlessGridScrollListener;
        this.linearLayoutManager = linearLayoutManager;
    }

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);

        if (shouldLoadMoreItems(linearLayoutManager.findLastCompletelyVisibleItemPosition(),
                linearLayoutManager.getItemCount())) {
            loading = true;
            onEndlessGridScrollListener.loadMoreIfItIsPossible();
            previousTotal = linearLayoutManager.getItemCount();
        } else if (linearLayoutManager.getItemCount() > previousTotal) {
            loading = false;
        }
    }

    private boolean shouldLoadMoreItems(int lastCompletelyVisibleItemPosition, int itemCount) {
        return !loading && lastCompletelyVisibleItemPosition == itemCount - VISIBLE_THRESHOLD;
    }

    public interface OnEndlessGridScrollListener {
        void loadMoreIfItIsPossible();

        boolean isDownloading();
    }
}
