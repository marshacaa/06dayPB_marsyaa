package com.marsha.tugas5;
import android.graphics.Typeface;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemAdapter.OnItemClickListener {
    private List<Item> itemList;
    private RecyclerView recyclerView;
    private ItemAdapter itemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Inisialisasi RecyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        // Data dummy item
        itemList = new ArrayList<>();
        itemList.add(new Item("Udon Original", "Udon dengan kuah khas dan topping nori", "Rp 25.000", R.drawable.mieut, "Large", "Tepung terigu, air, nori, bawang, minyak", "Tersedia"));
        itemList.add(new Item("Udon Beef Curry", "Udon dengan kuah khas dan irisan daging sapi dengan bumbu kari", "Rp 30.000", R.drawable.spicymala, "Medium", "Tepung terigu, air, daging sapi, bumbu kari, bawang", "Tersedia"));
        itemList.add(new Item("Udon Chicken", "Udon dengan kuah khas dan potongan daging ayam", "Rp 28.000", R.drawable.mies, "Medium", "Tepung terigu, air, daging ayam, bawang, minyak", "Tersedia"));
        itemList.add(new Item("Udon Niku", "Udon dengan kuah khas dan irisan daging", "Rp 35.000", R.drawable.mies1, "Large", "Tepung terigu, air, daging sapi, bawang, minyak", "Tersedia"));
        itemList.add(new Item("Udon Vegetarian", "Udon dengan kuah khas dan pilihan sayuran segar", "Rp 25.000", R.drawable.mies2, "Medium", "Tepung terigu, air, sayuran segar, bawang, minyak", "Tersedia"));
        itemList.add(new Item("Udon Spicy Tori", "Udon dengan kuah khas dengan rasa pedas dan potongan ayam", "Rp 27.000", R.drawable.mies3, "Medium", "Tepung terigu, air, bawang, potongan ayam, saus pedas", "Tersedia"));
        itemList.add(new Item("Udon Curry Katsu", "Udon dengan kuah khas dan bumbu katsu", "Rp 30.000", R.drawable.mies4, "Large", "Tepung terigu, air, bawang, bumbu katsu", "Tersedia"));
        itemList.add(new Item("Udon Miso", "Udon dengan kuah khas dan miso Jepang", "Rp 28.000", R.drawable.mies5, "Medium", "Tepung terigu, air, bawang, miso Jepang", "Tersedia"));
        itemList.add(new Item("Udon Teriyaki", "Udon dengan kuah khas dan saus teriyaki", "Rp 32.000", R.drawable.mis6, "Large", "Tepung terigu, air, bawang, saus teriyaki", "Tersedia"));
        itemList.add(new Item("Udon Tempura", "Udon dengan kuah khas dan tempura renyah", "Rp 35.000", R.drawable.mis7, "Medium", "Tepung terigu, air, bawang, tempura", "Tersedia"));
        itemList.add(new Item("Udon Kitsune", "Udon dengan kuah khas dan tofu goreng", "Rp 28.000", R.drawable.mis9, "Medium", "Tepung terigu, air, bawang, tofu goreng", "Tersedia"));
        itemList.add(new Item("Udon Tori", "Udon dengan kuah khas dan potongan ayam", "Rp 28.000", R.drawable.udonmiso, "Medium", "Tepung terigu, air, bawang, potongan ayam", "Tersedia"));
        itemList.add(new Item("Udon Yasai", "Udon dengan kuah khas dan beragam sayuran", "Rp 25.000", R.drawable.mis8, "Large", "Tepung terigu, air, bawang, sayuran segar", "Tersedia"));
        itemList.add(new Item("Udon Carbonara", "Udon dengan kuah khas dan saus carbonara", "Rp 30.000", R.drawable.mis10, "Large", "Tepung terigu, air, bawang, saus carbonara", "Tersedia"));
        itemList.add(new Item("Udon Ontama", "Udon dengan kuah khas dan telur mata sapi", "Rp 30.000", R.drawable.mieut, "Large", "Tepung terigu, air, bawang, telur mata sapi", "Tersedia"));

        // Inisialisasi dan set adapter RecyclerView
        itemAdapter = new ItemAdapter(this, itemList);
        recyclerView.setAdapter(itemAdapter);
        itemAdapter.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(int position) {
        // Handle item click, navigate to detail activity
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("item", itemList.get(position));
        startActivity(intent);
    }
}
