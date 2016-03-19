package com.tencent.mm.ui.contact;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.ar.c;
import com.tencent.mm.aw.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MultiTouchImageView;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.MMGestureGallery;
import com.tencent.mm.ui.tools.n;
import java.io.File;

public class ContactRemarkImagePreviewUI
  extends MMActivity
{
  private MMGestureGallery dQq;
  private View ljk;
  private String ljl;
  private boolean ljm;
  private boolean ljn;
  private a ljo;
  private String username;
  
  private void hV(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Intent localIntent = new Intent();
      localIntent.putExtra("response_delete", true);
      setResult(-1, localIntent);
    }
    finish();
  }
  
  protected final void Gb()
  {
    ljk = findViewById(2131165619);
    dQq = ((MMGestureGallery)findViewById(2131165381));
    qb(2131428457);
    dQq.setVerticalFadingEdgeEnabled(false);
    dQq.setHorizontalFadingEdgeEnabled(false);
    com.tencent.mm.sdk.platformtools.k.H(dQq);
    ljo = new a();
    ljo.imagePath = ljl;
    dQq.setAdapter(ljo);
    dQq.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        if (!baV())
        {
          baU();
          return;
        }
        baT();
      }
    });
    a(0, 2130903464, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new n(ContactRemarkImagePreviewUI.this);
        hle = new n.c()
        {
          public final void a(l paramAnonymous2l)
          {
            if (!ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this)) {
              paramAnonymous2l.b(0, getString(2131430890));
            }
            paramAnonymous2l.b(1, getString(2131427823));
            if (c.yf("favorite")) {
              paramAnonymous2l.b(2, getString(2131431054));
            }
          }
        };
        hlf = new n.d()
        {
          public final void d(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            switch (paramAnonymous2MenuItem.getItemId())
            {
            default: 
              return;
            case 0: 
              if (!ContactRemarkImagePreviewUI.b(ContactRemarkImagePreviewUI.this))
              {
                ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
                return;
              }
              new File(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this)).delete();
              ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, true);
              return;
            case 1: 
              com.tencent.mm.pluginsdk.ui.tools.k.h(ContactRemarkImagePreviewUI.c(ContactRemarkImagePreviewUI.this), ContactRemarkImagePreviewUI.this);
              return;
            }
            ContactRemarkImagePreviewUI.d(ContactRemarkImagePreviewUI.this);
          }
        };
        paramAnonymousMenuItem.bH();
        return true;
      }
    });
    b(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ContactRemarkImagePreviewUI.a(ContactRemarkImagePreviewUI.this, false);
        return false;
      }
    });
  }
  
  protected final int getLayoutId()
  {
    return 2131361916;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    username = getIntent().getStringExtra("Contact_User");
    ljl = getIntent().getStringExtra("remark_image_path");
    ljm = getIntent().getBooleanExtra("view_temp_remark_image", false);
    ljn = getIntent().getBooleanExtra("view_only", false);
    if (ay.kz(username))
    {
      finish();
      return;
    }
    Gb();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      hV(false);
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  protected void onPause()
  {
    super.onPause();
  }
  
  final class a
    extends BaseAdapter
  {
    String imagePath;
    
    a() {}
    
    public final int getCount()
    {
      return 1;
    }
    
    public final Object getItem(int paramInt)
    {
      return imagePath;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      paramView = View.inflate(ContactRemarkImagePreviewUI.this, 2131361821, null);
      paramViewGroup = (MultiTouchImageView)paramView.findViewById(2131165228);
      paramView.setLayoutParams(new Gallery.LayoutParams(-1, -1));
      paramViewGroup.setLayoutParams(new LinearLayout.LayoutParams(-1, -1));
      Bitmap localBitmap = BackwardSupportUtil.b.b(imagePath, a.getDensity(ContactRemarkImagePreviewUI.this));
      int i;
      Matrix localMatrix;
      if (localBitmap != null)
      {
        paramInt = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getWidth();
        i = ContactRemarkImagePreviewUI.e(ContactRemarkImagePreviewUI.this).getHeight();
        localMatrix = new Matrix();
        localMatrix.reset();
        f1 = localBitmap.getWidth() / localBitmap.getHeight();
        f2 = localBitmap.getHeight() / localBitmap.getWidth();
        u.v("!32@/B4Tb64lLpJ8SVyOn6WIBnf/iMnAMEhc", "whDiv is " + f1 + " hwDiv is " + f2);
        if ((f2 < 2.0F) || (localBitmap.getHeight() < 480)) {
          break label308;
        }
        f1 = localBitmap.getWidth() / paramInt;
        f2 = paramInt / localBitmap.getWidth();
        if (f1 <= 1.0D) {
          break label280;
        }
        localMatrix.postScale(f2, f2);
        localBitmap.getHeight();
        localMatrix.postTranslate((paramInt - f2 * localBitmap.getWidth()) / 2.0F, 0.0F);
      }
      for (;;)
      {
        paramViewGroup.setImageMatrix(localMatrix);
        paramViewGroup.bN(localBitmap.getWidth(), localBitmap.getHeight());
        paramViewGroup.setImageBitmap(localBitmap);
        return paramView;
        label280:
        localMatrix.postScale(1.0F, 1.0F);
        localMatrix.postTranslate((paramInt - localBitmap.getWidth()) / 2, 0.0F);
        continue;
        label308:
        if ((f1 < 2.0F) || (localBitmap.getWidth() < 480)) {
          break;
        }
        f1 = localBitmap.getHeight() / 480.0F;
        f2 = 480.0F / localBitmap.getHeight();
        if (f1 > 1.0D)
        {
          localMatrix.postScale(f1, f2);
          localMatrix.postTranslate(0.0F, (i - 480) / 2);
        }
        else
        {
          localMatrix.postScale(1.0F, 1.0F);
          f1 = (i - localBitmap.getHeight()) / 2;
          u.d("!32@/B4Tb64lLpJ8SVyOn6WIBnf/iMnAMEhc", " offsety " + f1);
          localMatrix.postTranslate(0.0F, f1);
        }
      }
      float f1 = paramInt / localBitmap.getWidth();
      float f2 = i / localBitmap.getHeight();
      label471:
      float f3;
      if (f1 < f2)
      {
        f2 = localBitmap.getWidth() / paramInt;
        f3 = localBitmap.getHeight() / i;
        if (f2 <= f3) {
          break label565;
        }
        label502:
        if (f2 <= 1.0D) {
          break label572;
        }
        localMatrix.postScale(f1, f1);
      }
      for (;;)
      {
        localMatrix.postTranslate((paramInt - localBitmap.getWidth() * f1) / 2.0F, (i - f1 * localBitmap.getHeight()) / 2.0F);
        break;
        f1 = f2;
        break label471;
        label565:
        f2 = f3;
        break label502;
        label572:
        f1 = 1.0F;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.contact.ContactRemarkImagePreviewUI
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */