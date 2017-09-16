package com.example.himanishah.uwatch;

import android.content.Context;

/**
 * Created by himanishah on 9/16/17.
 */

public class RectangularImageView extends android.support.v7.widget.AppCompatImageView {

    public RectangularImageView (Context context) {
        super(context);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        Double posterHeight = Math.floor(measuredWidth*1.5);
        setMeasuredDimension(measuredWidth, posterHeight.intValue());
    }
}