package com.tencent.mm.ui.bindlinkedin;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

final class InviteLinkedInFriendUI$a
  implements TextWatcher
{
  private InviteLinkedInFriendUI$a(InviteLinkedInFriendUI paramInviteLinkedInFriendUI) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    int i = InviteLinkedInFriendUI.a(kNW).getText().length();
    int j = InviteLinkedInFriendUI.b(kNW).getText().length();
    if (i == 0) {
      InviteLinkedInFriendUI.a(kNW).setHint("");
    }
    if (j == 0) {
      InviteLinkedInFriendUI.b(kNW).setHint("");
    }
    if ((i == 0) || (j == 0))
    {
      kNW.bC(false);
      return;
    }
    kNW.bC(true);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.bindlinkedin.InviteLinkedInFriendUI.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */