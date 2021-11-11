package kg.geektech.lesson1.ui.film_list;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import kg.geektech.lesson1.App;
import kg.geektech.lesson1.data.models.Films;
import kg.geektech.lesson1.databinding.FragmentFilmDetailBinding;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FilmDetailFragment extends Fragment {

    private FragmentFilmDetailBinding binding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFilmDetailBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String id = getArguments().getString("id");

        App.api.getFilmInformation(id).enqueue(new Callback<Films>() {
            @Override
            public void onResponse(Call<Films> call, Response<Films> response) {
                if (response.isSuccessful()){
                    Films films = response.body();
                    binding.progressBar.setVisibility(View.GONE);
                    assert films != null;
                    binding.textTitle.setText(films.getTitle());
                    binding.textView.setText(films.getDescription());
                    Glide.with(requireActivity()).load(films.getImage()).into(binding.imageView);
                }
            }
            @Override
            public void onFailure(@NonNull Call<Films> call, @NonNull Throwable t) {
                Log.e("TAG", "onFailure: " + t.getLocalizedMessage() );
            }
        });
    }
}