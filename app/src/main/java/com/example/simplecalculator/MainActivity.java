package com.example.simplecalculator;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

//import Button, EditText, TextView, AlertDialog
//首先看17行到20行，导入页面中写的Button、EditText、TextView、AlertDialog，这样才能使用，然后24行开始创建EditText对象num1，创建EditText对象num2，定义result为int类型，创建TextView对象resultView
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.app.AlertDialog;

public class MainActivity extends AppCompatActivity {

    private EditText num1; // create EditText object num1
    private EditText num2; // create EditText object num2
    private int result; // declare result as int type
    private TextView resultView; //create TextView object resultView

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    //47行的findViewById()是根据id获取视图，R.id.fortuneText是id为fortuneText的视图，把它赋给resultView，setText()是给resultView设置值的方法，
        // String.valueOf(result)会返回result的字符串表示形式，也就是将result的字符串形式设置为resultView的值，
        // 49行获取页面中id为num1的控件赋给num1，下面获取页面中id为num2的控件赋给num2
        resultView = (TextView) findViewById(R.id.fortuneText); // findViewById() 根据id获取视图, 获取页面中id为fortuneText的widget
        resultView.setText(String.valueOf(result)); // setText()给resultView 设置值的方法, String.valueOf(result)返回result的字符串表示形式
        num1 = (EditText) findViewById(R.id.num1); //获取页面中id为num1的控件
        num2 = (EditText) findViewById(R.id.num2); //获取页面中id为num2的控件
    }
    //加法
    public void addFunc(View view)
    {//首先56行有一个if判断，getText()是获取num1值的方法，String.valueOf(num1.getText()) 返回num1值的字符串表示形式，equals("")，双引号内没有内容，是判断num1值是否为空，也就是未输入，如果未输入返回true，反之返回false，所以这行代码将num1和num2值的字符串形式和空字符串比较，返回布尔值进行逻辑运算或，只要有一个未输入就执行if代码块内代码
        //判断num1或num2是否有未输入的
        if(String.valueOf(num1.getText()).equals("") || String.valueOf(num2.getText()).equals("")){
            //弹窗  //if代码块里写了一个弹窗AlertDialog，58到60行是弹窗，我们只需要知道弹窗的title是警告，弹窗信息是“输入不能为空，请重新输入！！！”，然后有一个确定按钮，点击后弹窗消失，知道这些就可以了，也就是说两个输入框只要有一个未输入就会有一个弹窗
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Warning").setMessage("The input cannot be empty，Please enter again!!!")
                    .setPositiveButton("Sure", null).show();
//如果不满足if中的条件，执行else代码块，64行将num1的值返回字符串形式，然后Integer.parseInt()将String字符类型数据转换为Integer整型数据，转为Integer整型之后可以进行计算，所以就是将num1和num2的值转为Integer整型之后进行加法运算，结果赋值给result，65行将字符串形式的result设置为resultView的值
        }else{
            // Integer.parseInt()将String字符类型数据转换为Integer整型类型
            result = Integer.parseInt(String.valueOf(num1.getText())) + Integer.parseInt(String.valueOf(num2.getText()));
            resultView.setText(String.valueOf((result))); // 将字符串的result 设置为resultView的值
        }
    }
    //减法
    // 先看减法subFunc，72行和加法一样，判断num1和num2是否有未输入的，如果有未输入的话，74行给出一个弹窗，弹窗信息也是“输入不能为空，请重新输入！！！”，如果都输入的话执行else代码块，num1和num2的值转为Integer整型之后相减，结果赋值给result，80行将字符串形式的result设置为resultView的值
    public void subFunc(View view) {
        //判断num1或num2是否有未输入的
        if (String.valueOf(num1.getText()).equals("") || String.valueOf(num2.getText()).equals("")) {
            //弹窗
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Warning").setMessage("The input cannot be empty，Please enter again!!!")
                    .setPositiveButton("Sure", null).show();
        }else{
            //两数相减的值赋值给result
            result = Integer.parseInt(String.valueOf(num1.getText())) - Integer.parseInt(String.valueOf(num2.getText()));
            resultView.setText(String.valueOf(result));
        }
    }
    //乘法
    //乘法mulFunc，87行同样的也是先判断，num1和num2是否有未输入的，如果有未输入的话，89行给出一个弹窗，弹窗信息也是“输入不能为空，请重新输入！！！”，如果都输入的话执行else代码块，num1和num2的值转为Integer整型之后相乘，结果赋值给result，最后95行将字符串形式的result设置为resultView的值
    public void mulFunc(View view){
        //判断num1或num2是否有未输入的
        if (String.valueOf(num1.getText()).equals("") || String.valueOf(num2.getText()).equals("")){
            //弹窗
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Warning").setMessage("The input cannot be empty，Please enter again!!!")
                    .setPositiveButton("Sure", null).show();
        }else{
            //两数相乘的值赋值给result
            result = Integer.parseInt(String.valueOf(num1.getText())) * Integer.parseInt(String.valueOf(num2.getText()));
            resultView.setText(String.valueOf(result));
        }
    }
    //除法
    //是的，除法有点特殊，因为除数不能为零，所以如果输入的第二个数如果是零我们还要给一个弹窗来提示除数不能为0
    //下面来讲解除法，首先103行也是对num1和num2是否输入做出判断，如果条件为true只要有一个输入框未输入的话，105行给出一个弹窗，信息为“输入不能为空，请重新输入！！！”，都输入了的话，执行else，看110行又做出一个判断，这是对除数是否为0的判断
    //String.valueOf()得到num2值得字符串形式，equals()和“0”做比较，如果相同，113行给出一个弹窗，提示信息为“除数不能为0，请重新输入！！！”，如果不相同也就是第二个输入框输入的不是0，执行116行else代码块，将num1的值和num2的值相除结果赋值给result，最后将字符串形式的result设置为resultView的值
    public void divFunc(View view){
        //判断num1或num2是否有未输入的
        if (String.valueOf(num1.getText()).equals("") || String.valueOf(num2.getText()).equals("")){
            //弹窗
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Warning").setMessage("The input cannot be empty，Please enter again!!!")
                    .setPositiveButton("Sure", null).show();
        }else{
            //如果num2的值是0
            if (String.valueOf(num2.getText()).equals("0")){
                //必须要弹窗
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Warning").setMessage("Cannot divide 0,   Please enter again!!!")
                        .setPositiveButton("Sure", null).show();
            }else{
                //两数相除的值赋值给result
                result = Integer.parseInt(String.valueOf(num1.getText())) / Integer.parseInt(String.valueOf(num2.getText()));
                resultView.setText(String.valueOf(result));
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
