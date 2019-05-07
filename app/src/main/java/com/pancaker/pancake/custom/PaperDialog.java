package com.pancaker.pancake.custom;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.pancaker.pancake.R;

/**
 * Created by jianbinggouzi on 19-5-6.
 */

public class PaperDialog extends Dialog {

    private Context mContext;
    private TextView mTitle;
    private TextView mContent;
    private Button mCheckButton;
    private TextView remark;

    public PaperDialog(Context context) {
        super(context);
        mContext = context;
    }
    public PaperDialog(Context context, int themeResId) {
        super(context, R.style.dialog);
        this.mContext = context;
    }
    protected PaperDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
    public void createDialog(){
        //获得inflater
        LayoutInflater inflater = LayoutInflater.from(mContext);
        //从xml转换为View
        View layoutView = inflater.inflate(R.layout.paperdialog, null);
        //PaperDialog将layoutView作为其View
        addContentView(layoutView, new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));//View的大小
        //标题
        mTitle = (TextView) layoutView.findViewById(R.id.paper_dialog_titleText);
        //内容
        mContent = (TextView) layoutView.findViewById(R.id.paper_dialog_contentText);

        remark = (TextView)layoutView.findViewById(R.id.dialog_remark);
        TextView ready = (TextView)layoutView.findViewById(R.id.ready);

        //确认按钮

    }
    public void setRemark(String arg){this.remark.setText(arg);}
    public void setTitle(String title){
        this.mTitle.setText(title);
    }
    public void setTitleSize(float size){
        this.mTitle.setTextSize(size);
    }
    public void setMessage(CharSequence message) {
        mContent.setText(message);
    }
    public void setMessageSize(float size){
        this.mContent.setTextSize(size);
    }
    public void setCheck(CharSequence checkContent) {
        mCheckButton.setText(checkContent);
    }
    public void setCheckSize(float size){
        this.mCheckButton.setTextSize(size);
    }
    public void setCheckOnClickListener(String check, View.OnClickListener onClickListener){
        



    }
}
