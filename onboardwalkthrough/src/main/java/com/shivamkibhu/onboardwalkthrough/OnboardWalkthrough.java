package com.shivamkibhu.onboardwalkthrough;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.RequiresApi;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class OnboardWalkthrough extends RelativeLayout{
    Context context;
    private ImageView img, next, previous;
    private TextView title, description, skip, getStarted;
    private RelativeLayout layoutContainer, imgContainer;
    private RelativeLayout titleContainer;

    private String skipColor, getStartedColor;
    private boolean isSkipVisible;
    private boolean isStartedVisible;
    private String skipBackColor;
    private int skipTextSize;
    private int startedTextSize;
    private String startedText;
    private PageListener skipListener, getStartedListener;
    private ProgressBar progressBar;
    private boolean progressVisibility;
    private String progressColor;

    int index = 0;
    List<Page> list;

    public OnboardWalkthrough(Context context) {
        super(context);
        init(context);
    }

    public OnboardWalkthrough(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public OnboardWalkthrough(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public OnboardWalkthrough(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context);
    }


    private void init(Context context){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(
                Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.onboardwalkthrough_layout, this, true);

        this.context = context;
        layoutContainer = findViewById(R.id.layoutContainer);
        imgContainer = findViewById(R.id.imgContainer);
        skip = findViewById(R.id.skip);
        img = findViewById(R.id.img);
        next = findViewById(R.id.next);
        previous = findViewById(R.id.pre);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        titleContainer = findViewById(R.id.titleContainer);
        getStarted = findViewById(R.id.getStarted);
        progressBar = findViewById(R.id.progressBar);

        isSkipVisible = true;
        skipBackColor = "#00ffffff";
        skipTextSize = 20;
        startedTextSize = 20;
        startedText = "Get Start";
        isStartedVisible = true;
        skipListener = null;
        getStartedListener = null;
        progressColor = "#9C9898";
        progressVisibility = true;
        skipColor = "#000000";
        getStartedColor = "#ffffff";

        list = new ArrayList<>();
    }

    public void add(Page page){
        list.add(page);
    }


    public OnboardWalkthrough setStartTitle(String startedTitle) {
        startedText = startedTitle;
        isStartedVisible = true;
        return this;
    }

    public OnboardWalkthrough setStartVisibility(boolean isVisible){
        isStartedVisible = isVisible;
        return this;
    }

    public OnboardWalkthrough setStartClickListener(PageListener startedListener) {
        getStartedListener = startedListener;
        isStartedVisible = true;
        return this;
    }

    public OnboardWalkthrough setStartTextSize(int size) {
        startedTextSize = size;
        return this;
    }

    public OnboardWalkthrough setStartColor(String color){
        getStartedColor = color;
        return this;
    }


    public OnboardWalkthrough setSkipBackgroundColor(String skipBackground) {
        skipBackColor = skipBackground;
        isSkipVisible = true;
        return this;
    }

    public OnboardWalkthrough setSkipClickListener(PageListener listener) {
        skipListener = listener;
        isSkipVisible = true;
        return this;
    }

    public OnboardWalkthrough setSkipTextSize(int size) {
        skipTextSize = size;
        isSkipVisible = true;
        return this;
    }

    public OnboardWalkthrough setSkipVisibility(boolean isVisible){
        isSkipVisible = isVisible;
        return this;
    }

    public OnboardWalkthrough setSkipColor(String color){
        skipColor = color;
        return this;
    }


    public OnboardWalkthrough setProgressColor(String color){
        progressColor = color;
        return this;
    }

    public OnboardWalkthrough setProgressVisibility(boolean visibility){
        progressVisibility = visibility;
        return this;
    }



    private void fadeOut(final View v) {
        if (v.getVisibility() != View.GONE) {
            Animation fadeOut = new AlphaAnimation(1, 0);
            fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
            fadeOut.setDuration(100);
            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    v.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            v.startAnimation(fadeOut);
        }
    }

    private void fadeIn(final View v) {

        if (v.getVisibility() != View.VISIBLE) {
            Animation fadeIn = new AlphaAnimation(0, 1);
            fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
            fadeIn.setDuration(100);
            fadeIn.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    v.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    v.setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            v.startAnimation(fadeIn);
        }
    }

    private void showFinish() {
        getStarted.setVisibility(View.VISIBLE);
        this.getStarted.animate().translationY(0 - dpToPixels(5, context)).setInterpolator(new DecelerateInterpolator()).setDuration(500).start();
    }

    private void hideFinish() {

        this.getStarted.animate().translationY(this.getStarted.getBottom() + dpToPixels(100, context))
                .setInterpolator(new AccelerateInterpolator()).setDuration(250)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        getStarted.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                }).start();
    }

    public float dpToPixels(int dp, Context context) {
        return dp * (context.getResources().getDisplayMetrics().density);
    }

    private void setStatusBackgroundColor() {
        Activity activity = (Activity) context;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            activity.getWindow().getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
            activity.getWindow().setStatusBarColor(ContextCompat.getColor(context, R.color.black_transparent));
        }
    }

    public void build(){
        setStatusBackgroundColor();
        if(!isSkipVisible) skip.setVisibility(GONE);
        else{
            skip.setBackgroundColor(Color.parseColor(skipBackColor));
            skip.setTextSize(skipTextSize);
            skip.setTextColor(Color.parseColor(skipColor));
        }
        if (list.size() > 1) {
            next.setVisibility(View.VISIBLE);
        }

        if(startedTextSize != 0)
            getStarted.setTextSize(startedTextSize);

        setLayout(index);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllInvisible();
                if (index + 1 == list.size() - 1) {
                    fadeOut(next);
                    if(isStartedVisible) {
                        getStarted.setText(startedText);
                        getStarted.setTextColor(Color.parseColor(getStartedColor));
                        showFinish();
                    }
                }
                fadeIn(previous);
                index++;

                setLayout(index);

            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAllInvisible();
                hideFinish();
                if (index - 1 == 0) {
                    fadeOut(previous);

                }
                fadeIn(next);
                index--;

                setLayout(index);

            }
        });
    }

    private void setLayout(int index){
        Page page = list.get(index);

        RelativeLayout.LayoutParams relativeParam = (RelativeLayout.LayoutParams)titleContainer.getLayoutParams();
        if(page.getTitleLeft() == 0 && page.getTitleRight() == 0) relativeParam.addRule(RelativeLayout.CENTER_HORIZONTAL);
        if(page.getTitleTop() == 0 && page.getTitleBottom() == 0) relativeParam.addRule(RelativeLayout.CENTER_VERTICAL);
        relativeParam.setMargins(page.getTitleLeft(), page.getTitleTop(), page.getTitleRight(), page.getTitleBottom());
        titleContainer.setLayoutParams(relativeParam);

        if(page.getBackgroundPage() != null)
            layoutContainer.setBackgroundColor(Color.parseColor(page.getBackgroundPage()));

        if(page.getImagePage() != 0){
            img.setVisibility(VISIBLE);
            img.setImageResource(page.getImagePage());
        }

        if(page.getImgWidth() != 0 && page.getImgHeight() != 0){
            final float scale = getContext().getResources().getDisplayMetrics().density;
            int width = (int) (page.getImgWidth() * scale + 0.5f);
            int height = (int) (page.getImgHeight() * scale + 0.5f);

            RelativeLayout.LayoutParams relativeParams = (RelativeLayout.LayoutParams)imgContainer.getLayoutParams();
            if(page.getImgLeft() == 0 && page.getImgRight() == 0) relativeParams.addRule(RelativeLayout.CENTER_HORIZONTAL);
            relativeParams.setMargins(page.getImgLeft(), page.getImgTop(), page.getImgRight(), page.getImgBottom());
            relativeParams.height = height;
            relativeParams.width = width;

            imgContainer.setLayoutParams(relativeParams);

        }

        if(page.getTitleSize() != 0)
            title.setTextSize(page.getTitleSize());

        if(page.getDescSize() != 0)
            description.setTextSize(page.getDescSize());


        if(page.getTitlePage() != null){
            title.setVisibility(VISIBLE);
            title.setText(page.getTitlePage());
            title.setTextColor(Color.parseColor(page.getTitleColor()));
        }

        if(page.getDescriptionPage() != null){
            description.setVisibility(VISIBLE);
            description.setText(page.getDescriptionPage());
            description.setTextColor(Color.parseColor(page.getDescriptionColor()));
        }

        if(skipListener != null){
            skip.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    skipListener.OnClick();
                }
            });
        }

        if(getStartedListener != null){
            getStarted.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    getStartedListener.OnClick();
                }
            });
        }

        if(index == list.size() - 1) fadeOut(progressBar);
        else if(progressVisibility){
            fadeIn(progressBar);
            int progess = (100 / list.size()) * (index + 1) ;
            Drawable progressDrawable = progressBar.getProgressDrawable().mutate();
            progressDrawable.setColorFilter(Color.parseColor(progressColor), android.graphics.PorterDuff.Mode.SRC_IN);
            progressBar.setProgressDrawable(progressDrawable);
            progressBar.setProgress(progess);
        }
    }

    private void setAllInvisible(){
        img.setVisibility(GONE);
        title.setVisibility(GONE);
        description.setVisibility(GONE);
        getStarted.setVisibility(GONE);
        layoutContainer.setBackgroundColor(Color.TRANSPARENT);

        RelativeLayout.LayoutParams relativeParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        imgContainer.setLayoutParams(relativeParams);
    }
}
