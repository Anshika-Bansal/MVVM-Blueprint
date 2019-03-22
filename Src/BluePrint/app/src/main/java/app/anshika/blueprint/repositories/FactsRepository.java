package app.anshika.blueprint.repositories;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.MutableLiveData;
import app.anshika.blueprint.DataBase.DataBaseHelper;
import app.anshika.blueprint.feature.Facts.FactsDao;
import app.anshika.blueprint.feature.Facts.FactsViewModel;
import app.anshika.blueprint.models.FactsModel;
import app.anshika.blueprint.networking.ApiService;
import app.anshika.blueprint.networking.BaseNetworkSubscriber;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
/*Created by Anshika Bansal (March 2019 )*/

/*This class is responsible for processing(fetch and save) of facts data used in application...*/
public class FactsRepository {


    private ApiService mApiService;
    private Application mApplication;
    private MutableLiveData<List<FactsModel>> mFactsLiveData = new MutableLiveData<>();

    @Inject
    FactsRepository(ApiService apiService, Application application) {
        mApiService = apiService;
        mApplication = application;
    }


    public Observable<ArrayList<FactsModel>> getFactsFromServer() {
        return mApiService.getFacts().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }

    public void saveFact(ArrayList<FactsModel> list) {
        if (list == null)
            return;
        new FactsInsertAsyncTask(mApplication, list).execute();


    }


    public void loadFactsFromDb() {
        new FactsGetAsyncTask(mApplication).execute();


    }

    public class FactsInsertAsyncTask extends AsyncTask<Void, Void, Void> {

        private Application context;
        private List<FactsModel> list;


        public FactsInsertAsyncTask(Application context, List<FactsModel> list) {
            this.context = context;
            this.list = list;
        }

        @Override
        protected Void doInBackground(Void... params) {
            FactsDao factsDao = DataBaseHelper.getDataBase(context).factsDao();
            for (int i = 0; i < list.size(); i++) {
                factsDao.insertAll(list.get(i));
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            loadFactsFromDb();
        }
    }

    public class FactsGetAsyncTask extends AsyncTask<Void, Void, List<FactsModel>> {

        private Application context;

        public FactsGetAsyncTask(Application context) {
            this.context = context;

        }

        @Override
        protected List<FactsModel> doInBackground(Void... params) {
            FactsDao factsDao = DataBaseHelper.getDataBase(context).factsDao();

            return factsDao.getAll();
        }

        @Override
        protected void onPostExecute(List<FactsModel> list) {
            super.onPostExecute(list);
            mFactsLiveData.setValue(list);
        }
    }

    public MutableLiveData<List<FactsModel>> getFactsLiveData() {
        return mFactsLiveData;
    }
}
