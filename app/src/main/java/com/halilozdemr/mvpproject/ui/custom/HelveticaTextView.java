package com.halilozdemr.mvpproject.ui.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class HelveticaTextView extends TextView {

    public HelveticaTextView(Context context) {
        super(context);
        initView(context);
    }


    public HelveticaTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public HelveticaTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);

    }

    private void initView(Context context) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/HelveticaNeueLTPro-Lt.otf"));
    }

}
