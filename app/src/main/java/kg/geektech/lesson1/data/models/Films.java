package kg.geektech.lesson1.data.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Films{

    private String id;

    private String title;


    @SerializedName("original_title")
    private String originalTitle;

    private String description;

    private List<String> people;

    private String director;

    private String image;

    public Films() {
    }


    public Films(String id, String title, String originalTitle, String description, List<String> people, String director) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.description = description;
        this.people = people;
        this.director = director;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }
    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public List<String> getPeople() {
        return people;
    }
    public void setPeople(List<String> people) {
        this.people = people;
    }
    public String getDirector() {
        return director;
    }
    public void setDirector(String director) {
        this.director = director;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
