package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class Day {
    // Hello 
    @SerializedName("avg_wind_effect")
    public double averageWindEffect;
    @SerializedName("avg_solar_effect")
    public double averageSolarEffect;
    @SerializedName("minutes")
    public int minutes;
    @SerializedName("first_logged_at")
    public String firstLoggedAt;
    @SerializedName("last_logged_at")
    public String lastLoggedAt;
}
