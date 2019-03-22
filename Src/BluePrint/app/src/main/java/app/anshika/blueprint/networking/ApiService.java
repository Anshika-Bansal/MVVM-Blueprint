package app.anshika.blueprint.networking;

import java.util.ArrayList;
import java.util.List;

import app.anshika.blueprint.models.FactsModel;
import io.reactivex.Observable;
import retrofit2.http.GET;

/*Created by Anshika Bansal (March 2019 )*/

/*This is the service interface in which all the method define which will used for data...*/
public interface ApiService {

    @GET("/GetAllScienceFactJSON")
    Observable<ArrayList<FactsModel>> getFacts();


}
