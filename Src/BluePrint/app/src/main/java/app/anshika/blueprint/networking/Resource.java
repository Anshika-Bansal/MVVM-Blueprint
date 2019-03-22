package app.anshika.blueprint.networking;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/*Created by Anshika Bansal (March 2019 )*/

/*A generic class that contains data and status about loading this data.*/

public class Resource<T> {
    @NonNull
    public final Status mStatus;
    @Nullable
    public final T mData;
    @Nullable
    public final String mMessage;

    private Resource(@NonNull Status status, @Nullable T data,
                     @Nullable String message) {
        mStatus = status;
        mData = data;
        mMessage = message;
    }

    public static <T> Resource<T> success(@NonNull T data) {
        return new Resource<>(Status.SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String msg, @Nullable T data) {
        return new Resource<>(Status.ERROR, data, msg);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(Status.LOADING, data, null);
    }

    public enum Status {SUCCESS, ERROR, LOADING}
}
