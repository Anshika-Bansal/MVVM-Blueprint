package app.anshika.blueprint.baseui;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
/*Created by Anshika Bansal (March 2019 )*/

/*Base view model factory class used to inject instance of view model in application via Dagger..*/
public class BaseViewModelFactory implements ViewModelProvider.Factory {

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return null;
    }
}
