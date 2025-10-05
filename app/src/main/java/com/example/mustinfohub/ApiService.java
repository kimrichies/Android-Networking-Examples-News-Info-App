//Create the Retrofit API Interface and Client
package com.example.mustinfohub;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    // We use JSONPlaceholder for sample JSON data
    @GET("posts")
    Call<List<Post>> getPosts();
}
