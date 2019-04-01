package app.anshika.blueprint.database;


import android.app.Application;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import app.anshika.blueprint.feature.Facts.FactsDao;
import app.anshika.blueprint.models.FactsModel;


@Database(entities = {FactsModel.class}, version = 1)

public abstract class DataBaseHelper extends RoomDatabase {

    private static DataBaseHelper sDataBaseInstance;


    public static DataBaseHelper getDataBase(Application application) {
        if (sDataBaseInstance == null) {
            synchronized (DataBaseHelper.class) {

                if (sDataBaseInstance == null)
                    sDataBaseInstance = Room.databaseBuilder(application,
                            DataBaseHelper.class, "blueprint_database").build();
            }
        }
        return sDataBaseInstance;

    }

    public abstract FactsDao factsDao();


}
