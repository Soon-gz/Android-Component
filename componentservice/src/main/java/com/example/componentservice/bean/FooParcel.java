package com.example.componentservice.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author ShuWen
 * @email shuwen@corp.netease.com
 * @create_date 2018/10/14
 * @description:
 */

public class FooParcel implements Parcelable{
    @Override
    public String toString() {
        return "FooParcel:{" +
                "fooInt:" + fooInt +
                "}";
    }

    private int fooInt;

    public FooParcel() {
    }

    public int getFooInt() {
        return fooInt;
    }

    public void setFooInt(int fooInt) {
        this.fooInt = fooInt;
    }

    protected FooParcel(Parcel in) {
        fooInt = in.readInt();
    }

    public static final Parcelable.Creator<FooParcel> CREATOR = new Parcelable.Creator<FooParcel>() {
        @Override
        public FooParcel createFromParcel(Parcel in) {
            return new FooParcel(in);
        }

        @Override
        public FooParcel[] newArray(int size) {
            return new FooParcel[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(fooInt);
    }
}
