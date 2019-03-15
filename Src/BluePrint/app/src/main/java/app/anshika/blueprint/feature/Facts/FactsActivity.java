package app.anshika.blueprint.feature.Facts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import app.anshika.blueprint.BlueprintApplication;
import app.anshika.blueprint.R;
import app.anshika.blueprint.baseui.BaseActivity;
import app.anshika.blueprint.baseui.BaseViewModelFactory;

import android.os.Bundle;
/*Created by Anshika Bansal (March 2019 )*/

/*This is a activity where all the Facts will display... */
public class FactsActivity extends BaseActivity {

    private FactsViewModel mFactsViewModel;
    //private BaseViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewDataBinding mBinding = DataBindingUtil.setContentView(this, R.layout.activity_facts);
        BlueprintApplication.getApp().getDaggerAppComponent().provideIn(this);

        //   mFactsViewModel = ViewModelProviders.of(this, mViewModelFactory).get(FactsViewModel.class);
    }
}
