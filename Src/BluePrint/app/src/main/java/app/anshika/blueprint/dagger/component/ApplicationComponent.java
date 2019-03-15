package app.anshika.blueprint.dagger.component;


import app.anshika.blueprint.dagger.modules.ApiModule;
import app.anshika.blueprint.dagger.modules.ApplicationModule;
import app.anshika.blueprint.dagger.modules.NetworkModule;
import app.anshika.blueprint.dagger.modules.ViewModelModule;
import app.anshika.blueprint.dagger.scopes.AppScope;
import dagger.Component;

import javax.inject.Singleton;
/*Created by Anshika Bansal (March 2019 )*/

/*Component class that define all the modules used by Dagger ...*/
@Singleton
@AppScope
@Component(modules = {
        ApplicationModule.class,
        ViewModelModule.class,
        ApiModule.class,
        NetworkModule.class
})
public interface ApplicationComponent extends Injector {
}
