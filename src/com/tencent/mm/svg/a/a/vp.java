package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class vp
  extends c
{
  private final int height = 90;
  private final int width = 90;
  
  protected final int h(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 90;
      return 90;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Object localObject2 = c.e(paramVarArgs);
      Object localObject3 = c.d(paramVarArgs);
      Paint localPaint1 = c.h(paramVarArgs);
      localPaint1.setFlags(385);
      localPaint1.setStyle(Paint.Style.FILL);
      Object localObject1 = c.h(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.STROKE);
      localPaint1.setColor(-16777216);
      ((Paint)localObject1).setStrokeWidth(1.0F);
      ((Paint)localObject1).setStrokeCap(Paint.Cap.BUTT);
      ((Paint)localObject1).setStrokeJoin(Paint.Join.MITER);
      ((Paint)localObject1).setStrokeMiter(4.0F);
      ((Paint)localObject1).setPathEffect(null);
      Paint localPaint2 = c.a((Paint)localObject1, paramVarArgs);
      localPaint2.set((Paint)localObject1);
      localPaint2.setStrokeWidth(1.0F);
      localCanvas.save();
      localObject1 = c.a(localPaint1, paramVarArgs);
      ((Paint)localObject1).set(localPaint1);
      ((Paint)localObject1).setColor(-1);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 16.0F, 0.0F, 1.0F, 30.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(1.7763568E-15F, 0.0F);
      ((Path)localObject3).lineTo(6.0F, 0.0F);
      ((Path)localObject3).cubicTo(5.9900165F, 2.0F, 5.9900165F, 4.0F, 6.0F, 6.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 6.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 0.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(10.0F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 0.0F);
      ((Path)localObject3).lineTo(16.0F, 6.0F);
      ((Path)localObject3).lineTo(10.0F, 6.0F);
      ((Path)localObject3).cubicTo(10.009983F, 4.0F, 10.009983F, 2.0F, 10.0F, 0.0F);
      ((Path)localObject3).lineTo(10.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(21.0F, 0.0F);
      ((Path)localObject3).lineTo(27.0F, 0.0F);
      ((Path)localObject3).lineTo(27.0F, 6.0F);
      ((Path)localObject3).lineTo(21.0F, 6.0F);
      ((Path)localObject3).lineTo(21.0F, 0.0F);
      ((Path)localObject3).lineTo(21.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(31.0F, 0.0F);
      ((Path)localObject3).lineTo(37.0F, 0.0F);
      ((Path)localObject3).lineTo(37.0F, 6.0F);
      ((Path)localObject3).lineTo(31.0F, 6.0F);
      ((Path)localObject3).cubicTo(31.009983F, 4.0F, 31.009983F, 2.0F, 31.0F, 0.0F);
      ((Path)localObject3).lineTo(31.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(42.0F, 0.0F);
      ((Path)localObject3).lineTo(48.0F, 0.0F);
      ((Path)localObject3).cubicTo(47.990017F, 2.0F, 47.990017F, 4.0F, 48.0F, 6.0F);
      ((Path)localObject3).lineTo(42.0F, 6.0F);
      ((Path)localObject3).lineTo(42.0F, 0.0F);
      ((Path)localObject3).lineTo(42.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(52.0F, 0.0F);
      ((Path)localObject3).lineTo(58.0F, 0.0F);
      ((Path)localObject3).lineTo(58.0F, 6.0F);
      ((Path)localObject3).lineTo(52.0F, 6.0F);
      ((Path)localObject3).cubicTo(52.009983F, 4.0F, 52.009983F, 2.0F, 52.0F, 0.0F);
      ((Path)localObject3).lineTo(52.0F, 0.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(1.7763568E-15F, 12.0F);
      ((Path)localObject3).lineTo(6.0F, 12.0F);
      ((Path)localObject3).cubicTo(5.9900165F, 14.0F, 5.9900165F, 16.0F, 6.0F, 18.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 18.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 12.0F);
      ((Path)localObject3).lineTo(1.7763568E-15F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(10.0F, 12.0F);
      ((Path)localObject3).lineTo(16.0F, 12.0F);
      ((Path)localObject3).lineTo(16.0F, 18.0F);
      ((Path)localObject3).lineTo(10.0F, 18.0F);
      ((Path)localObject3).cubicTo(10.009983F, 16.0F, 10.009983F, 14.0F, 10.0F, 12.0F);
      ((Path)localObject3).lineTo(10.0F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(21.0F, 12.0F);
      ((Path)localObject3).lineTo(27.0F, 12.0F);
      ((Path)localObject3).lineTo(27.0F, 18.0F);
      ((Path)localObject3).lineTo(21.0F, 18.0F);
      ((Path)localObject3).lineTo(21.0F, 12.0F);
      ((Path)localObject3).lineTo(21.0F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(31.0F, 12.0F);
      ((Path)localObject3).lineTo(37.0F, 12.0F);
      ((Path)localObject3).lineTo(37.0F, 18.0F);
      ((Path)localObject3).lineTo(31.0F, 18.0F);
      ((Path)localObject3).lineTo(31.0F, 12.0F);
      ((Path)localObject3).lineTo(31.0F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(42.0F, 12.0F);
      ((Path)localObject3).lineTo(48.0F, 12.0F);
      ((Path)localObject3).lineTo(48.0F, 18.0F);
      ((Path)localObject3).lineTo(42.0F, 18.0F);
      ((Path)localObject3).lineTo(42.0F, 12.0F);
      ((Path)localObject3).lineTo(42.0F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(52.0F, 12.0F);
      ((Path)localObject3).lineTo(58.0F, 12.0F);
      ((Path)localObject3).lineTo(58.0F, 18.0F);
      ((Path)localObject3).lineTo(52.0F, 18.0F);
      ((Path)localObject3).cubicTo(52.009983F, 16.0F, 52.009983F, 14.0F, 52.0F, 12.0F);
      ((Path)localObject3).lineTo(52.0F, 12.0F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject1 = c.i(paramVarArgs);
      ((Path)localObject1).moveTo(10.0F, 24.0F);
      ((Path)localObject1).lineTo(48.0F, 24.0F);
      ((Path)localObject1).cubicTo(47.989872F, 25.99852F, 47.989872F, 27.99704F, 48.0F, 30.0F);
      ((Path)localObject1).cubicTo(35.329956F, 30.005552F, 22.670042F, 29.99556F, 10.0F, 30.0F);
      ((Path)localObject1).cubicTo(10.010128F, 27.99704F, 10.010128F, 25.99852F, 10.0F, 24.0F);
      ((Path)localObject1).lineTo(10.0F, 24.0F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.restore();
      c.g(paramVarArgs);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.a.a.vp
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */