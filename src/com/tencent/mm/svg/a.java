package com.tencent.mm.svg;

import android.os.Looper;
import java.util.HashMap;
import java.util.LinkedList;

final class a
{
  private HashMap khI = new HashMap();
  private LinkedList khJ = new LinkedList();
  
  /* Error */
  protected final void a(Looper paramLooper, Object paramObject)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 17	com/tencent/mm/svg/a:khI	Ljava/util/HashMap;
    //   6: aload_1
    //   7: invokevirtual 29	java/util/HashMap:containsKey	(Ljava/lang/Object;)Z
    //   10: ifne +32 -> 42
    //   13: new 19	java/util/LinkedList
    //   16: dup
    //   17: invokespecial 20	java/util/LinkedList:<init>	()V
    //   20: astore_3
    //   21: aload_0
    //   22: getfield 17	com/tencent/mm/svg/a:khI	Ljava/util/HashMap;
    //   25: aload_1
    //   26: aload_3
    //   27: invokevirtual 33	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   30: pop
    //   31: aload_3
    //   32: astore_1
    //   33: aload_1
    //   34: aload_2
    //   35: invokevirtual 36	java/util/LinkedList:add	(Ljava/lang/Object;)Z
    //   38: pop
    //   39: aload_0
    //   40: monitorexit
    //   41: return
    //   42: aload_0
    //   43: getfield 17	com/tencent/mm/svg/a:khI	Ljava/util/HashMap;
    //   46: aload_1
    //   47: invokevirtual 40	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   50: checkcast 19	java/util/LinkedList
    //   53: astore_1
    //   54: goto -21 -> 33
    //   57: astore_1
    //   58: aload_0
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	62	0	this	a
    //   0	62	1	paramLooper	Looper
    //   0	62	2	paramObject	Object
    //   20	12	3	localLinkedList	LinkedList
    // Exception table:
    //   from	to	target	type
    //   2	31	57	finally
    //   33	39	57	finally
    //   42	54	57	finally
  }
  
  protected final Object aYQ()
  {
    Object localObject1 = null;
    try
    {
      if (khJ.size() != 0) {
        localObject1 = khJ.poll();
      }
      return localObject1;
    }
    finally
    {
      localObject2 = finally;
      throw ((Throwable)localObject2);
    }
  }
  
  protected final void b(Looper paramLooper)
  {
    try
    {
      if (khI.containsKey(paramLooper))
      {
        paramLooper = (LinkedList)khI.remove(paramLooper);
        khJ.addAll(paramLooper);
      }
      return;
    }
    finally
    {
      paramLooper = finally;
      throw paramLooper;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.svg.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */