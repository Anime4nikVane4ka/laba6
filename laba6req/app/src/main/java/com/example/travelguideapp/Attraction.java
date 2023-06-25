package com.example.travelguideapp;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import com.yandex.mapkit.geometry.Point;

import java.util.Calendar;

public class Attraction implements Parcelable {

    private String name;
    private String fullDescription;
    private String openingHours;
    private Point coordinates;
    private String Start;
    private String End;

    public Attraction(String name, String fullDescription, Point coordinates, String Start, String End) {
        this.name = name;
        this.fullDescription = fullDescription;
        this.coordinates = coordinates;
        this.Start = Start;
        this.End = End;
    }
    protected Attraction(Parcel in) {
        name = in.readString();
        fullDescription = in.readString();
        openingHours = in.readString();
        coordinates = new Point(in.readDouble(), in.readDouble());
        //Start = Calendar.getInstance();;
        //End = Calendar.getInstance();;
        Start = in.readString();
        End = in.readString();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getFullDescription() {
        return fullDescription;
    }
    public void setFullDescription(String fullDescription) {
        this.fullDescription = fullDescription;
    }

    public String getOpeningHours() {
        return openingHours;
    }
    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public Point getCoordinates() {
        return coordinates;
    }
    public void setCoordinates(Point coordinates) {
        this.coordinates = coordinates;
    }

    public String getStart() {
        return Start;
    }
    public void setStart(String start) {
        this.Start = start;
    }

    public String getEnd() {
        return End;
    }
    public void setEnd(String end) {
        this.End = end;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(fullDescription);
        dest.writeString(openingHours);
        dest.writeDouble(coordinates.getLatitude());
        dest.writeDouble(coordinates.getLongitude());
        //dest.writeLong(Start.getTimeInMillis());
        //dest.writeLong(End.getTimeInMillis());
        dest.writeString(Start);
        dest.writeString(End);
    }

    public static final Creator<Attraction> CREATOR = new Creator<Attraction>() {
        @Override
        public Attraction createFromParcel(Parcel source) {
            return new Attraction(source);
        }

        @Override
        public Attraction[] newArray(int size) {
            return new Attraction[size];
        }
    };
}
