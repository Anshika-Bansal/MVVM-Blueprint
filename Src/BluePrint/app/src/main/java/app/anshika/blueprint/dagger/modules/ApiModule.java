package app.anshika.blueprint.dagger.modules;

import app.anshika.blueprint.dagger.scopes.AppScope;
import app.anshika.blueprint.networking.ApiService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
/*Created by Anshika Bansal (March 2019 )*/

/*Module class that will provide instance of variable that are related to network Api's to inject via Dagger...*/

@Module
public class ApiModule {

    @Provides
    @AppScope
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}
