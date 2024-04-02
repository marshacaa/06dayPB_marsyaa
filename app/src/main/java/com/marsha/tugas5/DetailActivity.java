package com.marsha.tugas5;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private ImageView itemImage;
    private TextView itemName, itemDescription, itemPrice, itemSize, itemIngredients, itemAvailability;
    private Button shareButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // Inisialisasi views
        itemImage = findViewById(R.id.itemImage);
        itemName = findViewById(R.id.itemName);
        itemDescription = findViewById(R.id.itemDescription);
        itemPrice = findViewById(R.id.itemPrice);
        itemSize = findViewById(R.id.itemSize);
        itemIngredients = findViewById(R.id.itemIngredients);
        itemAvailability = findViewById(R.id.itemAvailability);
        shareButton = findViewById(R.id.shareButton);

        // Mendapatkan data item dari intent
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("item")) {
            Item item = intent.getParcelableExtra("item");
            if (item != null) {
                // Tampilkan informasi item di views
                Glide.with(this)
                        .load(item.getImageResourceId()) // Menggunakan getImageResourceId() untuk mengambil ID resource gambar
                        .into(itemImage);
                itemName.setText(item.getName());
                itemDescription.setText(item.getDescription());
                itemPrice.setText(item.getPrice());
                itemSize.setText("Size: " + item.getSize());
                itemIngredients.setText("Ingredients: " + item.getIngredients());
                itemAvailability.setText("Availability: " + item.getAvailability());
            }
        }

        // Handle klik tombol share
        shareButton.setOnClickListener(v -> {
            if (intent != null && intent.hasExtra("item")) {
                Item item = intent.getParcelableExtra("item");
                if (item != null) {
                    String shareText = "Pesanan Anda adalah : " + item.getName()
                            + "\nDescription: " + item.getDescription()
                            + "\nPrice: " + item.getPrice()
                            + "\nSize: " + item.getSize()
                            + "\nIngredients: " + item.getIngredients()
                            + "\nAvailability: " + item.getAvailability();
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareText);
                    startActivity(Intent.createChooser(shareIntent, "Share via"));
                }
            }
        });
    }
}
