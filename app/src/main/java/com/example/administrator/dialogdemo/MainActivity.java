package com.example.administrator.dialogdemo;

import android.app.Dialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    Dialog mCameraDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View v) {
        loadDiglog();
    }

    private void loadDiglog() {
        mCameraDialog = new Dialog(this, R.style.my_dialog);
        LinearLayout root = (LinearLayout) LayoutInflater.from(this).inflate(
                R.layout.sellershow_bottom_dalig, null);
        Button delete = (Button) root.findViewById(R.id.seller_show_delete);
        Button changeImage = (Button) root.findViewById(R.id.seller_show_changeimage);
        Button cancel = (Button) root.findViewById(R.id.btn_cancel);
        mCameraDialog.setContentView(root);
        Window dialogWindow = mCameraDialog.getWindow();
        dialogWindow.setGravity(Gravity.BOTTOM);
        dialogWindow.setWindowAnimations(R.style.dialogstyle); // 添加动画
        WindowManager.LayoutParams lp = dialogWindow.getAttributes(); // 获取对话框当前的参数值
        lp.x = 0; // 新位置X坐标
        lp.y = -20; // 新位置Y坐标
        lp.width = (int) getResources().getDisplayMetrics().widthPixels; // 宽度
        //      lp.height = WindowManager.LayoutParams.WRAP_CONTENT; // 高度
        //      lp.alpha = 9f; // 透明度
        root.measure(0, 0);
        lp.height =/* root.getMeasuredHeight();*//*getWindowManager().getDefaultDisplay().getHeight()/4;*/WindowManager.LayoutParams.WRAP_CONTENT;
        lp.alpha = 9f; // 透明度
        dialogWindow.setAttributes(lp);
        mCameraDialog.setCanceledOnTouchOutside(true);
        mCameraDialog.show();

        //删除某一条目
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                if (jiuSTSAddress.size() != 0 && snplMomentAddPhotos.getData().get(position).contains(AppConstants.mode.getSTSImageUrl())) {
//                    jiuSTSAddress.remove(position);
//                }
//                snplMomentAddPhotos.removeItem(position);
                mCameraDialog.dismiss();

            }
        });

        changeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                num = position;
//                choicePhotoWrapper1();

            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCameraDialog.dismiss();

            }
        });


    }

}
