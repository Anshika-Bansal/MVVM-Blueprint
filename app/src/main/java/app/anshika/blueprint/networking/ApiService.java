package app.anshika.blueprint.networking;

import java.util.List;

import app.anshika.blueprint.models.FactsModel;
import io.reactivex.Observable;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/GetAllScienceFactJSON")
    Observable<List<FactsModel>> getFacts();


}
