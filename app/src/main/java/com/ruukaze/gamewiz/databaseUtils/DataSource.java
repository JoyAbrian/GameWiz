package com.ruukaze.gamewiz.databaseUtils;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.ruukaze.gamewiz.adapter.GameGridAdapter;
import com.ruukaze.gamewiz.adapter.GameSearchAdapter;
import com.ruukaze.gamewiz.adapter.ScreenshotAdapter;
import com.ruukaze.gamewiz.apiService.ApiClient;
import com.ruukaze.gamewiz.apiService.ApiService;
import com.ruukaze.gamewiz.models.Game;
import com.ruukaze.gamewiz.models.Genre;
import com.ruukaze.gamewiz.models.InvolvedCompany;
import com.ruukaze.gamewiz.models.Platform;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DataSource {
    private static final Retrofit retrofit = ApiClient.getClient();
    private static final ApiService apiService = retrofit.create(ApiService.class);

    public static void getGamesByName(RecyclerView searchResults, String name) {
        String fields = "id, name, cover.*;";
        int limit = 10;

        Call<ArrayList<Game>> call = apiService.searchByNameGamesSimilarity(fields, name, limit);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    searchResults.setAdapter(new GameSearchAdapter(games));
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getEconestGames(ImageView eco_friendly_games_image, TextView eco_friendly_games_title, TextView eco_friendly_games_date) {
        String bodyString = "fields id, name, screenshots.*, release_dates.*; where id = 204554;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    Picasso.get().load("https://images.igdb.com/igdb/image/upload/t_screenshot_big/" + games.get(0).getScreenshots().get(0).getImage_id() + ".jpg").into(eco_friendly_games_image);
                    eco_friendly_games_title.setText(games.get(0).getName());
                    eco_friendly_games_date.setText(games.get(0).getRelease_dates().get(0).getHuman());
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getTopGames(RecyclerView searchResults) {
        String bodyString = "fields name, cover.*, release_dates.*;" +
                " limit 10;" +
                " where version_parent = null & platforms = (48, 167)" +
                " & rating != null & rating_count > 100;" +
                " sort rating desc;";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    searchResults.setAdapter(new GameGridAdapter(games));
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                    }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getGamesDetails(int game_id, ImageView cover_banner, ImageView cover_image, TextView game_title, TextView game_release) {
        String bodyString = "fields id, name, cover.*, screenshots.*, release_dates.*;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    Game game = games.get(0);

                    if (game.getCover() != null) {
                        String banner_url = "https://images.igdb.com/igdb/image/upload/t_screenshot_huge/" + game.getScreenshots().get(0).getImage_id() + ".jpg";
                        Picasso.get().load(banner_url).into(cover_banner);
                    }
                    if (game.getScreenshots() != null) {
                        String cover_url = "https://images.igdb.com/igdb/image/upload/t_cover_big/" + game.getCover().getImage_id() + ".jpg";
                        Picasso.get().load(cover_url).into(cover_image);
                    }

                    game_title.setText(game.getName());
                    if (game.getRelease_dates() != null) {
                        game_release.setText(game.getRelease_dates().get(0).getHuman());
                    }
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getGamesSummary(int game_id, TextView summary_text, TextView developers_list, TextView publishers_list, TextView platforms_list) {
        String bodyString = "fields id, summary;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    Game game = games.get(0);

                    summary_text.setText(game.getSummary());
//                    String developers = "";
//                    String publishers = "";
//                    for (InvolvedCompany involvedCompany: game.getInvolved_companies()) {
//                        if (involvedCompany.isDeveloper()) {
//                            developers += involvedCompany.getCompany().getName() + ", ";
//                        }
//                        if (involvedCompany.isPublisher()) {
//                            publishers += involvedCompany.getCompany().getName() + ", ";
//                        }
//                    }
//                    developers_list.setText(developers);
//                    publishers_list.setText(publishers);
//
//                    String platforms = "";
//                    for (Platform platform: game.getPlatforms()) {
//                        platforms += platform.getName() + ", ";
//                    }
//                    platforms_list.setText(platforms);
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }

    public static void getGamesScreenshot(int game_id, RecyclerView screenshots, TextView no_screenshots) {
        String bodyString = "fields screenshots.*;" +
                "limit 1;" +
                "where id = " + game_id + ";";

        RequestBody body = RequestBody.create(MediaType.parse("text/plain; charset=utf-8"), bodyString);
        Call<ArrayList<Game>> call = apiService.getTopGames(body);
        call.enqueue(new Callback<ArrayList<Game>>() {
            @Override
            public void onResponse(Call<ArrayList<Game>> call, Response<ArrayList<Game>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<Game> games = response.body();
                    Game game = games.get(0);

                    if (game.getScreenshots() != null) {
                        screenshots.setLayoutManager(new GridLayoutManager(screenshots.getContext(), 2));
                        screenshots.setAdapter(new ScreenshotAdapter(game.getScreenshots()));
                    } else {
                        screenshots.setVisibility(View.GONE);
                        no_screenshots.setVisibility(View.VISIBLE);
                    }
                } else {
                    Log.e("DiscoverFragment", "Failed to fetch games: " + response.message());
                    // Handle error
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Game>> call, Throwable t) {
                Log.e("DiscoverFragment", "Error fetching games", t);
                // Handle error
            }
        });
    }
}
