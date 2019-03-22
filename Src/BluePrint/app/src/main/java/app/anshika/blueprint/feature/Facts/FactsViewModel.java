package app.anshika.blueprint.feature.Facts;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;

import com.hadilq.liveevent.LiveEvent;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import app.anshika.blueprint.AppUtils.BaseUtils;
import app.anshika.blueprint.DataBase.DataBaseHelper;
import app.anshika.blueprint.baseui.BaseViewModel;
import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.BaseNetworkSubscriber;
import app.anshika.blueprint.networking.Resource;
import app.anshika.blueprint.repositories.FactsRepository;
/*Created by Anshika Bansal (March 2019 )*/

/*This is a view model class where we store the object(Facts) related data. */

public class FactsViewModel extends BaseViewModel {


    private FactsRepository mFactsRepository;
    private Application mContext;


    @Inject
    FactsViewModel(@NonNull Application application, FactsRepository repository) {
        super(application);
        mFactsRepository = repository;
        mContext = application;
    }


    MutableLiveData<List<FactsModel>> getFactsLiveData() {
        return mFactsRepository.getFactsLiveData();
    }


    void refreshFacts() {
        if (BaseUtils.checkNetwork(mContext)) {
            loadFacts();
        } else
            mFactsRepository.loadFactsFromDb();
    }


    private void loadFacts() {
        addSubscription(
                mFactsRepository.getFactsFromServer()
                        .subscribeWith(new BaseNetworkSubscriber<ArrayList<FactsModel>>(getApplication()) {
                            @Override
                            public void onNext(ArrayList<FactsModel> factsModels) {
                                super.onNext(factsModels);
                                mFactsRepository.saveFact(factsModels);
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
