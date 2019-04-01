package app.anshika.blueprint.baseui;

import android.app.Application;

import androidx.annotation.NonNull;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;

public class BaseRepository {


    private CompositeDisposable mCompositeSubscription = new CompositeDisposable();


    protected void addSubscription(DisposableObserver subscription) {
        mCompositeSubscription.add(subscription);
    }

    protected void removeSubscription(DisposableObserver subscription) {
        mCompositeSubscription.remove(subscription);
    }


    public void clearSubscription() {
        mCompositeSubscription.clear();
    }
}
