package kg.geektech.lesson1;

import android.app.Application;

import kg.geektech.lesson1.data.remote.FilmApi;
import kg.geektech.lesson1.data.remote.RetrofitClient;

public class App extends Application {

    public static FilmApi api;
    public RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.provideFilmApi();
    }

}
