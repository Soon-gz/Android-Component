package com.example.componentservice.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class UnScrollableGridView extends GridView {

	public UnScrollableGridView(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public UnScrollableGridView(Context context) {
		super(context);
	}

	public UnScrollableGridView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
        int height = getMeasuredHeight();
        int width = getMeasuredWidth();
        setMeasuredDimension(width, height + 5);  //如果不加5的话，还是会可以滚动。
	}
}
