package com.example.myandroidapp.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;

import com.example.myandroidapp.MainActivity;
import com.example.myandroidapp.R;
import com.example.myandroidapp.base.BaseActivity;

public class SplashActivity extends BaseActivity {
  private SharedPreferences sharedPreferences;

  @Override
  protected int initLayout() {
    return R.layout.activity_splash;
  }

  @Override
  protected void initView() {
    sharedPreferences = getSharedPreferences("account", MODE_PRIVATE);
    String account = sharedPreferences.getString("account", "");

    //判断是否登录
    if (account.isEmpty()) {
      new Handler().postDelayed(new Runnable() {
        public void run() {
          Intent mainIntent = new Intent(SplashActivity.this,
                  LoginActivity.class);
          SplashActivity.this.startActivity(mainIntent);
          SplashActivity.this.finish();
        }
      }, 1500);
    } else {
      new Handler().postDelayed(new Runnable() {
        public void run() {
          Intent mainIntent = new Intent(SplashActivity.this,
                  MainActivity.class);
          SplashActivity.this.startActivity(mainIntent);
          SplashActivity.this.finish();
        }
      }, 1500);
    }
  }

  @Override
  protected void initData() {

  }
}
