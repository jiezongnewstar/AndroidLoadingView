package com.jiajie.load;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;


/**
 * ┏┓　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * iBoosJie.　 ┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * 创建人：贾杰
 * 创建日期： 2017/6/19
 * 说明：
 * 修改：
 */
public class LoadingDialog extends Dialog{

    private LoadingView mLoadingView;

    private Builder mBuilder;

    public LoadingDialog(Builder builder) {
        super(builder.mContext, R.style.custom_dialog);
        mBuilder = builder;
        setCancelable(mBuilder.mCancelable);
        setCanceledOnTouchOutside(mBuilder.mCanceledOnTouchOutside);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialog);

        mLoadingView = (LoadingView) findViewById(R.id.loadView);

        mLoadingView.setDelay(mBuilder.mDelay);
        mLoadingView.setLoadingText(mBuilder.mLoadText);

        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                mLoadingView.setVisibility(View.GONE);
            }
        });
    }

    @Override
    public void show() {
        super.show();
        mLoadingView.setVisibility(View.VISIBLE);
    }

    public Builder getBuilder() {
        return mBuilder;
    }

    public static class Builder{

        private Context mContext;

        private int mDelay = 80;

        private CharSequence mLoadText;

        private boolean mCancelable = true;

        private boolean mCanceledOnTouchOutside = true;

        public Builder(Context context) {
            mContext = context;
        }

        public Builder delay(int delay) {
            mDelay = delay;
            return this;
        }

        public Builder loadText(CharSequence loadText) {
            mLoadText = loadText;
            return this;
        }

        public Builder loadText(int resId) {
            mLoadText = mContext.getString(resId);
            return this;
        }

        public Builder cancelable(boolean cancelable) {
            mCancelable = cancelable;
            mCanceledOnTouchOutside = cancelable;
            return this;
        }

        public Builder canceledOnTouchOutside(boolean canceledOnTouchOutside) {
            mCanceledOnTouchOutside = canceledOnTouchOutside;
            return this;
        }

        public LoadingDialog build(){
            return new LoadingDialog(this);
        }

        public LoadingDialog show(){
            LoadingDialog dialog = build();
            dialog.show();
            return dialog;
        }
    }
}
