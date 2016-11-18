package net.crescenthikari.samplerecyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import net.crescenthikari.samplerecyclerview.adapter.ExampleAdapter;
import net.crescenthikari.samplerecyclerview.model.Example;

public class MainActivity extends AppCompatActivity implements ExampleAdapter.SeeDetailListener {

    RecyclerView recyclerView;
    ExampleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        adapter = new ExampleAdapter(this);
        adapter.setListener(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter.addExample(new Example("Test1", "test 123"));
        adapter.addExample(new Example("Test2", "test 123"));
        adapter.addExample(new Example("Test3", "test 123"));
    }

    @Override
    public void onClick(Example data) {
        Intent detailIntent = new Intent(this, DetailActivity.class);
        detailIntent.putExtra(DetailActivity.EXTRA_NAME, data.name);
        detailIntent.putExtra(DetailActivity.EXTRA_ADDRESS, data.address);
        startActivity(detailIntent);
    }
}
