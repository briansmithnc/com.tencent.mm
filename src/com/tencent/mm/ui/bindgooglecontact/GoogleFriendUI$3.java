package com.tencent.mm.ui.bindgooglecontact;

import com.tencent.mm.modelfriend.ah;
import com.tencent.mm.modelfriend.p;
import com.tencent.mm.pluginsdk.ui.applet.a.a;
import com.tencent.mm.sdk.platformtools.u;

final class GoogleFriendUI$3
  implements a.a
{
  GoogleFriendUI$3(GoogleFriendUI paramGoogleFriendUI) {}
  
  public final void a(boolean paramBoolean1, boolean paramBoolean2, String paramString1, String paramString2)
  {
    u.d("!56@/B4Tb64lLpKHrGLZvbPyiIVQZqGB7lNLR9cEovBG92K66fy5loyLJw==", "MicroMsg.AddContact ok:%b hasSentVerify:%b", new Object[] { Boolean.valueOf(paramBoolean1), Boolean.valueOf(paramBoolean2) });
    if ((paramBoolean1) || (paramBoolean2))
    {
      u.d("!56@/B4Tb64lLpKHrGLZvbPyiIVQZqGB7lNLR9cEovBG92K66fy5loyLJw==", "gmailItem:%s", new Object[] { paramString2 });
      ah.zy().s(paramString2, 1);
    }
    for (;;)
    {
      GoogleFriendUI.a(kNj).Gk();
      return;
      ah.zy().s(paramString2, 2);
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.bindgooglecontact.GoogleFriendUI.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */