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

@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(FactsViewModel.class)
    abstract ViewModel scienceFactsViewModel(FactsViewModel viewModel);


    // add more ViewModels

    abstract ViewModelProvider.Factory bindViewModelFactory(BaseViewModelFactory factory);


}
