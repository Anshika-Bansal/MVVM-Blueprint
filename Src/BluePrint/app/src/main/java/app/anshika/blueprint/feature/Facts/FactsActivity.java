package app.anshika.blueprint.feature.Facts;

import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;
import app.anshika.blueprint.BlueprintApplication;
import app.anshika.blueprint.R;
import app.anshika.blueprint.baseui.BaseActivity;
import app.anshika.blueprint.baseui.BaseViewModelFactory;


import android.app.Application;
import android.os.Bundle;

import java.util.ArrayList;

import javax.inject.Inject;
/*Created by Anshika Bansal (March 2019 )*/

/*This is a activity where all the Facts will display... */
public class FactsActivity extends BaseActivity {

    private FactsViewModel mFactsViewModel;

    private FactsAdapter mAdapter;
    private RecyclerView mRecyclerView;
    // private ActivityFactsBinding mBinding;

    @Inject
    public BaseViewModelFactory mViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BlueprintApplication.getApp().getDaggerAppComponent().provideIn(this);
        mFactsViewModel = ViewModelProviders.of(this, mViewModelFactory).get(FactsViewModel.class);
        //mBinding = DataBindingUtil.setContentView(this, R.layout.activity_facts);
        setUpRecyclerView();
        observeFacts();
        observeScreenState();

        mFactsViewModel.loadFacts();
    }


    private void setUpRecyclerView() {
        mAdapter = new FactsAdapter(this);
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void observeFacts() {

        mFactsViewModel.getFactsLiveData().observe(this, list -> {

            mAdapter.updateData(list);

        });
    }

    private void observeScreenState() {

    }
}
