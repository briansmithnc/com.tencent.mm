package com.tencent.mm.ba;

import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.u;

public final class c$a
{
  int aJm;
  String className;
  int kjd;
  int kje;
  String savePath;
  
  public c$a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    className = paramString;
    aJm = paramInt1;
    kjd = paramInt2;
    kje = paramInt3;
    StringBuilder localStringBuilder1 = new StringBuilder();
    if (ay.kz(paramString))
    {
      localStringBuilder1.append(c.kiX).append("WEIXIN_").append(System.currentTimeMillis()).append(".trace");
      u.i("!44@/B4Tb64lLpJIMaaRtK4LLtb0dXv/4DByk4tlG3jBVb0=", "TRACE startMethod path %s traceSize : %d", new Object[] { localStringBuilder1.toString(), Integer.valueOf(paramInt2) });
      savePath = localStringBuilder1.toString();
      return;
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append(c.kiX).append(paramString).append("_");
    paramString = "";
    switch (paramInt1)
    {
    }
    for (;;)
    {
      localStringBuilder2.append(paramString).append(".trace");
      break;
      paramString = "onResume";
      continue;
      paramString = "onCreate";
      continue;
      paramString = "onPause";
      continue;
      paramString = "onScrool";
      continue;
      paramString = "all";
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ba.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */