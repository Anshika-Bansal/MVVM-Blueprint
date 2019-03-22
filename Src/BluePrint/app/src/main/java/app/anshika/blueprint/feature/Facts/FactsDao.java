package app.anshika.blueprint.feature.Facts;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import app.anshika.blueprint.models.FactsModel;

@Dao
public interface FactsDao {


    @Query("SELECT * FROM FactsModel")
    List<FactsModel> getAll();


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(FactsModel... facts);

    @Delete
    void delete(FactsModel facts);

}
