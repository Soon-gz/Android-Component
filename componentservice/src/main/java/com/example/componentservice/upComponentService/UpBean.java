package com.example.componentservice.upComponentService;

import android.os.Parcel;
import android.os.Parcelable;


/**
 * 作者：ShuWen
 * 日期：2018/7/17. 16:41
 * 描述：
 */
public class UpBean implements Parcelable {
    public String name;
    public String address;

    public UpBean() {
    }

    public UpBean(Parcel in) {
        name = in.readString();
        address = in.readString();
    }

    public static final Creator<UpBean> CREATOR = new Creator<UpBean>() {
        @Override
        public UpBean createFromParcel(Parcel in) {
            return new UpBean(in);
        }

        @Override
        public UpBean[] newArray(int size) {
            return new UpBean[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(address);
    }
}
