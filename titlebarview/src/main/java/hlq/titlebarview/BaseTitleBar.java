package hlq.titlebarview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by  Huanglinqing on 2018/8/17/017.
 * QQ Email:1306214077@qq.com
 */

/**
 * 自定义titlebar，可组合样式，可设置左右两边是文字或图片或是否显示
 */
public class BaseTitleBar extends LinearLayout {

    /**
     * 声明titlebar属性
     *
     * @param context
     */
    private LinearLayout titlebarlinear;
    private TextView leftTextview;
    private TextView centerTextView;
    private TextView rightTextView;
    private ImageView leftimage;
    private ImageView rightimage;
    private int lefttext_color = Color.WHITE;
    private int righttext_color = Color.WHITE;
    private int back_color = Color.parseColor("#00BBFF");
    private boolean lefticon_isshow = false;
    private boolean righticon_isshow = false;
    private boolean lefttext_isshow = true;
    private boolean righttext_isshow = true;
    private String lefttext;
    private String centertext;
    private String righttext;
    private int lefticon;
    private int righticon;

    public BaseTitleBar(Context context) {
        super(context);
        init(context);
    }

    public BaseTitleBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray mTypeArrar = context.obtainStyledAttributes(attrs, R.styleable.BaseTitleBar);
        lefttext_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_lefttext_color, Color.WHITE);
        righttext_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_righttext_color, Color.WHITE);
        lefttext_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_lefttext_is_show, false);
        righttext_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_righttext_is_show, false);
        lefticon_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_lefticon_is_show, false);
        righticon_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_righticon_is_show, false);
        lefticon = mTypeArrar.getResourceId(R.styleable.BaseTitleBar_lefticon_src, 0);
        righticon = mTypeArrar.getResourceId(R.styleable.BaseTitleBar_righticon_src, 0);
        lefttext = mTypeArrar.getString(R.styleable.BaseTitleBar_lefttext);
        righttext = mTypeArrar.getString(R.styleable.BaseTitleBar_righttext);
        centertext = mTypeArrar.getString(R.styleable.BaseTitleBar_centertext);
        back_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_titlebarback_color,Color.parseColor("#00BBFF"));
        init(context);
    }

    public BaseTitleBar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray mTypeArrar = context.obtainStyledAttributes(attrs, R.styleable.BaseTitleBar);
        lefttext_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_lefttext_color, Color.WHITE);
        righttext_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_righttext_color, Color.WHITE);
        lefttext_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_lefttext_is_show, false);
        righttext_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_righttext_is_show, false);
        lefticon_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_lefticon_is_show, false);
        righticon_isshow = mTypeArrar.getBoolean(R.styleable.BaseTitleBar_righticon_is_show, false);
        lefticon = mTypeArrar.getResourceId(R.styleable.BaseTitleBar_lefticon_src, 0);
        righticon = mTypeArrar.getResourceId(R.styleable.BaseTitleBar_righticon_src, 0);
        lefttext = mTypeArrar.getString(R.styleable.BaseTitleBar_lefttext);
        righttext = mTypeArrar.getString(R.styleable.BaseTitleBar_righttext);
        centertext = mTypeArrar.getString(R.styleable.BaseTitleBar_centertext);
        back_color = mTypeArrar.getColor(R.styleable.BaseTitleBar_titlebarback_color,Color.parseColor("#00BBFF"));
        mTypeArrar.recycle();
        init(context);
    }

    /**
     * 初始化布局
     */
    public void init(Context context) {
        View v =LayoutInflater.from(context).inflate(R.layout.activiti_basetitle,this,true);
        leftTextview = v.findViewById(R.id.lefttext);
        centerTextView = v.findViewById(R.id.ceterntext);
        rightTextView = v.findViewById(R.id.righttext);
        leftimage = v.findViewById(R.id.lefticon);
        rightimage = v.findViewById(R.id.right_icon);
        titlebarlinear = v.findViewById(R.id.titlebarlinear);


        /**
         * 设置属性
         */
        if (lefttext_isshow){
            leftTextview.setVisibility(View.VISIBLE);
            leftTextview.setText(lefttext);
            leftTextview.setTextColor(lefttext_color);
        }
        if (righttext_isshow){
            rightTextView.setVisibility(View.VISIBLE);
            rightTextView.setText(righttext);
            rightTextView.setTextColor(righttext_color);
        }
        if (lefticon_isshow){
            leftimage.setVisibility(View.VISIBLE);
            leftimage.setImageDrawable(getResources().getDrawable(lefticon));
        }
        if (righticon_isshow){
            rightimage.setVisibility(View.VISIBLE);
            rightimage.setImageDrawable(getResources().getDrawable(righticon));
        }
        titlebarlinear.setBackgroundColor(back_color);
        centerTextView.setText(centertext);

    }

    /**
     * 左边监听事件
     */
    public void setOnLeftOnclickListener(OnClickListener onLeftOnclickListener){
        if (lefticon_isshow){
            leftimage.setOnClickListener(onLeftOnclickListener);
        }
        if (lefttext_isshow){
            leftTextview.setOnClickListener(onLeftOnclickListener);
        }
    }

    /**
     * 右边监听事件
     */
    public void setOnRightOnclickListener(OnClickListener onRightOnclickListener){
        if (righticon_isshow){
            rightimage.setOnClickListener(onRightOnclickListener);
        }
        if (righttext_isshow){
            rightTextView.setOnClickListener(onRightOnclickListener);
        }
    }


}
