package com.example.chennuo.popupwindowtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button BtnExit;
    private Button BtnCancel;
    private Button btnStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnStart = (Button) findViewById(R.id.btnstart);
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showPopupWindowLogout(v);
            }
        });
    }

    private void showPopupWindowLogout(View view) {
        final View contentView = LayoutInflater.from(this).inflate(R.layout.layout_exitapp, null);

        BtnExit = (Button) contentView.findViewById(R.id.btn_Exit);
        BtnCancel = (Button) contentView.findViewById(R.id.btn_Cancel);

//        退出登录
        BtnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "退出登录", Toast.LENGTH_SHORT).show();
            }
        });


        final PopupWindow popupWindow =
                new PopupWindow(contentView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT, true);
//      取消
        BtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
                return;
            }
        });
        popupWindow.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        popupWindow.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);

        popupWindow.setTouchable(true);

        popupWindow.setTouchInterceptor(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return false;
            }
        });

        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.popupwindow));

        popupWindow.showAtLocation(view, Gravity.CENTER, 0, 0);

    }

}
