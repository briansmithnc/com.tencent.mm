package com.tencent.mm.sdk.platformtools;

import java.io.FileInputStream;
import java.io.FilterInputStream;
import java.nio.channels.FileChannel;

public final class i
  extends FilterInputStream
{
  private long cam = 0L;
  
  public i(FileInputStream paramFileInputStream)
  {
    super(paramFileInputStream);
  }
  
  public final void mark(int paramInt)
  {
    try
    {
      cam = ((FileInputStream)in).getChannel().position();
      return;
    }
    catch (Exception localException)
    {
      u.printErrStackTrace("MicroMsg.FileSeekingInputStream", localException, "Failed seeking FileChannel.", new Object[0]);
    }
  }
  
  public final boolean markSupported()
  {
    return true;
  }
  
  public final void reset()
  {
    ((FileInputStream)in).getChannel().position(cam);
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.sdk.platformtools.i
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */