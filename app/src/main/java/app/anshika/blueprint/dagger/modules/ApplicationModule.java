package app.anshika.blueprint.dagger.modules;

import android.content.Context;

import app.anshika.blueprint.BlueprintApplication;
import dagger.Module;
import dagger.Provides;

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
