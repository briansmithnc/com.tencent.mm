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

public final class nr
  extends c
{
  private final int height = 108;
  private final int width = 108;
  
  protected final int h(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 108;
      return 108;
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
      ((Paint)localObject1).setColor(-5460820);
      localObject3 = c.a((float[])localObject3, 1.0F, 0.0F, 21.0F, 0.0F, 1.0F, 45.0F);
      ((Matrix)localObject2).reset();
      ((Matrix)localObject2).setValues((float[])localObject3);
      localCanvas.concat((Matrix)localObject2);
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(4.65F, 1.76F);
      ((Path)localObject3).cubicTo(9.01F, -0.47F, 14.83F, 2.41F, 15.78F, 7.19F);
      ((Path)localObject3).cubicTo(17.06F, 11.98F, 12.97F, 17.14F, 8.02F, 16.99F);
      ((Path)localObject3).cubicTo(4.06F, 17.14F, 0.96F, 13.96F, 0.0F, 10.33F);
      ((Path)localObject3).lineTo(0.0F, 7.82F);
      ((Path)localObject3).cubicTo(0.8F, 5.35F, 2.09F, 2.76F, 4.65F, 1.76F);
      ((Path)localObject3).lineTo(4.65F, 1.76F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject3 = c.i(paramVarArgs);
      ((Path)localObject3).moveTo(30.29F, 1.49F);
      ((Path)localObject3).cubicTo(34.28F, -0.09F, 39.2F, 2.27F, 40.52F, 6.32F);
      ((Path)localObject3).cubicTo(42.18F, 10.54F, 39.41F, 15.74F, 35.0F, 16.73F);
      ((Path)localObject3).cubicTo(31.13F, 17.86F, 26.72F, 15.45F, 25.47F, 11.65F);
      ((Path)localObject3).cubicTo(23.92F, 7.68F, 26.28F, 2.83F, 30.29F, 1.49F);
      ((Path)localObject3).lineTo(30.29F, 1.49F);
      ((Path)localObject3).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject3, 2);
      localCanvas.drawPath((Path)localObject3, (Paint)localObject2);
      localCanvas.restore();
      localCanvas.save();
      localObject2 = c.a((Paint)localObject1, paramVarArgs);
      ((Paint)localObject2).set((Paint)localObject1);
      localObject1 = c.i(paramVarArgs);
      ((Path)localObject1).moveTo(50.23F, 10.85F);
      ((Path)localObject1).cubicTo(48.89F, 6.03F, 53.07F, 0.83F, 58.04F, 1.01F);
      ((Path)localObject1).cubicTo(61.98F, 0.89F, 65.03F, 4.05F, 66.0F, 7.66F);
      ((Path)localObject1).lineTo(66.0F, 10.07F);
      ((Path)localObject1).cubicTo(65.25F, 12.58F, 63.98F, 15.22F, 61.39F, 16.23F);
      ((Path)localObject1).cubicTo(57.03F, 18.47F, 51.21F, 15.62F, 50.23F, 10.85F);
      ((Path)localObject1).lineTo(50.23F, 10.85F);
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
 * Qualified Name:     com.tencent.mm.svg.a.a.nr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */