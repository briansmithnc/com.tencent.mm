package com.tencent.mm.ui.applet;

import android.os.MessageQueue.IdleHandler;
import java.util.LinkedList;

final class b$1
  implements MessageQueue.IdleHandler
{
  b$1(b paramb) {}
  
  public final boolean queueIdle()
  {
    while (kzB.kzz.size() > 0)
    {
      String str = (String)kzB.kzz.removeFirst();
      kzB.kzA.hw(str);
    }
    return true;
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ui.applet.b.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */