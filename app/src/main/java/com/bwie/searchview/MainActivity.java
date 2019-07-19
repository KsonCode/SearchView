package com.bwie.searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bwie.searchview.widget.FlowLayout;
import com.bwie.searchview.widget.SearchView;

public class MainActivity extends AppCompatActivity {

    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        searchView = findViewById(R.id.searchView);
        initData();

    }

    private void initData() {
        searchView.findViewById(R.id.search_tv).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = searchView.findViewById(R.id.keyword);;
                searchView.addTextView(MainActivity.this,editText.getText().toString());

                for (int i = 0; i < searchView.getFlowLayout().getChildCount(); i++) {

                    final TextView tv = (TextView) searchView.getFlowLayout().getChildAt(i);

                    tv.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(MainActivity.this, tv.getText().toString(), Toast.LENGTH_SHORT).show();

                        }
                    });



                }
            }
        });









    }
}
