package app.anshika.blueprint.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FactsModel {

    @SerializedName("id")
    @Expose
    private long id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("description")
    @Expose
    private String description;


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
