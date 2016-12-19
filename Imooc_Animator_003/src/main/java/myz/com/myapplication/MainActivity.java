package myz.com.myapplication;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {
    private int[] src = {R.id.imageView8, R.id.imageView, R.id.imageView2, R.id.imageView3, R.id.imageView4, R.id.imageView5, R.id.imageView6, R.id.imageView7};
    private List<ImageView> imageViewList = new ArrayList<ImageView>();
    private boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for (int i = 0; i < src.length; i++) {
            ImageView imageView = (ImageView) findViewById(src[i]);
            imageView.setOnClickListener(this);
            imageViewList.add(imageView);
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageView8:
                if (flag) {
                    startAnim();
                    flag = false;
                } else {
                    endAnim();
                    flag = true;
                }
                break;
            default:
                Toast.makeText(this, "click" + view.getId(), Toast.LENGTH_LONG).show();
                break;
        }
    }

    private void endAnim() {
        for (int i = src.length - 1; i > 0; i--) {
            ObjectAnimator animation = ObjectAnimator.ofFloat(imageViewList.get(i), "translationY", i * 150F, 10F);
            animation.setDuration(500);
            animation.setInterpolator(new BounceInterpolator());
            animation.setStartDelay((src.length - 1 - i) * 300);
            animation.start();
        }
    }

    private void startAnim() {
        for (int i = 1; i < src.length; i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewList.get(i),
                    "translationY", 0F, i * 150);
            animator.setDuration(500);
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 300);
            animator.start();
        }
    }
}
