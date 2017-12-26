package com.example.kevin.bmi3;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class PropertyAnimation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_animation);

    //   屬性動畫方法 1.設定物件的background 2.在drawable建立一個動畫設定檔
    // android:background="@drawable/animproperty"…
        //更換圖檔
        playFrameAnimation1();
        playFrameAnimation4();
        //跑步
        playFrameAnimation3();
        //旋轉
        playPorpertyAnimationFromXML();
//        兩種動畫一起…

//        void playFrameAnimation(){

//        void playFrameAnimation3(){
//            AnimationDrawable anim3=(AnimationDrawable) imageView3.getBackground();
//            anim3.start();
//        }

        //底下兩個二選一



//
//
//        //        //屬性動畫開始
//        playFrameAnimation4();
////        playPropertyAnimation();
//        //屬性動畫束
    }

    void playFrameAnimation1(){
        ImageView imageView1=(ImageView)findViewById(R.id.image1);
        AnimationDrawable anim1=(AnimationDrawable) imageView1.getBackground();
        anim1.start();
    }

    void playFrameAnimation3(){
        ImageView imageView3=(ImageView)findViewById(R.id.image3);
        AnimationDrawable anim1=(AnimationDrawable) imageView3.getBackground();
        anim1.start();
    }

        void playFrameAnimation4() {
            ImageView img= (ImageView)findViewById(R.id.imageProperty);
            AnimationDrawable anim1 = (AnimationDrawable) img.getBackground();
            anim1.start();
        }

    void playPorpertyAnimationFromXML(){
        ImageView img= (ImageView)findViewById(R.id.imagePropertyXML);
        AnimatorSet set=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.animator);//決定前面寫到的動畫效困是用那一種動畫,先後順序
        set.setTarget(img);
        set.start();
    }



}
