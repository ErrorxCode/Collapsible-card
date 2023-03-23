package com.errorxcode.card;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CollapsibleCard extends RelativeLayout {
    private boolean isCollapsed;
    private AutoTransition transition = new AutoTransition();

    public CollapsibleCard(@NonNull Context context) {
        super(context);
        init();
    }

    public CollapsibleCard(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CollapsibleCard(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){
        GradientDrawable drawable = new GradientDrawable();
        drawable.setCornerRadius(10);
        drawable.setColor(Color.WHITE);
        setPadding(10,10,10,10);
        setBackground(drawable);
        setElevation(10);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        var layout = this;
        for (int i = 0; i < layout.getChildCount(); i++) {
            var view = layout.getChildAt(i);
            if ("main".equals(view.getTag()))
                view.setOnClickListener(v -> {
                    if (isCollapsed)
                        expand();
                    else
                        collapse();
                });
        }
        collapse();
    }

    public void collapse() {
        var layout = this;
        for (int i = 1; i < layout.getChildCount(); i++) {
            var view = layout.getChildAt(i);
            if (!"main".equals(view.getTag())){
                view.setVisibility(GONE);
            }
        }
        TransitionManager.beginDelayedTransition(this,transition);
        isCollapsed = true;
    }

    public void expand() {
        TransitionManager.beginDelayedTransition(this,transition);
        var layout = this;
        for (int i = 1; i < layout.getChildCount(); i++) {
            layout.getChildAt(i).setVisibility(View.VISIBLE);
        }
        isCollapsed = false;
    }

    public void setCustomTransition(AutoTransition transition) {
        this.transition = transition;
    }
}
