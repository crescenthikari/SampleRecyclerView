package net.crescenthikari.samplerecyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import net.crescenthikari.samplerecyclerview.R;
import net.crescenthikari.samplerecyclerview.model.Example;

import java.util.ArrayList;
import java.util.List;

import static android.support.v7.widget.RecyclerView.NO_POSITION;

/**
 * Created by Muhammad Fiqri Muthohar on 11/18/16.
 */

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ViewHolder> {

    private List<Example> examples;
    private LayoutInflater inflater;
    private SeeDetailListener listener;

    public ExampleAdapter(final Context context) {
        this(context, new ArrayList<Example>());
    }

    public ExampleAdapter(final Context context, List<Example> data) {
        inflater = LayoutInflater.from(context);
        examples = data;
    }

    public void addExample(Example data) {
        examples.add(data);
        notifyItemInserted(examples.size() - 1);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ViewHolder myHolder = new ViewHolder(inflater.inflate(R.layout.list_item_layout, parent, false));
        myHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = myHolder.getAdapterPosition();
                if (pos != NO_POSITION && listener != null) {
                    listener.onClick(examples.get(pos));
                }
            }
        });
        return myHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Example data = examples.get(position);
        holder.name.setText(data.name);
        holder.address.setText(data.address);
    }

    @Override
    public int getItemCount() {
        return examples.size();
    }

    public void setListener(SeeDetailListener listener) {
        this.listener = listener;
    }

    public interface SeeDetailListener {
        void onClick(Example data);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, address;

        ViewHolder(View itemView) {
            super(itemView);
            name = (TextView) itemView.findViewById(R.id.name);
            address = (TextView) itemView.findViewById(R.id.address);
        }
    }
}
