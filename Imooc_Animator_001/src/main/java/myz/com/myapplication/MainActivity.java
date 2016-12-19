package myz.com.myapplication;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        Toast.makeText(this, "clicked", Toast.LENGTH_LONG).show();
    }

    public void move(View view) {

//        TranslateAnimation translateAnimation = new TranslateAnimation(0, 200, 0, 0);
//        translateAnimation.setDuration(1000);
//        translateAnimation.setFillAfter(true);
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
//        imageView.startAnimation(translateAnimation);
        //参数：1.操作对象，2.平移X轴，3.移动范围.
//        ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F).setDuration(1000).start();
//        ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F).setDuration(1000).start();
        //PropertyValuesHolder更加高效
//        PropertyValuesHolder p1 = PropertyValuesHolder.ofFloat("rotation", 360F);
//        PropertyValuesHolder p2 = PropertyValuesHolder.ofFloat("translationX", 0, 200F);
//        PropertyValuesHolder p3 = PropertyValuesHolder.ofFloat("translationY", 0, 200F);
//        ObjectAnimator.ofPropertyValuesHolder(imageView, p1, p2, p3).setDuration(2000).start();
        AnimatorSet set = new AnimatorSet();
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(imageView, "rotation", 0F, 360F);
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(imageView, "translationY", 0F, 200F);
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(imageView, "translationX", 0F, 200F);
        //playTogether()一起运行，playSeauentially()顺序运行
        // set.playSequentially(animator1, animator2, animator3);
        set.play(animator2).with(animator3);
        set.play(animator1).after(animator3);
        set.setDuration(1000);
        set.start();


    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState) {
//        super.onSaveInstanceState(outState);
//    }
//
//    @Override
//    protected void onRestoreInstanceState(Bundle savedInstanceState) {
//        super.onRestoreInstanceState(savedInstanceState);
//    }


}
