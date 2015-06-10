package com.westpac.assesment.weatherforecast.app.util;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Nisha on 10/06/2015.
 */
public class ConnectivityUtil {

    public static final String TAG = ConnectivityUtil.class.getName();

    public static NetworkInfo getNetworkInfo(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = cm.getActiveNetworkInfo();
        return info;
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo networkInfo = getNetworkInfo(context);
        return networkInfo != null && networkInfo.isConnected();
    }

    public static Location getCurrentLocation(Context c) {
        Location location = null;
        LocationManager lm = (LocationManager) c.getSystemService(Context.LOCATION_SERVICE);
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_COARSE);
        String provider = lm.getBestProvider(criteria, true);
        if (provider != null) {
            location = lm.getLastKnownLocation(provider);
        }
        return location;
    }
}
