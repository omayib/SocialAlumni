package id.technomotion;

import android.app.Application;
import android.util.Log;


import com.sendbird.android.SendBird;
import com.sendbird.android.SendBirdException;
import com.sendbird.android.User;

import io.realm.Realm;

/**
 * Created by omayib on 18/09/17.
 */

public class SocialAlumniApp extends Application {
    private static final String TAG = "SocialAlumniApp";
    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
        SendBird.init("18A414E4-8E6C-437A-AC7C-A0E1B8D5F064", this);
        SendBird.connect("selly", new SendBird.ConnectHandler() {
            @Override
            public void onConnected(User user, SendBirdException e) {
                if (e != null) {
                    e.printStackTrace();
                    return;
                }
                Log.d(TAG, "onConnected: "+user.getNickname());
                Log.d(TAG, "onConnected: "+user.getProfileUrl());
                Log.d(TAG, "onConnected: "+user.getMetaData());
                Log.d(TAG, "onConnected: "+user.getUserId());
            }
        });
    }
}
