package com.tencent.mm.ui.account;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mm.plugin.a.b;

final class RegSetInfoUI$27
  implements DialogInterface.OnClickListener
{
  RegSetInfoUI$27(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    b.kC("R500_100");
    paramDialogInterface = new Intent(kwh, RegByEmailUI.class);
    paramDialogInterface.addFlags(67108864);
    kwh.startActivity(paramDialogInterface);
    kwh.finish();
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.account.RegSetInfoUI.27
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */