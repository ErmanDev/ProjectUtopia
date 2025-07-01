package com.example.projectutopia;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projectutopia.adapter.InfoAdapter;
import com.example.projectutopia.data.InfoRepository;
import com.example.projectutopia.model.CategoryItem;

import java.util.List;

public class InfoActivity extends AppCompatActivity {

    private TextView titleText;
    private RecyclerView recyclerView;
    private InfoAdapter adapter;
    private List<CategoryItem> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);  // Make sure this layout exists

        titleText = findViewById(R.id.titleText);
        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String category = getIntent().getStringExtra("category");
        titleText.setText(category);  // e.g., "HOSPITAL"

        dataList = InfoRepository.getInfoByCategory(category);
        adapter = new InfoAdapter(dataList);
        recyclerView.setAdapter(adapter);
    }
}
