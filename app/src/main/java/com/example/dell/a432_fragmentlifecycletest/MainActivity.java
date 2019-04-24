package com.example.dell.a432_fragmentlifecycletest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(this);

        replaceFragment(new RightFragment());


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {

        MainActivity activity = (MainActivity) fragment.getActivity();

        RightFragment rightFragment = (RightFragment) getSupportFragmentManager().findFragmentById(R.id.right_fragment);
        //获取FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //开启一个事务
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        //向容器内添加或替换碎片
        transaction.replace(R.id.right_layout, fragment);

        //将一个事务添加到返回栈中，接收一个名字用于描述返回栈的状态
        transaction.addToBackStack(null);

        //提交事物
        transaction.commit();
    }
}