package app.anshika.blueprint.feature.Facts;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import app.anshika.blueprint.BlueprintApplication;
import app.anshika.blueprint.R;
import app.anshika.blueprint.permissions.AbstractPermissionActivity;
import app.anshika.blueprint.permissions.PermissionUtils;
import app.anshika.blueprint.baseui.BaseViewModelFactory;
import app.anshika.blueprint.databinding.ActivityFactsBinding;
import app.anshika.blueprint.models.FactsModel;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;


/*Created by Anshika Bansal (March 2019 )*/

/*This is a activity where all the Facts will display... */
public class FactsActivity extends AbstractPermissionActivity {

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
        mFactsViewModel.fetchFacts();


    }


    /*Method to setup attribute for recycler view...*/
    private void setUpRecyclerView() {
        mAdapter = new FactsAdapter(this);
        mBinding.factsRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mBinding.factsRecyclerView.setAdapter(mAdapter);
        mBinding.requestPermission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestLocationPermission();
            }
        });
    }

    /*Method to observe facts data change...*/
    private void observeFacts() {
        if (mFactsViewModel.getFactsLiveData() != null)
            mFactsViewModel.getFactsLiveData().observe(this, dataStatus -> {
                System.out.println("Data Status:: " + dataStatus.mStatus);
                handleStates(dataStatus);

            });
    }


    /*Method used to handle the data states and update UI accordingly...*/
    private void handleStates(FactsDataStatus<List<FactsModel>> data) {
        switch (data.mStatus) {
            case INPROGRESS:
                break;
            case COMPLETE:
                if (data.mData != null)
                    mAdapter.updateData(data.mData);
                break;

            case APIERROR:

                break;
        }
    }

    @Override
    public View getLayoutRootView() {
        return findViewById(R.id.root_view);
    }

    public void requestLocationPermission() {
        String[] permissionSet = {PermissionUtils.ACCESS_COARSE_LOCATION,
                PermissionUtils.ACCESS_FINE_LOCATION, PermissionUtils.CAMERA};
        requestEach(new ArrayList<>(Arrays.asList(permissionSet)), permissionResult -> {
            if (permissionResult.isPermissionGranted) {
                Toast.makeText(FactsActivity.this, "Permission granted", Toast.LENGTH_SHORT).show();

            } else if (permissionResult.isPermissionDenied) {
                Toast.makeText(FactsActivity.this, "Permission denied", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
