package com.tencent.mm.network;

import com.tencent.mm.plugin.report.service.KVReportJni.KVReportJava2C;

final class v$1
  implements Runnable
{
  v$1(v paramv, boolean paramBoolean1, long paramLong, String paramString, boolean paramBoolean2) {}
  
  public final void run()
  {
    if (cjz)
    {
      KVReportJni.KVReportJava2C.writeImportKvData(cjA, cjB, cjC);
      return;
    }
    KVReportJni.KVReportJava2C.writeKvData(cjA, cjB, cjC);
  }
  
  public final String toString()
  {
    return super.toString() + "|reportKV";
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.network.v.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */