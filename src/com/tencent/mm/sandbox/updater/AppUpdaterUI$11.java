package com.tencent.mm.sandbox.updater;

import android.content.Intent;
import com.tencent.mm.sdk.platformtools.ay;

final class AppUpdaterUI$11
  implements Runnable
{
  AppUpdaterUI$11(AppUpdaterUI paramAppUpdaterUI, String paramString) {}
  
  public final void run()
  {
    Intent localIntent = ay.Dh(jSV);
    jTb.startActivity(localIntent);
    AppUpdaterUI.f(jTb);
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.sandbox.updater.AppUpdaterUI.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */