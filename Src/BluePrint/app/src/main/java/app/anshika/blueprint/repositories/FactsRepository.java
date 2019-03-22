package app.anshika.blueprint.repositories;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.ApiService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/*Created by Anshika Bansal (March 2019 )*/

/*This class is responsible for processing(fetch and save) of facts data used in application...*/
public class FactsRepository {


    private ApiService mApiService;

    @Inject
    FactsRepository(ApiService apiService) {
        mApiService = apiService;
    }


    public Observable<ArrayList<FactsModel>> getFacts() {
        return mApiService.getFacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
