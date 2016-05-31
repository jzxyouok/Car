package com.example.car.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;
/**
 * 解决listview在scrollView中item显示不全的问题
 * @author zhang
 *
 * @date 2015-12-9
 */
public class FixScrollableListview extends ListView {

	public FixScrollableListview(Context context) {
		super(context);

	}

	public FixScrollableListview(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	public FixScrollableListview(Context context, AttributeSet attrs,
			int defStyleAttr) {
		super(context, attrs, defStyleAttr);

	}

	@Override
	public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

		int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
				MeasureSpec.AT_MOST);
		super.onMeasure(widthMeasureSpec, expandSpec);
	}

}
