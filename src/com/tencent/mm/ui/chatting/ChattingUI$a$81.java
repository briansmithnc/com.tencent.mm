package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.t.aj;
import com.tencent.mm.t.l;
import com.tencent.mm.t.n;
import com.tencent.mm.t.r;

final class ChattingUI$a$81
  implements DialogInterface.OnClickListener
{
  ChattingUI$a$81(ChattingUI.a parama) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    MlaF).field_hadAlert = 1;
    paramDialogInterface = ChattingUI.a.M(laF);
    if (paramDialogInterface != null)
    {
      field_brandFlag &= 0xFFFFFFFB;
      n.f(paramDialogInterface);
    }
    aj.xM().hd(laF.getTalkerUserName());
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.chatting.ChattingUI.a.81
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */