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

public final class ff
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
      localPaint.setColor(-12206054);
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
      ((Path)localObject1).moveTo(77.751686F, 74.35768F);
      ((Path)localObject1).cubicTo(77.10784F, 74.24245F, 76.437546F, 74.181816F, 75.742775F, 74.181816F);
      ((Path)localObject1).cubicTo(68.731544F, 74.181816F, 64.21282F, 80.35591F, 64.21282F, 86.517914F);
      ((Path)localObject1).cubicTo(64.21282F, 92.45541F, 66.23555F, 93.96758F, 68.60608F, 97.488045F);
      ((Path)localObject1).cubicTo(71.74681F, 102.15151F, 66.9005F, 104.17617F, 64.56203F, 105.4618F);
      ((Path)localObject1).cubicTo(56.168617F, 110.07818F, 52.363636F, 111.86741F, 52.363636F, 114.268745F);
      ((Path)localObject1).lineTo(52.363636F, 117.27127F);
      ((Path)localObject1).cubicTo(52.363636F, 118.38834F, 53.15544F, 119.27273F, 54.396816F, 119.27273F);
      ((Path)localObject1).lineTo(59.636364F, 119.27273F);
      ((Path)localObject1).lineTo(59.636364F, 116.56981F);
      ((Path)localObject1).cubicTo(59.636364F, 113.81923F, 68.907974F, 107.92832F, 78.46124F, 102.447945F);
      ((Path)localObject1).cubicTo(79.83735F, 101.658516F, 81.18256F, 101.458694F, 81.915855F, 100.97194F);
      ((Path)localObject1).cubicTo(81.78531F, 100.32185F, 81.84802F, 99.59008F, 82.1858F, 98.7616F);
      ((Path)localObject1).cubicTo(81.8437F, 97.943405F, 81.19023F, 96.83854F, 80.13573F, 95.31172F);
      ((Path)localObject1).cubicTo(76.655136F, 90.2713F, 76.38122F, 87.19079F, 76.38122F, 83.46266F);
      ((Path)localObject1).cubicTo(76.38122F, 81.69445F, 76.51388F, 77.87981F, 77.751686F, 74.35768F);
      ((Path)localObject1).lineTo(77.751686F, 74.35768F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(114.248314F, 74.35768F);
      ((Path)localObject1).cubicTo(114.89216F, 74.24245F, 115.562454F, 74.181816F, 116.257225F, 74.181816F);
      ((Path)localObject1).cubicTo(123.268456F, 74.181816F, 127.78718F, 80.35591F, 127.78718F, 86.517914F);
      ((Path)localObject1).cubicTo(127.78718F, 92.45541F, 125.76445F, 93.96758F, 123.39392F, 97.488045F);
      ((Path)localObject1).cubicTo(120.25319F, 102.15151F, 125.0995F, 104.17617F, 127.43797F, 105.4618F);
      ((Path)localObject1).cubicTo(135.83138F, 110.07818F, 139.63637F, 111.86741F, 139.63637F, 114.268745F);
      ((Path)localObject1).lineTo(139.63637F, 117.27127F);
      ((Path)localObject1).cubicTo(139.63637F, 118.38834F, 138.84456F, 119.27273F, 137.60318F, 119.27273F);
      ((Path)localObject1).lineTo(132.36363F, 119.27273F);
      ((Path)localObject1).lineTo(132.36363F, 116.56981F);
      ((Path)localObject1).cubicTo(132.36363F, 113.81923F, 123.092026F, 107.92832F, 113.53876F, 102.447945F);
      ((Path)localObject1).cubicTo(112.16265F, 101.658516F, 110.81744F, 101.458694F, 110.084145F, 100.97194F);
      ((Path)localObject1).cubicTo(110.21469F, 100.32185F, 110.15198F, 99.59008F, 109.8142F, 98.7616F);
      ((Path)localObject1).cubicTo(110.1563F, 97.943405F, 110.80977F, 96.83854F, 111.86427F, 95.31172F);
      ((Path)localObject1).cubicTo(115.344864F, 90.2713F, 115.61878F, 87.19079F, 115.61878F, 83.46266F);
      ((Path)localObject1).cubicTo(115.61878F, 81.69445F, 115.48612F, 77.87981F, 114.248314F, 74.35768F);
      ((Path)localObject1).lineTo(114.248314F, 74.35768F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(150.98181F, 52.363636F);
      ((Path)localObject1).cubicTo(154.35556F, 52.363636F, 157.09091F, 54.88189F, 157.09091F, 57.98788F);
      ((Path)localObject1).lineTo(157.09091F, 131.10303F);
      ((Path)localObject1).cubicTo(157.09091F, 134.20901F, 154.35556F, 136.72728F, 150.98181F, 136.72728F);
      ((Path)localObject1).lineTo(41.01818F, 136.72728F);
      ((Path)localObject1).cubicTo(37.644436F, 136.72728F, 34.909092F, 134.20901F, 34.909092F, 131.10303F);
      ((Path)localObject1).lineTo(34.909092F, 57.98788F);
      ((Path)localObject1).cubicTo(34.909092F, 54.88189F, 37.644436F, 52.363636F, 41.01818F, 52.363636F);
      ((Path)localObject1).lineTo(150.98181F, 52.363636F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(85.64386F, 136.72728F);
      ((Path)localObject1).lineTo(106.323654F, 136.72728F);
      ((Path)localObject1).cubicTo(107.28533F, 136.72728F, 108.00023F, 137.29198F, 107.43788F, 137.84982F);
      ((Path)localObject1).cubicTo(106.9877F, 138.2959F, 97.8959F, 147.2292F, 97.11818F, 147.99194F);
      ((Path)localObject1).cubicTo(96.60817F, 148.49194F, 95.38925F, 148.48311F, 94.87925F, 147.99194F);
      ((Path)localObject1).cubicTo(94.30792F, 147.44292F, 85.17125F, 138.47629F, 84.535614F, 137.8263F);
      ((Path)localObject1).cubicTo(84.07048F, 137.3508F, 84.58497F, 136.72728F, 85.64386F, 136.72728F);
      ((Path)localObject1).close();
      ((Path)localObject1).moveTo(80.935814F, 80.71342F);
      ((Path)localObject1).cubicTo(80.935814F, 88.75776F, 83.57856F, 90.806526F, 86.67572F, 95.57618F);
      ((Path)localObject1).cubicTo(90.77917F, 101.894424F, 84.447334F, 104.637505F, 81.39206F, 106.379326F);
      ((Path)localObject1).cubicTo(70.42586F, 112.63377F, 65.454544F, 115.0579F, 65.454544F, 118.311325F);
      ((Path)localObject1).lineTo(65.454544F, 122.37926F);
      ((Path)localObject1).cubicTo(65.454544F, 123.892715F, 66.48906F, 125.09091F, 68.11095F, 125.09091F);
      ((Path)localObject1).lineTo(123.88905F, 125.09091F);
      ((Path)localObject1).cubicTo(125.51094F, 125.09091F, 126.545456F, 123.892715F, 126.545456F, 122.37926F);
      ((Path)localObject1).lineTo(126.545456F, 118.311325F);
      ((Path)localObject1).cubicTo(126.545456F, 115.0579F, 121.57414F, 112.63377F, 110.60794F, 106.379326F);
      ((Path)localObject1).cubicTo(107.552666F, 104.637505F, 101.22083F, 101.894424F, 105.32428F, 95.57618F);
      ((Path)localObject1).cubicTo(108.42144F, 90.806526F, 111.064186F, 88.75776F, 111.064186F, 80.71342F);
      ((Path)localObject1).cubicTo(111.064186F, 72.3649F, 105.160355F, 64.0F, 96.0F, 64.0F);
      ((Path)localObject1).cubicTo(86.839645F, 64.0F, 80.935814F, 72.3649F, 80.935814F, 80.71342F);
      ((Path)localObject1).close();
      WeChatSVGRenderC2Java.setFillType((Path)localObject1, 2);
      localCanvas.drawPath((Path)localObject1, localPaint);
      localCanvas.restore();
      c.g(paramVarArgs);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.a.a.ff
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */