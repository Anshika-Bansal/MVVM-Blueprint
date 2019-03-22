package app.anshika.blueprint.feature.Facts;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import app.anshika.blueprint.BlueprintApplication;
import app.anshika.blueprint.R;
import app.anshika.blueprint.baseui.BaseActivity;
import app.anshika.blueprint.baseui.BaseViewModelFactory;
import app.anshika.blueprint.databinding.ActivityFactsBinding;

import android.os.Bundle;

import javax.inject.Inject;


/*Created by Anshika Bansal (March 2019 )*/

/*This is a activity where all the Facts will display... */
public class FactsActivity extends BaseActivity {

    private FactsViewModel mFactsViewModel;
    private FactsAdapter mAdapter;
    private ActivityFactsBinding mBinding;

    @Inject
    public BaseViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_facts);

        BlueprintApplication.getApp().getDaggerAppComponent().provideIn(this);
        mFactsViewModel = ViewModelProviders.of(this, mViewModelFactory).get(FactsViewModel.class);


        setUpRecyclerView();
        observeFacts();
        observeScreenState();

        mFactsViewModel.loadFacts();
    }


    /*Method to setup attribute for recycler view...*/
    private void setUpRecyclerView() {
        mAdapter = new FactsAdapter(this);
        mBinding.factsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.factsRecyclerView.setAdapter(mAdapter);
    }

    /*Method to observe facts data change...*/
    private void observeFacts() {
        if (mFactsViewModel.getFactsLiveData() != null)

            mFactsViewModel.getFactsLiveData().observe(this, list -> {

                mAdapter.updateData(list);

            });
    }

    private void observeScreenState() {

    }
}
