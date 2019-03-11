package app.anshika.blueprint.dagger.modules;

import app.anshika.blueprint.dagger.scopes.AppScope;
import app.anshika.blueprint.networking.ApiService;
import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class ApiModule {

    @Provides
    @AppScope
    public ApiService provideApiService(Retrofit retrofit) {
        return retrofit.create(ApiService.class);
    }


}
