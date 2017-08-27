package net.st4ndard.sampler.model;

import android.graphics.Color;
import android.util.Log;
import android.view.View;

public class Pad {
    private String name;
    private String url;
    private int sound;
    private int color;

    public Pad(String name, String url, int color) {
        this.name = name;
        this.url = url;
        this.color = color;
    }

    public void onClickFriend(View view) {
        Log.d("pad", "clicked");
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    public int getSound() {
        return sound;
    }

    public void setSound(int sound) {
        this.sound = sound;
    }

}
