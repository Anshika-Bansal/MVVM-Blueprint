package app.anshika.blueprint.feature.Facts;

import android.app.Application;

import com.hadilq.liveevent.LiveEvent;

import java.util.ArrayList;
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
    private MutableLiveData<ArrayList<FactsModel>> mFactsLiveData = new MutableLiveData<>();


    @Inject
    public FactsViewModel(@NonNull Application application, FactsRepository repository) {
        super(application);
        mFactsRepository = repository;
    }


    public MutableLiveData<ArrayList<FactsModel>> getFactsLiveData() {
        return mFactsLiveData;
    }


    public void loadFacts() {
        addSubscription(
                mFactsRepository.getFacts()
                        .subscribeWith(new BaseNetworkSubscriber<ArrayList<FactsModel>>(getApplication()) {
                            @Override
                            public void onNext(ArrayList<FactsModel> factsModels) {
                                super.onNext(factsModels);
                                mFactsLiveData.setValue(factsModels);
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
