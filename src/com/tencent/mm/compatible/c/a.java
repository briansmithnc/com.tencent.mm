package com.tencent.mm.compatible.c;

import android.media.AudioManager;
import com.tencent.mm.compatible.d.j;
import com.tencent.mm.compatible.d.p;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
{
  public static boolean a(AudioManager paramAudioManager)
  {
    if (!paramAudioManager.isBluetoothScoOn()) {}
    do
    {
      return true;
      if (ak.aKi) {
        return false;
      }
      if ((bsQbrB == 1) || (bsQbrC == -1)) {
        paramAudioManager.setBluetoothScoOn(false);
      }
    } while ((bsQbrB != 1) && (bsQbrC != -1));
    paramAudioManager.stopBluetoothSco();
    return true;
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.compatible.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */