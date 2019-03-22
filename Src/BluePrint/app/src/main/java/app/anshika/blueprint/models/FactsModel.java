package app.anshika.blueprint.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
/*Created by Anshika Bansal (March 2019 )*/

/*This class used to describe object(Facts) model and will create table in database as well...*/

@Entity
public class FactsModel {

    @SerializedName("id")
    @PrimaryKey
    public long id;

    @ColumnInfo(name = "title")
    @SerializedName("title")
    public String title;

    @ColumnInfo(name = "desc")
    @SerializedName("description")
    public String description;


    public long getId() {
        return id;
    }


    String getTitle() {
        return title;
    }


    String getDescription() {
        return description;
    }

}
