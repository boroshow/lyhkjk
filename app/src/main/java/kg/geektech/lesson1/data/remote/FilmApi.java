package kg.geektech.lesson1.data.remote;

import java.util.List;

import kg.geektech.lesson1.data.models.Films;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilmApi {

    @GET("/films")
    Call<List<Films>> getFilms();

    @GET("/films/{id}")
    Call<Films> getFilmInformation(
            @Path("id") String id);

}
