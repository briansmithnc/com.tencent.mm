package com.tencent.mm.ag;

import android.os.HandlerThread;
import com.tencent.mm.a.f;
import com.tencent.mm.az.g;
import com.tencent.mm.model.ah;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.af.a;
import com.tencent.mm.sdk.platformtools.u;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

final class c$a
  extends af
{
  public c$a(c paramc, final List paramList, final LinkedList paramLinkedList)
  {
    super(tvjVF.getLooper(), new af.a()
    {
      private int bVf = 0;
      private int bXx = 0;
      
      public final boolean lj()
      {
        int j = 0;
        int k = paramList.size();
        int m = paramLinkedList.size();
        int i;
        Object localObject;
        if (k < m)
        {
          i = k;
          if (k != m) {
            u.w("!32@/B4Tb64lLpKS9SFT4r6jy7MddUmu706u", "summeroplog oplogSize[%d] not equal to resultSize[%d]! now size[%d] respIndex[%d]", new Object[] { Integer.valueOf(k), Integer.valueOf(m), Integer.valueOf(i), Integer.valueOf(bVf) });
          }
          localObject = new ArrayList();
          if (bVf < i) {
            break label158;
          }
          bDG = false;
          if (bXx > 0)
          {
            localObject = bOS;
            if (bOL.size() <= 0) {
              break label152;
            }
          }
        }
        label152:
        for (long l = 500L;; l = 0L)
        {
          ((af)localObject).ds(l);
          return false;
          i = m;
          break;
        }
        label158:
        k = bVf + 20;
        if (k > i) {}
        for (;;)
        {
          if (bVf < i)
          {
            k = ((Integer)paramLinkedList.get(bVf)).intValue();
            b.q localq = (b.q)paramList.get(bVf);
            m = id;
            u.d("!32@/B4Tb64lLpKS9SFT4r6jy7MddUmu706u", "summeroplog id:%d, cmd:%d, result:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localq.getCmdId()), Integer.valueOf(k) });
            if (k == 0)
            {
              bXx += 1;
              ((List)localObject).add(localq);
              bOL.remove(Integer.valueOf(m));
            }
            for (;;)
            {
              bVf += 1;
              break;
              if (k == 65103)
              {
                u.e("!32@/B4Tb64lLpKS9SFT4r6jy7MddUmu706u", "oplog not yet process, id:%d, cmd:%d", new Object[] { Integer.valueOf(m), Integer.valueOf(localq.getCmdId()) });
              }
              else
              {
                Integer localInteger = (Integer)bOL.get(Integer.valueOf(m));
                u.d("!32@/B4Tb64lLpKS9SFT4r6jy7MddUmu706u", "summeroplog id:%d, inserttime:%d, mapCnt:%d", new Object[] { Integer.valueOf(m), Long.valueOf(bOJ), localInteger });
                if (localInteger == null)
                {
                  bOL.d(Integer.valueOf(m), Integer.valueOf(1));
                }
                else if (localInteger.intValue() < 2)
                {
                  bOL.d(Integer.valueOf(m), Integer.valueOf(localInteger.intValue() + 1));
                }
                else
                {
                  u.d("!32@/B4Tb64lLpKS9SFT4r6jy7MddUmu706u", "summeroplog LRUMap Max now id:%d, inserttime:%d", new Object[] { Integer.valueOf(m), Long.valueOf(bOJ) });
                  ((List)localObject).add(localq);
                }
              }
            }
          }
          k = ((List)localObject).size();
          if (k > 0)
          {
            l = tDbzA.dH(Thread.currentThread().getId());
            i = j;
            while (i < k)
            {
              bXv.a((b.q)((List)localObject).get(i));
              i += 1;
            }
            tDbzA.dI(l);
          }
          return true;
          i = k;
        }
      }
      
      public final String toString()
      {
        return super.toString() + "|RespHandler";
      }
    }, true);
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.ag.c.a
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */