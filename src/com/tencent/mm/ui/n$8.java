package com.tencent.mm.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.modelsimple.d;
import com.tencent.mm.ui.base.b;

final class n$8
  implements DialogInterface.OnClickListener
{
  n$8(Intent paramIntent, Activity paramActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (kqi != null)
    {
      if (!(cms instanceof LauncherUI)) {
        cms.finish();
      }
      cms.startActivity(kqi);
      b.w(cms, kqi);
      d.aW(cms);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.n.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */