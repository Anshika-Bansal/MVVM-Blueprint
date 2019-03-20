package app.anshika.blueprint;

import android.app.Application;

import app.anshika.blueprint.dagger.component.ApplicationComponent;
import app.anshika.blueprint.dagger.modules.ApplicationModule;

 /*Created by Anshika Bansal (March 2019 )*/

/*This is a application class where we can setup basic components like Dagger,Image loader ets.*/

public class BlueprintApplication extends Application {

    private static BlueprintApplication mainApplication;
    private ApplicationComponent mAppComponent;

    public static BlueprintApplication getApp() {

        return mainApplication;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        mainApplication = this;
        System.setProperty("http.keepAlive", "false");
        setUpDagger();

    }

    /**
     * Method used to setUp dagger
     */

    private void setUpDagger() {
        mAppComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    /* *
     * Method used to get DaggerAppComponent instance to get required injection
     *
     * @return AppComponent
     */
    public ApplicationComponent getDaggerAppComponent() {
        return mAppComponent;
    }

}
