package com.jye.devkit.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.EditText;

import androidx.appcompat.widget.AppCompatEditText;

import com.jye.devkit.ui.R;

/**
 * 每n位自动添加在后面添加空格的EditText（默认每4位）
 *
 * @author jye
 * @since 1.0
 */
public class DkSpaceEditText extends AppCompatEditText {

    //跨度（每隔n位添加一个空格）
    private int mAttrSpan = 4;

    //上次输入框中的内容
    private String mLastString;

    //光标的位置
    private int mSelectPosition;

    //输入框内容改变监听
    private TextChangeListener mTextChangeListener;

    public DkSpaceEditText(Context context, int span) {
        super(context);
        mAttrSpan = span;
        initView();
    }

    public DkSpaceEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        initAttr(attrs);
        initView();

    }

    public DkSpaceEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initAttr(attrs);
        initView();
    }

    private void initAttr(AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.DkSpaceEditText);

            if (typedArray.hasValue(R.styleable.DkSpaceEditText_dk_space_span)) {
                mAttrSpan = typedArray.getInt(R.styleable.DkSpaceEditText_dk_space_span, mAttrSpan);
            }

            typedArray.recycle();
        }
    }

    private void initView() {
        addTextChangedListener(new DkSimpleTextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                //因为重新排序之后setText的存在
                //会导致输入框的内容从0开始输入，这里是为了避免这种情况产生一系列问题
                if (start == 0 && count > 1 && DkSpaceEditText.this.getSelectionStart() == 0) {
                    return;
                }

                String textTrim = getTextTrim(DkSpaceEditText.this);
                if (TextUtils.isEmpty(textTrim)) {
                    return;
                }

                //如果 before > 0 && count == 0,代表此次操作是删除操作
                if (before > 0 && count == 0) {
                    mSelectPosition = start;
                    //将上次的字符串去空格后 和 改变之后的字符串去空格 进行比较
                    //如果一致，代表本次操作删除的是空格
                    //帮助用户删除该删除的字符，而不是空格
                    if (!TextUtils.isEmpty(mLastString)
                            && textTrim.equals(mLastString.replaceAll(" ", ""))) {
                        StringBuilder stringBuilder = new StringBuilder(mLastString);
                        stringBuilder.deleteCharAt(start - 1);
                        mSelectPosition = start - 1;
                        DkSpaceEditText.this.setText(stringBuilder.toString());
                    }
                }
                //此处代表是添加操作
                else {
                    //当光标位于空格之前，添加字符时，需要让光标跳过空格，再按照之前的逻辑计算光标位置
                    if ((start + count) % (mAttrSpan + 1) == 0) {
                        mSelectPosition = start + count + 1;
                    } else {
                        mSelectPosition = start + count;
                    }
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                //获取输入框中的内容,不可以去空格
                String etContent = getText(DkSpaceEditText.this);
                if (TextUtils.isEmpty(etContent)) {
                    if (mTextChangeListener != null) {
                        mTextChangeListener.onTextChanged("");
                    }
                    return;
                }

                //重新拼接字符串
                String newContent = appendSpace(etContent);
                //保存本次字符串数据
                mLastString = newContent;

                //如果有改变，则重新填充
                //防止EditText无限setText()产生死循环
                if (!newContent.equals(etContent)) {
                    DkSpaceEditText.this.setText(newContent);
                    //保证光标的位置
                    DkSpaceEditText.this.setSelection(Math.min(mSelectPosition, newContent.length()));
                }

                //触发回调内容
                if (mTextChangeListener != null) {
                    mTextChangeListener.onTextChanged(newContent);
                }

            }
        });
    }

    private String appendSpace(String content) {
        if (TextUtils.isEmpty(content)) {
            return "";
        }

        String contentTrim = content.replaceAll(" ", "");
        if (TextUtils.isEmpty(contentTrim)) {
            return "";
        }

        StringBuilder newString = new StringBuilder();
        for (int i = 0; i < contentTrim.length(); i++) {
            newString.append(contentTrim.charAt(i));
            if ((i + 1) % mAttrSpan == 0 && i < contentTrim.length() - 1) {
                newString.append(" ");
            }
        }
        return newString.toString();
    }

    private static String getText(EditText text) {
        return text.getText().toString();
    }

    private static String getTextTrim(EditText text) {
        return getText(text).replaceAll(" ", "");
    }

    /**
     * 输入框内容回调，当输入框内容改变时会触发
     */
    public interface TextChangeListener {
        void onTextChanged(String text);
    }

    public void setTextChangeListener(TextChangeListener listener) {
        this.mTextChangeListener = listener;
    }
}