package com.example.myandroidapp.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.myandroidapp.MainActivity;
import com.example.myandroidapp.R;
import com.example.myandroidapp.base.BaseActivity;

public class LoginActivity extends BaseActivity {
  private EditText usernameEt;
  private EditText passwordEt;
  private String username = "111";
  private String password = "111111";
  private SharedPreferences sharedPreferences;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
  }

  @Override
  protected int initLayout() {
    // 初始化布局
    return R.layout.activity_login;
  }

  @Override
  protected void initView() {
    // 初始化控件
    TextView titleCentre = findViewById(R.id.title_centre);
    usernameEt = findViewById(R.id.username_et);
    passwordEt = findViewById(R.id.password_et);
    Button btnLogin = findViewById(R.id.btn_login);
    Button btnRegister = findViewById(R.id.btn_register);

    titleCentre.setText("登录页面");

    //将信息存储到account文件，私有
    sharedPreferences = getSharedPreferences("account", MODE_PRIVATE);

    btnRegister.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
        startActivityForResult(intent, 1);
      }
    });

    btnLogin.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username2 = usernameEt.getText().toString().trim();
        if (username2.isEmpty()) {
//          Toast.makeText(LoginActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
          showToast("请输入用户名");
          return;
        }
        String password2 = passwordEt.getText().toString().trim();
        if (password2.isEmpty()) {
          Toast.makeText(LoginActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
          return;
        }
        if (username.equals(username2) && password.equals(password2)) {

          //存储用户名
          SharedPreferences.Editor editor = sharedPreferences.edit();
          editor.putString("account", username);
          editor.apply();

          Intent intent = new Intent(LoginActivity.this, MainActivity.class);
          startActivity(intent);
          finish();

          Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

          finish();
        } else {
          Toast.makeText(LoginActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
        }

      }
    });
  }

  //获取注册页面传来的数据
  @Override
  protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (requestCode == 1 && requestCode == 1) {
      if (data != null) {
        username = data.getStringExtra("username");
        password = data.getStringExtra("password");
      }
    }
  }

  @Override
  protected void initData() {
    // 初始化、绑定数据
  }
}
