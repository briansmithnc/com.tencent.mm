package com.tencent.mm.ui.bindqq;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.widget.EditText;
import com.tencent.mm.ui.base.h;

final class StartUnbindQQ$2$2
  implements DialogInterface.OnClickListener
{
  StartUnbindQQ$2$2(StartUnbindQQ.2 param2) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StartUnbindQQ.c(kPG.kPF).setText("");
    StartUnbindQQ.a(kPG.kPF).dismiss();
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.bindqq.StartUnbindQQ.2.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */