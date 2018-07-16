package com.example.phoenix.android_day01_03_buttonclickeventimplement2;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editViewNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载一个布局
        setContentView(R.layout.activity_main);
        //找到想要的控件
//        View viewById = findViewById(R.id.editText);
        editViewNumber = findViewById(R.id.editText);
        Button buttonCall = findViewById(R.id.button);

        //给button绑定点击事件
        //按钮的点击事件的第一种实现方式
//        buttonCall.setOnClickListener(new MyClickListener());

        //按钮的点击事件的第二种实现
        buttonCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String number = editViewNumber.getText().toString().trim();
                System.out.println(number);
                if("".equals(number)){
                    /**
                     * content 上下文
                     */
                    Toast.makeText(MainActivity.this,"电话号码不能为空",Toast.LENGTH_LONG).show();
                    return;
                }
                //进行拨打电话，创建一个意图对象
                Intent intent=new Intent();
                //设置动作
                intent.setAction(Intent.ACTION_CALL);
                //设置要拨打电话的数据
                intent.setData(Uri.parse("tel:"+number));
                //开启意图
                startActivity(intent);

                System.out.println("button is clicked");
            }
        });

    }




    //定义一个类去实现按钮所需的类
    private class MyClickListener implements View.OnClickListener {

        @Override
        public void onClick(View view) {
            String number = editViewNumber.getText().toString().trim();
            System.out.println(number);
            if("".equals(number)){
                /**
                 * content 上下文
                 */
                Toast.makeText(MainActivity.this,"电话号码不能为空",Toast.LENGTH_LONG).show();
                return;
            }
            //进行拨打电话，创建一个意图对象
            Intent intent=new Intent();
            //设置动作
            intent.setAction(Intent.ACTION_CALL);
            //设置要拨打电话的数据
            intent.setData(Uri.parse("tel:"+number));
            //开启意图
            startActivity(intent);



            System.out.println("button is clicked");

        }
    }

}
