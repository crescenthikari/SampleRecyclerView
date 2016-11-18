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
        // buat adapter untuk recylerview
        adapter = new ExampleAdapter(this);
        // setting listener ketika ada item yang diklik di recyclerview
        adapter.setListener(this);
        // setting adapter untuk recyclerview dengan adapter yang sudah dibuat
        recyclerView.setAdapter(adapter);
        // setting linearLayoutManager sebagai layout manager untuk recyclerview
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // tambahkan data dummy
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
