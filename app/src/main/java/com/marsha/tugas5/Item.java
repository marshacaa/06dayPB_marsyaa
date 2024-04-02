package com.marsha.tugas5;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    private String name;
    private String description;
    private String price;
    private int imageResourceId; // Menggunakan ID resource untuk gambar
    private String size;
    private String ingredients;
    private String availability;

    public Item(String name, String description, String price, int imageResourceId, String size, String ingredients, String availability) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageResourceId = imageResourceId;
        this.size = size;
        this.ingredients = ingredients;
        this.availability = availability;
    }

    protected Item(Parcel in) {
        name = in.readString();
        description = in.readString();
        price = in.readString();
        imageResourceId = in.readInt();
        size = in.readString();
        ingredients = in.readString();
        availability = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getPrice() {
        return price;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(description);
        dest.writeString(price);
        dest.writeInt(imageResourceId);
        dest.writeString(size);
        dest.writeString(ingredients);
        dest.writeString(availability);
    }
}
