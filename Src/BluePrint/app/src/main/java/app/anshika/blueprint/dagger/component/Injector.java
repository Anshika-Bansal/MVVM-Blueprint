package app.anshika.blueprint.dagger.component;

import app.anshika.blueprint.feature.Facts.FactsActivity;
/*Created by Anshika Bansal (March 2019 )*/

/*Interface here Dagger find out the component type in that dagger have to inject dependencies... */

interface Injector {

    void provideIn(FactsActivity activity);

}
