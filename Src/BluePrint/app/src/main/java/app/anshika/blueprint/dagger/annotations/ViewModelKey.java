package app.anshika.blueprint.dagger.annotations;

import androidx.lifecycle.ViewModel;
import dagger.MapKey;

import java.lang.annotation.*;
/*Created by Anshika Bansal (March 2019 )*/

@Documented
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@MapKey
public @interface ViewModelKey {
    Class<? extends ViewModel> value();
}
