package com.tencent.mm.ui.chatting;

import android.content.Context;
import android.view.MenuItem;
import com.tencent.mm.model.ah;
import com.tencent.mm.r.m;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.n.d;

final class dt$8
  implements n.d
{
  dt$8(String paramString, Context paramContext) {}
  
  public final void d(MenuItem paramMenuItem, int paramInt)
  {
    paramMenuItem = paramMenuItem.getTitle();
    u.i("!56@/B4Tb64lLpIXFj7yHqNALrvvAHq7Yqk22bT9FeAfy2TsmeBjP5KDgw==", "connector click[location]: to[%s] content[%s]", new Object[] { paramMenuItem, ldC });
    com.tencent.mm.modelmulti.h localh = new com.tencent.mm.modelmulti.h(paramMenuItem, ldC, 42);
    ah.tE().d(localh);
    com.tencent.mm.plugin.report.service.h.fUJ.g(10424, new Object[] { Integer.valueOf(42), Integer.valueOf(32), paramMenuItem });
    g.ba(val$context, val$context.getString(2131430904));
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.chatting.dt.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */