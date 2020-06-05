package com.example.androisdashboardwithrecylerview.Models;

import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;

public class DashBoardModel {
    String Title;
    @DrawableRes
    int Image_path;
    @ColorRes
    private int color;

    public void setTitle(String title) {
        Title = title;
    }

    public void setImage_path(int image_path) {
        Image_path = image_path;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public DashBoardModel(String title, int image_path, int color) {
        Title = title;
        Image_path = image_path;
        this.color=color;
    }

    public String getTitle() {
        return Title;
    }

    public int getImage_path() {
        return Image_path;
    }
}
