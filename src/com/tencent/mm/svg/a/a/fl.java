package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;

public final class fl
  extends c
{
  private final int height = 192;
  private final int width = 192;
  
  protected final int h(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 192;
      return 192;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      c.e(paramVarArgs);
      c.d(paramVarArgs);
      Object localObject1 = c.h(paramVarArgs);
      ((Paint)localObject1).setFlags(385);
      ((Paint)localObject1).setStyle(Paint.Style.FILL);
      Paint localPaint = c.h(paramVarArgs);
      localPaint.setFlags(385);
      localPaint.setStyle(Paint.Style.STROKE);
      ((Paint)localObject1).setColor(-16777216);
      localPaint.setStrokeWidth(1.0F);
      localPaint.setStrokeCap(Paint.Cap.BUTT);
      localPaint.setStrokeJoin(Paint.Join.MITER);
      localPaint.setStrokeMiter(4.0F);
      localPaint.setPathEffect(null);
      Object localObject2 = c.a(localPaint, paramVarArgs);
      ((Paint)localObject2).set(localPaint);
      ((Paint)localObject2).setStrokeWidth(1.0F);
      localCanvas.save();
      localPaint = c.a((Paint)localObject1, paramVarArgs);
      localPaint.set((Paint)localObject1);
      localPaint.setColor(-15158035);
      localObject2 = c.i(paramVarArgs);
      ((Path)localObject2).moveTo(0.0F, 0.0F);
      ((Path)localObject2).lineTo(192.0F, 0.0F);
      ((Path)localObject2).lineTo(192.0F, 192.0F);
      ((Path)localObject2).lineTo(0.0F, 192.0F);
      ((Path)localObject2).lineTo(0.0F, 0.0F);
      ((Path)localObject2).close();
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localPaint = c.a((Paint)localObject1, paramVarArgs);
      localPaint.set((Paint)localObject1);
      localPaint.setColor(-1);
      localObject1 = c.i(paramVarArgs);
      ((Path)localObject1).moveTo(142.54546F, 100.831314F);
      ((Path)localObject1).cubicTo(139.21634F, 92.18106F, 135.36592F, 85.41221F, 136.1254F, 75.06431F);
      ((Path)localObject1).cubicTo(134.93721F, 54.305878F, 117.50597F, 36.5975F, 97.60502F, 36.41379F);
      ((Path)localObject1).cubicTo(74.49456F, 36.5975F, 57.06332F, 54.305878F, 55.874607F, 75.06431F);
      ((Path)localObject1).cubicTo(56.631752F, 85.41221F, 52.78132F, 92.18106F, 49.454544F, 100.831314F);
      ((Path)localObject1).cubicTo(40.531776F, 114.37079F, 42.792137F, 131.66068F, 46.244514F, 133.04007F);
      ((Path)localObject1).cubicTo(48.937344F, 131.66068F, 53.50395F, 128.93271F, 59.08464F, 123.37745F);
      ((Path)localObject1).cubicTo(59.046963F, 129.886F, 62.21491F, 134.8965F, 65.5047F, 139.48183F);
      ((Path)localObject1).cubicTo(60.41336F, 140.68864F, 56.32277F, 143.90248F, 55.874607F, 145.92358F);
      ((Path)localObject1).cubicTo(56.75219F, 152.38712F, 65.80511F, 156.04285F, 75.134796F, 155.58621F);
      ((Path)localObject1).cubicTo(85.191315F, 155.14914F, 92.27135F, 152.36159F, 94.39498F, 149.14445F);
      ((Path)localObject1).cubicTo(95.27298F, 148.79735F, 95.62354F, 148.81863F, 97.60502F, 149.14445F);
      ((Path)localObject1).cubicTo(96.38775F, 148.81863F, 96.74691F, 148.79735F, 97.60502F, 149.14445F);
      ((Path)localObject1).cubicTo(99.75284F, 152.36159F, 106.82212F, 155.14914F, 116.865204F, 155.58621F);
      ((Path)localObject1).cubicTo(126.196144F, 156.04285F, 135.2462F, 152.38712F, 136.1254F, 145.92358F);
      ((Path)localObject1).cubicTo(135.67705F, 143.90106F, 131.58717F, 140.68864F, 126.4953F, 139.48183F);
      ((Path)localObject1).cubicTo(129.78922F, 134.8965F, 132.94926F, 129.89098F, 132.91536F, 123.37745F);
      ((Path)localObject1).cubicTo(138.50232F, 128.93483F, 143.06104F, 131.66068F, 145.7555F, 133.04007F);
      ((Path)localObject1).cubicTo(149.20982F, 131.66068F, 151.46875F, 114.37079F, 142.54546F, 100.831314F);
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.g(paramVarArgs);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.a.a.fl
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */