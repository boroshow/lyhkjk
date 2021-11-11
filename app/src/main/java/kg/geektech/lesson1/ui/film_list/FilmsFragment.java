package kg.geektech.lesson1.ui.film_list;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import kg.geektech.lesson1.App;
import kg.geektech.lesson1.R;
import kg.geektech.lesson1.data.models.Films;
import kg.geektech.lesson1.databinding.FragmentFilmsBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmsFragment extends Fragment{

    private FragmentFilmsBinding binding;
    private FilmsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new FilmsAdapter();
        adapter.setOnClick(films -> {
            Bundle bundle = new Bundle();
            bundle.putString("id",films.getId());
            NavController navController = Navigation.findNavController(requireActivity(),R.id.nav_host_fragment);
            navController.navigate(R.id.filmDetailFragment,bundle);
        });
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.recyclerView.setAdapter(adapter);

        App.api.getFilms().enqueue(new Callback<List<Films>>() {
            @Override
            public void onResponse(@NonNull Call<List<Films>> call, @NonNull Response<List<Films>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.setList(response.body());
                } else {
                    assert response.errorBody() != null;
                    Log.e("TAG", "onFailure " + response.errorBody().toString());
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Films>> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }

}