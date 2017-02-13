package com.android11.master.http;


import com.android11.master.home.bean.HomePageBean;
import com.android11.master.http.base.BaseResp;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by 周康 on 2016/11/1.
 */

public interface APIService {

    @GET("HomeList")
    Call<BaseResp<HomePageBean>> getHomeBean();

//    @GET("NewsDataServlet")
////    @Headers("Cache-Control: public, max-age=30")
//    Call<BaseResp<HomePageBean>> gethomebean(@Query("userId") String userId);

}
