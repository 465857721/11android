package com.android11.master.home.view;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android11.master.R;
import com.android11.master.home.bean.HomePageBean;
import com.android11.master.http.APIService;
import com.android11.master.http.base.BaseResp;
import com.android11.master.http.HRetrofitNetHelper;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;

public class HomeActivity extends AppCompatActivity implements HRetrofitNetHelper.RetrofitCallBack<HomePageBean> {

    @Bind(R.id.btn_go)
    Button btnGo;
    @Bind(R.id.btn_go2)
    Button btnGo2;
    @Bind(R.id.tv_result)
    TextView tvResult;

    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        mActivity = this;
    }

    @Override
    public void onSuccess(BaseResp<HomePageBean> baseResp) {
        tvResult.setText(baseResp.getData().getName());
    }

    @Override
    public void onFailure(String error) {
        tvResult.setText("Error");

    }

    private void getHomeData() {
        APIService mAPIService = HRetrofitNetHelper.getInstance(mActivity).getAPIService(APIService.class);
        final Call<BaseResp<HomePageBean>> repos = mAPIService.getHomeBean();
        HRetrofitNetHelper.getInstance(mActivity).enqueueCall(repos, this);

    }

    @OnClick({R.id.btn_go, R.id.btn_go2})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_go:
                getHomeData();
                break;
            case R.id.btn_go2:
                break;
        }
    }
}
