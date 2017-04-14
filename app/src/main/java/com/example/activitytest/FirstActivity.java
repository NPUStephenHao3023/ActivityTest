package com.example.activitytest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by acer on 2017/4/8.
 */

public class FirstActivity extends BaseActivity {

    protected void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        Log.d("FirstActivity","Task id is "+ getTaskId());
        setContentView(R.layout.first_layout);



        //(Button) findViewById 是向下转型
        Button button1 = (Button) findViewById(R.id.button_1);
        //设置一个OnClickListener来监听事件，并在对象中调用方法OnClick来响应
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){


//                Toast 的用法非常简单， 通过静态方法 makeText()创建出一个 Toast 对象， 然后调用 show()
//                将 Toast 显示出来就可以了。这里需要注意的是，makeText()方法需要传入三个参数。第一
//                个参数是 Context，也就是 Toast 要求的上下文，由于活动本身就是一个 Context 对象，因此
//                这里直接传入 FirstActivity.this即可。 第二个参数是 Toast显示的文本内容，第三个参数是Toast
//                显示的时长，有两个内置常量可以选择 Toast.LENGTH_SHORT 和 Toast.LENGTH_LONG

//                Toast.makeText(FirstActivity.this,
//                        "You click Button 1",
//                        Toast.LENGTH_SHORT).show();


//                在程序中通过代码来销毁活动

//                finish();


//                Intent intent = new Intent("android.intent.action.ACTION_START");
//                为intent添加category，如果没有activity声明这个category，程序就会崩溃，所以在
//                AndroidManifest中为SecondActivity加一条category声明
//                <category android:name="android.intent.category.MY_CATEGORY"/>

//                intent.addCategory("com.example.activitytest.MY_CATEGORY");

//                以隐式的方式启动能响应VIEW这个action的活动，来打开网页

//                Intent intent = new Intent("android.intent.action.VIEW");
//                Intent intent = new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));


//                以隐式的方式启动能响应DIAL这个action的活动，来调用系统的打电话的活动

//                Intent intent = new Intent("android.intent.action.DIAL");
//                Intent intent = new Intent(Intent.ACTION_DIAL);
//                intent.setData(Uri.parse("tel:10086"));


//                以显式的方式启动下一个活动时向其传递数据，第一个参数是键，用于后面从 Intent
//                中取值，第二个参数才是真正要传递的数据。这个数据可以在SecondActivity中取出来。
//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                String data = "Hello SecondActivity";
//                intent.putExtra("extra_data",data);


//                startActivityForResult()方法接收两个参数，第一个参数还是 Intent，第二个参数是请求
//                码，用于在之后的回调中判断数据的来源:请求码只要是一个唯一值就可以了

//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivityForResult(intent,1);


//                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
//                startActivity(intent);


                SecondActivity.actionStart(FirstActivity.this,"data1","data2");
            }

        });

    }


//  创建菜单，调用getMenuInflater方法得到静态对象，再调用inflate方法调用menu布局填充

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }


//  创建菜单项的点击响应消息

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this,"You clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"You clicked Remove",Toast.LENGTH_SHORT).show();
            default:
        }
        return true;
    }


//由于我们是使用 startActivityForResult()方法来启动 SecondActivity 的，在 SecondActivity
//被销毁之后会回调上一个活动的 onActivityResult()方法，因此我们需要在 FirstActivity 中重
//    写这个方法来得到返回的数据，


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case 1:
                if(resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("FirstActivity","OnReStart");
    }
}
