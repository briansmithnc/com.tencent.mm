package com.tencent.mm.svg;

import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Looper;

public abstract class c
{
  public static Paint a(Paint paramPaint, Looper paramLooper)
  {
    return b.a(paramLooper, paramPaint);
  }
  
  public static float[] a(float[] paramArrayOfFloat, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6)
  {
    if (paramArrayOfFloat != null)
    {
      paramArrayOfFloat[0] = paramFloat1;
      paramArrayOfFloat[1] = paramFloat2;
      paramArrayOfFloat[2] = paramFloat3;
      paramArrayOfFloat[3] = paramFloat4;
      paramArrayOfFloat[4] = paramFloat5;
      paramArrayOfFloat[5] = paramFloat6;
      paramArrayOfFloat[6] = 0.0F;
      paramArrayOfFloat[7] = 0.0F;
      paramArrayOfFloat[8] = 1.0F;
    }
    return paramArrayOfFloat;
  }
  
  public static float[] d(Looper paramLooper)
  {
    return b.d(paramLooper);
  }
  
  public static Matrix e(Looper paramLooper)
  {
    return b.e(paramLooper);
  }
  
  public static void g(Looper paramLooper)
  {
    if (paramLooper != null) {
      b.c(paramLooper);
    }
  }
  
  public static Paint h(Looper paramLooper)
  {
    return b.a(paramLooper, null);
  }
  
  public static Path i(Looper paramLooper)
  {
    return b.f(paramLooper);
  }
  
  public abstract int h(int paramInt, Object... paramVarArgs);
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.c
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */