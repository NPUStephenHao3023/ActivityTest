package com.example.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by acer on 2017/4/8.
 */

public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","Task id is " + getTaskId());
        setContentView(R.layout.second_layout);


//        通过 getIntent()方法获取到用于启动 SecondActivity 的 Intent

//        Intent intent = getIntent();


//        getStringExtra()方法，传入相应的键值，就可以得到传递的数据了。这里由于我们传递的是
//        字符串，所以使用 getStringExtra()方法来获取传递的数据，如果传递的是整型数据，则使用
//        getIntExtra()方法，传递的是布尔型数据，则使用 getBooleanExtra()方法，以此类推。

//        String data = intent.getStringExtra("extra_data");
//        Log.d("SecondActivity",data);


        Button button2 = (Button) findViewById(R.id.button_2);
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent();
//                构建了一个 Intent，只不过这个 Intent 仅仅是用于传递数据而已，
//            它没有指定任何的“意图” 。紧接着把要传递的数据存放在 Intent 中，
//                intent.putExtra("data_return","Hello FirstActivity");

//                setResult()方法接收两个
//                参数 ，第 一个 参数 用于 向上一 个活 动返 回处 理结果 ，一 般只 使用 RESULT_OK 或
//                RESULT_CANCELED 这两个值，第二个参数则是把带有数据的 Intent 传递回去，然后调用
//                了 finish()方法来销毁当前活动。
//
//                setResult(RESULT_OK,intent);
//                finish();


                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
            }
        });
    }


//    如果用户在 SecondActivity 中并不是通过点击按钮，而是通过按下
//    Back 键回到 FirstActivity，这样数据不就没法返回了吗？没错，不过这种情况还是很好处理
//    的，我们可以通过重写 onBackPressed()方法来解决这个问题

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return","Hello FirstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("Second","onDestroy");
    }
}
