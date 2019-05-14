package app.anshika.blueprint.permissions;

import android.Manifest;
import android.content.Context;

public class PermissionUtils {
    public static final int REQUEST_CODE_SETTINGS_ACTIVITY = 126;
    public static final int REQUEST_CODE_PERMISSIONS = 127;
    public static final String SEND_SMS = Manifest.permission.SEND_SMS;
    public static final String CAMERA = Manifest.permission.CAMERA;
    public static final String CALL_PHONE = Manifest.permission.CALL_PHONE;
    public static final String INTERNET_ACCESS_FULL = Manifest.permission.INTERNET;
    public static final String AUDIO_SETTING = Manifest.permission.MODIFY_AUDIO_SETTINGS;
    public static final String RECORD_AUDIO = Manifest.permission.RECORD_AUDIO;
    public static final String BLUETOOTH = Manifest.permission.BLUETOOTH;
    public static final String BLUETOOTH_ADMIN = Manifest.permission.BLUETOOTH_ADMIN;

    public static final String WAKE_LOCK = Manifest.permission.WAKE_LOCK;

    public static final String GET_ACCOUNT = Manifest.permission.GET_ACCOUNTS;

    public static final String VIBRATE = Manifest.permission.VIBRATE;

    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;

    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;

    public static final String ACCESS_WIFI_STATE = Manifest.permission.ACCESS_WIFI_STATE;

    public static final String ACCESS_NETWORK_STATE = Manifest.permission.ACCESS_NETWORK_STATE;

    public static final String ACCESS_FINE_LOCATION = Manifest.permission.ACCESS_FINE_LOCATION;

    public static final String ACCESS_COARSE_LOCATION = Manifest.permission.ACCESS_COARSE_LOCATION;

    public static final String READ_PHONE_STATE = Manifest.permission.READ_PHONE_STATE;

    public static final String GET_ACCOUNTS = Manifest.permission.GET_ACCOUNTS;

    public static final String READ_CALENDAR = Manifest.permission.READ_CALENDAR;

    public static final String WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR;

    public static final String LOCATION_MESSAGE = "Please grant location permission";
    public static final String STORAGE_MESSAGE = "Please grant storage permission";
    public static final String CAMERA_MESSAGE = "Please grant camera permission";

    public static String getPermissionRationaleTag(String permission) {
        String tag = "PERMISSION";
        switch (permission) {
            case ACCESS_COARSE_LOCATION:
                tag = "Location";
                break;
            case ACCESS_FINE_LOCATION:
                tag = "";
                break;
            case CAMERA:
                tag = "Camera";
                break;
            case WRITE_EXTERNAL_STORAGE:
            case READ_EXTERNAL_STORAGE:
                tag = "Storage";
                break;
        }
        return tag;
    }


    public static String getPermissionRationaleMessage(String permission) {
        String msg = "Please grant permission in Setting";
        switch (permission) {
            case ACCESS_COARSE_LOCATION:
            case ACCESS_FINE_LOCATION:
                msg = LOCATION_MESSAGE;
                break;
            case CAMERA:
                msg = CAMERA_MESSAGE;
                break;
            case WRITE_EXTERNAL_STORAGE:
            case READ_EXTERNAL_STORAGE:
                msg = STORAGE_MESSAGE;
                break;

        }
        return msg;
    }


    public static boolean isPermissionWithCustomMessage(String permission) {
        boolean result = false;
      /*  switch (permission) {
            case CAMERA:
                result = true;
                break;

        }*/
        return result;
    }


    public static String getPermissionForCustomMessage(String permission) {
        String msg = "Please grant permission in Setting";
        switch (permission) {
            case WRITE_EXTERNAL_STORAGE:
            case READ_EXTERNAL_STORAGE:
                msg = STORAGE_MESSAGE;
                break;

        }
        return msg;
    }


}
