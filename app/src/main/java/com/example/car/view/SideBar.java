package com.example.car.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SectionIndexer;
import android.widget.TextView;

import com.example.car.R;
import com.example.car.xUtils.DisplayUtil;


/**
 * 自定义字母表侧边栏
 * 
 * @author blue
 *
 */
public class SideBar extends View
{
	// 字母表
	private char[] alphabet;
	// 列表
	private PinnedHeaderListView listView;
	private SectionIndexer sectionIndexer;
	// 提示对话框
	private TextView dialogText;

	public SideBar(Context context)
	{
		super(context);
		init();
	}

	public SideBar(Context context, AttributeSet attrs)
	{
		super(context, attrs);
		init();
	}

	public SideBar(Context context, AttributeSet attrs, int defStyle)
	{
		super(context, attrs, defStyle);
		init();
	}

	/**
	 * 初始化字母表
	 *
	 * @author blue
	 */
	private void init()
	{
		alphabet = new char[] { '#', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '*' };
	}

	public void setListView(PinnedHeaderListView listView)
	{
		this.listView = listView;
		sectionIndexer = (SectionIndexer) listView.getAdapter();
	}

	public void setTextView(TextView dialogText)
	{
		this.dialogText = dialogText;
	}

	@SuppressLint("ClickableViewAccessibility")
	public boolean onTouchEvent(MotionEvent event)
	{
		super.onTouchEvent(event);

		// 得到当前触摸y值
		int i = (int) event.getY();
		// 计算当前触摸位置属于哪个字母
		int idx = i / (getMeasuredHeight() / alphabet.length);
		if (idx >= alphabet.length)
		{
			idx = alphabet.length - 1;
		} else if (idx < 0)
		{
			idx = 0;
		}
		if (event.getAction() == MotionEvent.ACTION_DOWN || event.getAction() == MotionEvent.ACTION_MOVE)
		{
			// 触摸时设置字母表背景
			setBackgroundResource(R.drawable.fragment_find_brand_bg_sb);
			// 设置显示信息
			dialogText.setVisibility(View.VISIBLE);
			dialogText.setText(String.valueOf(alphabet[idx]));
			dialogText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 34);

			// 列表选中触摸字母对应项
			if (alphabet[idx] == '#')
			{
				listView.setSelection(0);
			} else
			{
				int position = sectionIndexer.getPositionForSection(alphabet[idx]);
				if (position == -1)
				{
					return true;
				}
				listView.setSelection(position);
			}
		} else
		{
			// 延迟1秒隐藏
			dialogText.postDelayed(new Runnable()
			{

				@Override
				public void run()
				{
					dialogText.setVisibility(View.INVISIBLE);
				}
			}, 1 * 1000);

		}
		if (event.getAction() == MotionEvent.ACTION_UP)
		{
			// 松开时设置字母表背景
			setBackgroundColor(getResources().getColor(android.R.color.transparent));
		}
		return true;
	}

	@SuppressLint("DrawAllocation")
	protected void onDraw(Canvas canvas)
	{
		Paint paint = new Paint();
		// 画笔颜色
		paint.setColor(getResources().getColor(R.color.sidebar_cl));
		// 绘制文字尺寸
		paint.setTextSize(DisplayUtil.sp2px(getContext(), 15));
		// 绘制位置居中
		paint.setTextAlign(Paint.Align.CENTER);
		// 绘制风格：粗体
		Typeface font = Typeface.create(Typeface.SANS_SERIF, Typeface.BOLD);
		paint.setTypeface(font);

		float widthCenter = getMeasuredWidth() / 2;
		if (alphabet.length > 0)
		{
			float height = getMeasuredHeight() / alphabet.length;
			for (int i = 0; i < alphabet.length; i++)
			{
				canvas.drawText(String.valueOf(alphabet[i]), widthCenter, (i + 1) * height, paint);
			}
		}
		this.invalidate();
		super.onDraw(canvas);
	}
}
