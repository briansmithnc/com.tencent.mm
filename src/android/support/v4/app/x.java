package android.support.v4.app;

import android.app.RemoteInput;
import android.app.RemoteInput.Builder;

final class x
{
  static RemoteInput[] a(y.a[] paramArrayOfa)
  {
    if (paramArrayOfa == null) {
      return null;
    }
    RemoteInput[] arrayOfRemoteInput = new RemoteInput[paramArrayOfa.length];
    int i = 0;
    while (i < paramArrayOfa.length)
    {
      y.a locala = paramArrayOfa[i];
      arrayOfRemoteInput[i] = new RemoteInput.Builder(locala.getResultKey()).setLabel(locala.getLabel()).setChoices(locala.getChoices()).setAllowFreeFormInput(locala.getAllowFreeFormInput()).addExtras(locala.getExtras()).build();
      i += 1;
    }
    return arrayOfRemoteInput;
  }
}

/* Location:
 * Qualified Name:     android.support.v4.app.x
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */