package app.anshika.blueprint.feature.Facts;

import android.app.Application;

import com.hadilq.liveevent.LiveEvent;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;
import app.anshika.blueprint.baseui.BaseViewModel;
import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.BaseNetworkSubscriber;
import app.anshika.blueprint.repositories.FactsRepository;
/*Created by Anshika Bansal (March 2019 )*/

/*This is a view model class where we store the object(Facts) related data. */

public class FactsViewModel extends BaseViewModel {


    private FactsRepository mFactsRepository;
    private MutableLiveData<List<FactsModel>> mFactsLiveData;
    private LiveEvent<String> mFactsLiveEvent;
    private LiveEvent<String> mTempEventData;


    @Inject
    public FactsViewModel(@NonNull Application application, FactsRepository repository) {
        super(application);
        mFactsRepository = repository;
    }

    private LiveEvent<String> getTempEventData() {
        return mTempEventData;
    }


    private MutableLiveData<List<FactsModel>> getFactsLiveData() {
        return mFactsLiveData;
    }

    private LiveEvent<String> getFactsEventData() {
        return mFactsLiveEvent;
    }

    private void loadFacts() {
        addSubscription(
                mFactsRepository.getFacts().subscribeWith(new BaseNetworkSubscriber<List<FactsModel>>(getApplication()) {
                    @Override
                    public void onNext(List<FactsModel> factsModels) {
                        super.onNext(factsModels);
                    }

                    @Override
                    public void onComplete() {
                        super.onComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        super.onError(e);
                    }
                }));
    }


}
