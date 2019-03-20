package app.anshika.blueprint.dagger.modules;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import app.anshika.blueprint.baseui.BaseViewModelFactory;
import app.anshika.blueprint.dagger.annotations.ViewModelKey;
import app.anshika.blueprint.feature.Facts.FactsViewModel;
import app.anshika.blueprint.models.FactsModel;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/*Created by Anshika Bansal (March 2019 )*/

/*Module class that will provide view model class object to inject via Dagger...*/
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FactsViewModel.class)
    abstract ViewModel factsViewModel(FactsViewModel viewModel);


    // add more ViewModels
    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);


}
