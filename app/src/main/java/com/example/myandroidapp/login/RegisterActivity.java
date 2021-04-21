package com.example.myandroidapp.login;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myandroidapp.R;
import com.example.myandroidapp.base.BaseActivity;

public class RegisterActivity extends BaseActivity {
  private EditText usernameEt;
  private EditText passwordEt;
  private EditText passwordAgainEt;

  @Override
  protected int initLayout() {
    return R.layout.activity_register;
  }

  @Override
  protected void initView() {
    TextView titleCentre = findViewById(R.id.title_centre);
    usernameEt = findViewById(R.id.username_et);
    passwordEt = findViewById(R.id.password_et);
    passwordAgainEt = findViewById(R.id.password_again_et);
    Button btnRegister = findViewById(R.id.btn_register);

    titleCentre.setText("注册页面");

    btnRegister.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        String username2 = usernameEt.getText().toString().trim();
        if (username2.isEmpty()) {
          Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
          return;
        }
        String password2 = passwordEt.getText().toString().trim();
        if (password2.isEmpty()) {
          Toast.makeText(RegisterActivity.this, "请输入密码", Toast.LENGTH_SHORT).show();
          return;
        }
        String password3 = passwordAgainEt.getText().toString().trim();
        if (password3.equals(password2)) {
          Toast.makeText(RegisterActivity.this, "注册成功", Toast.LENGTH_SHORT).show();

          //把用户名和密码传递给登录界面
          Intent intent = getIntent();
          intent.putExtra("username", username2);
          intent.putExtra("password", password2);
          setResult(1, intent);
          finish();
        } else {
          Toast.makeText(RegisterActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();
        }
      }
    });
  }

  @Override
  protected void initData() {

  }
}
