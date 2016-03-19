package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ab.a.a.c.a;
import com.tencent.mm.ab.n;
import com.tencent.mm.d.b.bg;
import com.tencent.mm.model.ah;
import com.tencent.mm.model.ar;
import com.tencent.mm.n.a.a;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ag;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.j;
import com.tencent.mm.ui.o;

final class ae
  extends aa.c
{
  private ChattingUI.a kTe;
  
  public ae()
  {
    super(60);
  }
  
  public final View a(LayoutInflater paramLayoutInflater, View paramView)
  {
    Object localObject;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof c)))
    {
      localObject = paramView;
      if (getTagtype == eLV) {}
    }
    else
    {
      if (!com.tencent.mm.aw.a.da(y.getContext())) {
        break label83;
      }
    }
    label83:
    for (paramLayoutInflater = new ax(paramLayoutInflater, 2131361979);; paramLayoutInflater = new ax(paramLayoutInflater, 2131361896))
    {
      paramLayoutInflater.setTag(new c(eLV).au(paramLayoutInflater));
      localObject = paramLayoutInflater;
      return (View)localObject;
    }
  }
  
  public final void a(aa.a parama, int paramInt, ChattingUI.a parama1, ag paramag, String paramString)
  {
    kTe = parama1;
    c localc = (c)parama;
    paramString = field_content;
    if (paramString != null) {}
    for (Object localObject = a.a.B(paramString, field_reserved);; localObject = null)
    {
      if (localObject != null)
      {
        if (field_isSend != 1) {
          break label352;
        }
        paramString = byD;
        if (!ay.kz(paramString)) {
          break label362;
        }
        paramString = description;
        kQs.setSingleLine(false);
        kQs.setMaxLines(3);
        label89:
        if (field_isSend != 1) {
          break label374;
        }
      }
      label352:
      label362:
      label374:
      for (String str = byE;; str = byF)
      {
        kQs.setText(e.a(koJ.kpc, paramString, kQs.getTextSize()));
        kQt.setText(e.a(koJ.kpc, str, kQt.getTextSize()));
        str = byG;
        paramString = str;
        if (ay.kz(str)) {
          paramString = title;
        }
        kQu.setText(paramString);
        str = byB;
        paramString = str;
        if (ay.kz(str)) {
          paramString = thumburl;
        }
        kQr.setImageBitmap(null);
        if (!ay.kz(paramString))
        {
          localObject = new c.a();
          bTG = ah.tD().ry();
          bTD = true;
          bTV = true;
          localObject = ((c.a)localObject).AA();
          n.As().a(paramString, kQr, (com.tencent.mm.ab.a.a.c)localObject);
        }
        kTa.setOnClickListener(kSE.kVs);
        kTa.setOnLongClickListener(kSE.kVu);
        parama1 = new dg(paramag, kTe.kAy, paramInt, null, 0, (byte)0);
        kTa.setTag(parama1);
        return;
        paramString = byC;
        break;
        kQs.setSingleLine(true);
        break label89;
      }
    }
  }
  
  public final boolean a(ContextMenu paramContextMenu, View paramView, ag paramag)
  {
    paramContextMenu.add(getTagposition, 100, 0, kTe.getString(2131427849));
    return false;
  }
  
  public final boolean a(final MenuItem paramMenuItem, final ChattingUI.a parama, final ag paramag)
  {
    switch (paramMenuItem.getItemId())
    {
    case 101: 
    case 102: 
    default: 
      return false;
    case 100: 
      ar.E(field_msgId);
      return true;
    }
    final String str1 = field_content;
    paramMenuItem = null;
    if (str1 != null) {
      paramMenuItem = a.a.B(str1, field_reserved);
    }
    if (paramMenuItem != null)
    {
      paramag = field_talker;
      str1 = byC;
      final String str2 = byD;
      final String str3 = byE;
      final String str4 = byF;
      final String str5 = byA;
      final String str6 = byH;
      paramMenuItem = byI;
      g.a(koJ.kpc, parama.getString(2131427972), parama.getString(2131431011), parama.getString(2131427971), parama.getString(2131430884), new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          paramAnonymousDialogInterface = new Intent();
          paramAnonymousDialogInterface.putExtra("key_scene", 1);
          paramAnonymousDialogInterface.putExtra("key_receiver", paramag);
          paramAnonymousDialogInterface.putExtra("key_receivertitle", str1);
          paramAnonymousDialogInterface.putExtra("key_sendertitle", str2);
          paramAnonymousDialogInterface.putExtra("key_sender_des", str3);
          paramAnonymousDialogInterface.putExtra("key_receiver_des", str4);
          paramAnonymousDialogInterface.putExtra("key_url", str5);
          paramAnonymousDialogInterface.putExtra("key_templateid", str6);
          paramAnonymousDialogInterface.putExtra("key_sceneid", paramMenuItem);
          com.tencent.mm.ar.c.c(parama.getActivity(), "wallet_index", ".ui.WalletSendC2CMsgUI", paramAnonymousDialogInterface);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
      });
    }
    return true;
  }
  
  public final boolean a(View paramView, ChattingUI.a parama, ag paramag)
  {
    paramView = field_content;
    if (paramView != null) {}
    for (paramView = a.a.B(paramView, field_reserved);; paramView = null)
    {
      if (paramView != null)
      {
        if (!ay.kz(byA)) {
          break label131;
        }
        paramag = url;
        if (ay.kz(byJ)) {
          break label308;
        }
        if (!byJ.startsWith("weixin://openNativeUrl/weixinHB/startreceivebizhbrequest")) {
          break label139;
        }
        paramag = new Intent();
        paramag.putExtra("key_way", 1);
        paramag.putExtra("key_native_url", byJ);
        paramag.putExtra("key_username", parama.getTalkerUserName());
        paramag.putExtra("key_static_from_scene", 100002);
        com.tencent.mm.ar.c.c(koJ.kpc, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", paramag);
      }
      label131:
      label139:
      label308:
      while ((ay.kz(paramag)) || (ay.kz(paramag)))
      {
        do
        {
          return true;
          paramag = byA;
          break;
          if (byJ.startsWith("wxpay://c2cbizmessagehandler/hongbao/receivehongbao"))
          {
            paramag = new Intent();
            if (kSI) {}
            for (int i = 0;; i = 1)
            {
              paramag.putExtra("key_way", i);
              paramag.putExtra("key_native_url", byJ);
              paramag.putExtra("key_username", parama.getTalkerUserName());
              com.tencent.mm.ar.c.c(koJ.kpc, "luckymoney", ".ui.LuckyMoneyReceiveUI", paramag);
              return true;
            }
          }
          u.i("!56@/B4Tb64lLpKwUcOR+EdWcmbiHpejF20af/lgEuroAC6p6YJL/El/vQ==", "native url not match:" + byJ + ", go webview:" + paramag);
        } while (ay.kz(paramag));
        paramView = new Intent();
        paramView.putExtra("rawUrl", paramag);
        com.tencent.mm.ar.c.c(koJ.kpc, "webview", ".ui.tools.WebViewUI", paramView);
        return true;
      }
      paramView = new Intent();
      paramView.putExtra("rawUrl", paramag);
      com.tencent.mm.ar.c.c(koJ.kpc, "webview", ".ui.tools.WebViewUI", paramView);
      return true;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.chatting.ae
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */