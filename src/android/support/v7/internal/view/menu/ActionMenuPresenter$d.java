package android.support.v7.internal.view.menu;

import android.content.Context;
import android.view.View;

final class ActionMenuPresenter$d
  extends k
{
  public ActionMenuPresenter$d(ActionMenuPresenter paramActionMenuPresenter, Context paramContext, f paramf, View paramView)
  {
    super(paramContext, paramf, paramView, true);
    mi = kS;
  }
  
  public final void onDismiss()
  {
    super.onDismiss();
    kU.iO.close();
    kU.kP = null;
  }
}

/* Location:
 * Qualified Name:     android.support.v7.internal.view.menu.ActionMenuPresenter.d
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */