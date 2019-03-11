package app.anshika.blueprint.repositories;

import java.util.List;

import javax.inject.Inject;

import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.ApiService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class FactsRepository {


    private ApiService mApiService;

    @Inject
    FactsRepository(ApiService apiService) {
        mApiService = apiService;
    }


    private Observable<List<FactsModel>> getFacts() {
        return mApiService.getFacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}
