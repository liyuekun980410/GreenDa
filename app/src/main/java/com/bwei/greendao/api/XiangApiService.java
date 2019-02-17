package com.bwei.greendao.api;

import com.bwei.greendao.bean.Xiang;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface XiangApiService {
    @GET("small/commodity/v1/findCommodityDetailsById")
    Call<Xiang> xiang(@Query("commodityId") String commodityId);
}
