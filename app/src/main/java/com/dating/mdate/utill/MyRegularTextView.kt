package com.dating.mdate.utill

import android.content.Context
import android.graphics.Typeface
import android.os.Build
import android.support.annotation.RequiresApi
import android.util.AttributeSet
import android.widget.TextView

class MyRegularTextView : TextView {
    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        applyCustomFont(context)
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr){
        applyCustomFont(context)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes){
        applyCustomFont(context)
    }

    private fun applyCustomFont(context: Context) {
        val customFont = Typeface.createFromAsset(context.assets,
                "fonts/Barlow-Regular.otf")
        typeface = customFont
    }
}