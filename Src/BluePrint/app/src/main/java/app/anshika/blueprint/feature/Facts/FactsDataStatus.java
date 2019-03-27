package app.anshika.blueprint.feature.Facts;

/*Created by Anshika Bansal (March 2019 )*/

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


/*Class used to show the status of event that is performed by user... */
public class FactsDataStatus<T> {
    @NonNull
    public final Status mStatus;
    @Nullable
    public final T mData;
    @Nullable
    public final String mMessage;

    public FactsDataStatus(@NonNull Status status, @Nullable T data,
                    @Nullable String message) {
        mStatus = status;
        mData = data;
        mMessage = message;
    }

    public static <T> FactsDataStatus<T> success(@NonNull T data) {
        return new FactsDataStatus<>(FactsDataStatus.Status.COMPLETE, data, null);
    }

    public static <T> FactsDataStatus<T> error(String msg, @Nullable T data) {
        return new FactsDataStatus<>(FactsDataStatus.Status.APIERROR, data, msg);
    }

    public static <T> FactsDataStatus<T> loading(@Nullable T data) {
        return new FactsDataStatus<>(FactsDataStatus.Status.INPROGRESS, data, null);
    }

    public enum Status {COMPLETE, APIERROR, INPROGRESS}
}
