package com.tencent.mm.plugin.webview.ui.tools.jsapi;

import com.tencent.mm.ui.widget.MMWebView;

final class f$30
  implements Runnable
{
  f$30(f paramf, String paramString, boolean paramBoolean) {}
  
  public final void run()
  {
    try
    {
      f.c(irg).evaluateJavascript("javascript:WeixinJSBridge._handleMessageFromWeixin(" + irh + ")", new com.tencent.smtt.sdk.u() {});
      return;
    }
    catch (Exception localException)
    {
      com.tencent.mm.sdk.platformtools.u.e("!32@/B4Tb64lLpJkA9LZbWsTvpjmW6KIbHU+", "WNJSHandlerExportData fail, ex = %s", new Object[] { localException.getMessage() });
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.plugin.webview.ui.tools.jsapi.f.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */