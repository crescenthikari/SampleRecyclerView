package net.crescenthikari.samplerecyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_NAME = "EXTRA_NAME";
    public static final String EXTRA_ADDRESS = "EXTRA_ADDRESS";

    TextView detailName, detailAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        detailName = (TextView) findViewById(R.id.detail_name);
        detailAddress = (TextView) findViewById(R.id.detail_address);

        if (getIntent() != null) {
            if (getIntent().hasExtra(EXTRA_NAME)) {
                detailName.setText(getIntent().getStringExtra(EXTRA_NAME));
            }
            if (getIntent().hasExtra(EXTRA_ADDRESS)) {
                detailAddress.setText(getIntent().getStringExtra(EXTRA_ADDRESS));
            }
        }
    }
}
