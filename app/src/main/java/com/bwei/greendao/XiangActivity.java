package com.bwei.greendao;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import com.bwei.greendao.api.XiangApiService;
import com.bwei.greendao.bean.Xiang;
import com.bwei.greendao.entity.UserEntity;
import com.bwei.greendao.greendao.UserEntityDao;
import com.bwei.greendao.utils.GreendaoUtils;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.bwei.greendao.api.Api.BASE_URL;

public class XiangActivity extends AppCompatActivity {

    @BindView(R.id.xiang_web)
    WebView xiangWeb;
    @BindView(R.id.xiang_title)
    TextView xiangTitle;
    @BindView(R.id.xiang_name)
    TextView xiangName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang);
        ButterKnife.bind(this);
        EventBus.getDefault().register(this);
    }

    @Subscribe(sticky = true)
    public void recevier(String s){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        XiangApiService xiangApiService = retrofit.create(XiangApiService.class);
        Call<Xiang> xiang=xiangApiService.xiang(s);
        xiang.enqueue(new Callback<Xiang>() {
            @Override
            public void onResponse(Call<Xiang> call, Response<Xiang> response) {
                Xiang body = response.body();
                StringBuffer sb = new StringBuffer();
                sb.append("<html>");
                sb.append("<head>");
                sb.append("<title> Our Love</title>");
                sb.append("</head>");
                sb.append("<body>");
                sb.append(body.getResult().getDetails());
                sb.append("</body>");
                sb.append("</html>");
                xiangWeb.loadDataWithBaseURL(null, sb.toString(), "text/html", "utf-8", null);
                xiangWeb.setWebViewClient(new WebViewClient());
                xiangTitle.setText(body.getResult().getDescribe());
                xiangName.setText(body.getResult().getCommodityName());
            }

            @Override
            public void onFailure(Call<Xiang> call, Throwable t) {

            }
        });
    }

    public void add(View view){
        UserEntity userEntity = new UserEntity();
        userEntity.setName("sssssss");
        UserEntityDao userEntityDao=GreendaoUtils.getInstance().getDaoSession().getUserEntityDao();
        long l = userEntityDao.insert(userEntity);
        Toast.makeText(XiangActivity.this,l+"",Toast.LENGTH_SHORT).show();
    }
    public void query(View view){

    }
    public void update(View view){

    }
    public void delete(View view){

    }
}
