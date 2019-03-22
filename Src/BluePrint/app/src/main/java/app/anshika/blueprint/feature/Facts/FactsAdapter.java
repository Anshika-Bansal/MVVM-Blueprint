package app.anshika.blueprint.feature.Facts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import app.anshika.blueprint.R;
import app.anshika.blueprint.models.FactsModel;
import io.reactivex.annotations.NonNull;

public class FactsAdapter extends RecyclerView.Adapter<FactsAdapter.FactsViewHolder> {

    private List<FactsModel> mFactsList;
    private Context mContext;

    public FactsAdapter(Context context) {

        mContext = context;

    }


    @NonNull
    @Override
    public FactsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_facts, parent, false);
        return new FactsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FactsViewHolder holder, int position) {
        holder.factsDesc.setText(mFactsList.get(position).description);
    }

    @Override
    public int getItemCount() {
        return mFactsList == null ? 0 : mFactsList.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static final class FactsViewHolder extends RecyclerView.ViewHolder {

        TextView factsDesc;

        FactsViewHolder(View itemView) {
            super(itemView);

            factsDesc = itemView.findViewById(R.id.facts_desc);
        }
    }

     void updateData(List<FactsModel> list) {
        mFactsList = list;
        notifyDataSetChanged();
    }
}
