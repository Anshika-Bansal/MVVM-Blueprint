package app.anshika.blueprint.baseui;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
/*Created by Anshika Bansal (March 2019 )*/

/*Base view model class for all the view models used throughout application to share common methods...*/
public class BaseViewModel extends AndroidViewModel {

    private CompositeDisposable mCompositeSubscription;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    protected void addSubscription(DisposableObserver subscription) {
        mCompositeSubscription.add(subscription);
    }

    protected void removeSubscription(DisposableObserver subscription) {
        mCompositeSubscription.remove(subscription);
    }


    @Override
    protected void onCleared() {
        super.onCleared();
        mCompositeSubscription.clear();
    }
}
