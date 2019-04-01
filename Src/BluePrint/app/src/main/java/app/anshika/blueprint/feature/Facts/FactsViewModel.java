package app.anshika.blueprint.feature.Facts;

import android.app.Application;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import app.anshika.blueprint.apputils.BaseUtils;
import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.Resource;
import app.anshika.blueprint.repositories.FactsRepository;
/*Created by Anshika Bansal (March 2019 )*/

/*This is a view model class where we store the object(Facts) related data. */

public class FactsViewModel extends AndroidViewModel {


    private FactsRepository mFactsRepository;
    private Application mContext;

    private MediatorLiveData<FactsDataStatus<List<FactsModel>>> mFactsMediatorData = new MediatorLiveData<>();

    @Inject
    FactsViewModel(@NonNull Application application, FactsRepository repository) {
        super(application);
        mFactsRepository = repository;
        mContext = application;
        observeFactsData();
    }


    private void observeFactsData() {
        mFactsMediatorData.addSource(mFactsRepository.getFactsLiveData(), new Observer<Resource<List<FactsModel>>>() {
            @Override
            public void onChanged(Resource<List<FactsModel>> listResource) {

                switch (listResource.mStatus) {
                    case LOADING:
                        Toast.makeText(mContext, "LOADING", Toast.LENGTH_SHORT).show();
                        break;

                    case SUCCESS:
                        Toast.makeText(mContext, "SUCCESS", Toast.LENGTH_SHORT).show();
                        mFactsMediatorData.setValue(FactsDataStatus.success(listResource.mData));
                        break;

                    case ERROR:
                        Toast.makeText(mContext, "ERROR", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });

    }

    MutableLiveData<FactsDataStatus<List<FactsModel>>> getFactsLiveData() {
        return mFactsMediatorData;
    }


    void fetchFacts() {

        if (BaseUtils.checkNetwork(mContext))
            mFactsRepository.loadFactsFromNetwork();
        else
            mFactsRepository.loadFactsFromDb();
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        mFactsRepository.clearSubscription();

    }
}
