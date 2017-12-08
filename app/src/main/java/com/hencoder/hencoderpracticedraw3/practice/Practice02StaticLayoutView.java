package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;

public class Practice02StaticLayoutView extends View {
    TextPaint textPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG);
    String text = "Hello\nHenCoder";

    public Practice02StaticLayoutView(Context context) {
        super(context);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice02StaticLayoutView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        textPaint.setTextSize(60);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // 使用 StaticLayout 代替 Canvas.drawText() 来绘制文字，
        // 以绘制出带有换行的文字
//        canvas.drawText(text, 50, 100, textPaint);
        //CharSequence source, TextPaint paint, int width, Alignment align, float spacingmult, float spacingadd, boolean includepad
        //width--文字区域的宽度
        //align--文字对齐的方式
        //spacingmult--行间距的倍数 通常设置为1就好了
        //spacingadd--行间距额外的增加值，通常情况下填0
        //includepad--是否在文字的上下添加额外的区域，防止越界
        StaticLayout layout = new StaticLayout(text, textPaint, 500, Layout.Alignment.ALIGN_NORMAL, 1, 0, true);
        canvas.save();
        canvas.translate(50, 100);
        layout.draw(canvas);
        canvas.restore();
    }
}
