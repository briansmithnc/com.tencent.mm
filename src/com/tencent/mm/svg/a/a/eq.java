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

public final class eq
  extends c
{
  private final int height = 240;
  private final int width = 240;
  
  protected final int h(int paramInt, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      return 0;
      return 240;
      return 240;
      Canvas localCanvas = (Canvas)paramVarArgs[0];
      paramVarArgs = (Looper)paramVarArgs[1];
      Matrix localMatrix = c.e(paramVarArgs);
      float[] arrayOfFloat = c.d(paramVarArgs);
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
      localPaint.setColor(-1);
      localObject2 = c.i(paramVarArgs);
      ((Path)localObject2).moveTo(114.11689F, 70.98039F);
      ((Path)localObject2).cubicTo(111.951485F, 70.98039F, 110.27686F, 72.72528F, 110.37761F, 74.90139F);
      ((Path)localObject2).lineTo(113.37151F, 139.56976F);
      ((Path)localObject2).cubicTo(113.42262F, 140.6737F, 114.36253F, 141.56863F, 115.46362F, 141.56863F);
      ((Path)localObject2).lineTo(124.53638F, 141.56863F);
      ((Path)localObject2).cubicTo(125.64071F, 141.56863F, 126.57727F, 140.67613F, 126.62849F, 139.56976F);
      ((Path)localObject2).lineTo(129.62239F, 74.90139F);
      ((Path)localObject2).cubicTo(129.72266F, 72.73588F, 128.0466F, 70.98039F, 125.88311F, 70.98039F);
      ((Path)localObject2).lineTo(114.11689F, 70.98039F);
      ((Path)localObject2).close();
      ((Path)localObject2).moveTo(120.0F, 172.94118F);
      ((Path)localObject2).cubicTo(125.41456F, 172.94118F, 129.80392F, 168.5518F, 129.80392F, 163.13725F);
      ((Path)localObject2).cubicTo(129.80392F, 157.7227F, 125.41456F, 153.33333F, 120.0F, 153.33333F);
      ((Path)localObject2).cubicTo(114.58544F, 153.33333F, 110.196075F, 157.7227F, 110.196075F, 163.13725F);
      ((Path)localObject2).cubicTo(110.196075F, 168.5518F, 114.58544F, 172.94118F, 120.0F, 172.94118F);
      ((Path)localObject2).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject2, 2);
      localCanvas.drawPath((Path)localObject2, localPaint);
      localCanvas.restore();
      localCanvas.save();
      arrayOfFloat = c.a(arrayOfFloat, 1.0F, 0.0F, 58.0F, 0.0F, 1.0F, 75.0F);
      localMatrix.reset();
      localMatrix.setValues(arrayOfFloat);
      localCanvas.concat(localMatrix);
      localCanvas.save();
      localPaint = c.a((Paint)localObject1, paramVarArgs);
      localPaint.set((Paint)localObject1);
      localPaint.setColor(-16139513);
      localObject1 = c.i(paramVarArgs);
      ((Path)localObject1).moveTo(88.503105F, 63.260868F);
      ((Path)localObject1).cubicTo(81.83925F, 55.480328F, 72.46273F, 51.086956F, 62.509315F, 51.086956F);
      ((Path)localObject1).cubicTo(51.689445F, 51.086956F, 42.312923F, 55.480328F, 35.649067F, 63.260868F);
      ((Path)localObject1).lineTo(42.580746F, 70.21739F);
      ((Path)localObject1).cubicTo(47.99571F, 65.064156F, 54.781292F, 61.847816F, 62.509315F, 62.391304F);
      ((Path)localObject1).cubicTo(69.71429F, 61.847816F, 76.405556F, 64.96478F, 81.57143F, 70.21739F);
      ((Path)localObject1).lineTo(88.503105F, 63.260868F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(61.642857F, 25.869566F);
      ((Path)localObject1).cubicTo(44.52152F, 25.869566F, 28.799698F, 32.994526F, 17.453417F, 45.0F);
      ((Path)localObject1).lineTo(25.251553F, 52.826088F);
      ((Path)localObject1).cubicTo(35.159626F, 43.23779F, 48.249474F, 37.29962F, 62.509315F, 37.173912F);
      ((Path)localObject1).cubicTo(76.95079F, 37.29962F, 89.85206F, 43.048466F, 98.90062F, 51.95652F);
      ((Path)localObject1).lineTo(106.69876F, 45.0F);
      ((Path)localObject1).cubicTo(95.32615F, 33.14707F, 79.4547F, 25.869566F, 61.642857F, 25.869566F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(124.02795F, 26.73913F);
      ((Path)localObject1).cubicTo(108.21251F, 10.5176935F, 86.30065F, 0.65217394F, 62.509315F, 0.65217394F);
      ((Path)localObject1).cubicTo(37.861656F, 0.65217394F, 15.941242F, 10.526303F, 0.124223605F, 26.73913F);
      ((Path)localObject1).lineTo(7.9223604F, 34.565216F);
      ((Path)localObject1).cubicTo(22.125067F, 20.522926F, 41.417408F, 11.826344F, 62.509315F, 11.956522F);
      ((Path)localObject1).cubicTo(83.71855F, 11.826344F, 102.73295F, 20.24566F, 116.22981F, 33.695652F);
      ((Path)localObject1).lineTo(124.02795F, 26.73913F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(71.17391F, 80.652176F);
      ((Path)localObject1).cubicTo(68.97959F, 77.84855F, 65.76467F, 76.304344F, 62.509315F, 76.304344F);
      ((Path)localObject1).cubicTo(58.48254F, 76.304344F, 55.174686F, 77.95143F, 52.97826F, 80.652176F);
      ((Path)localObject1).lineTo(61.642857F, 89.347824F);
      ((Path)localObject1).lineTo(71.17391F, 80.652176F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      localCanvas.save();
      localObject1 = c.a(arrayOfFloat, 1.0F, 0.0F, 0.095238F, 0.0F, 1.0F, 0.652174F);
      localMatrix.reset();
      localMatrix.setValues((float[])localObject1);
      localCanvas.concat(localMatrix);
      localCanvas.restore();
      localCanvas.restore();
      c.g(paramVarArgs);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.a.a.eq
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */