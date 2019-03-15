package app.anshika.blueprint.dagger.modules;

import android.content.Context;

import app.anshika.blueprint.BlueprintApplication;
import dagger.Module;
import dagger.Provides;

/*Created by Anshika Bansal (March 2019 )*/

/*Module class that will provide application class object to inject via Dagger...*/
@Module
public class ApplicationModule {


    private BlueprintApplication mApplication;

    public ApplicationModule(BlueprintApplication application) {
        mApplication = application;
    }

    @Provides
    public BlueprintApplication getApplication() {
        return mApplication;
    }

    @Provides
    Context getApplicationContext() {
        return mApplication;
    }

}
