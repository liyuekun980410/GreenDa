package com.bwei.greendao.api;


import com.bwei.greendao.bean.Show;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserApiService {
    @GET("small/commodity/v1/commodityList")
    Call<Show> Show();
}
