package app.anshika.blueprint.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
/*Created by Anshika Bansal (March 2019 )*/

/*This class is a POJO class used to describe object(Facts) model*/

public class FactsModel {

    @SerializedName("id")
    public long id;

    @SerializedName("title")
    public String title;

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
