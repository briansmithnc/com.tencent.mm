package com.tencent.mm.pluginsdk.ui.chat;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;

final class AppGrid$1
  implements AdapterView.OnItemClickListener
{
  AppGrid$1(AppGrid paramAppGrid) {}
  
  public final void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppGrid.c(iJC).a(AppGrid.c(iJC).oA(AppGrid.a(iJC) * AppGrid.b(iJC) + paramInt), AppGrid.d(iJC).mn(paramInt));
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.pluginsdk.ui.chat.AppGrid.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */