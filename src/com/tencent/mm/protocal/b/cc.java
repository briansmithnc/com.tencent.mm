package com.tencent.mm.protocal.b;

import a.a.a.b;
import java.util.LinkedList;

public final class cc
  extends com.tencent.mm.at.a
{
  public alx iZy;
  public ku iZz;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (iZy == null) {
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      if (iZy != null)
      {
        paramVarArgs.cj(2, iZy.kn());
        iZy.a(paramVarArgs);
      }
      if (iZz != null)
      {
        paramVarArgs.cj(3, iZz.kn());
        iZz.a(paramVarArgs);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (iZy == null) {
        break label454;
      }
    }
    label454:
    for (paramInt = a.a.a.a.ch(2, iZy.kn()) + 0;; paramInt = 0)
    {
      int i = paramInt;
      if (iZz != null) {
        i = paramInt + a.a.a.a.ch(3, iZz.kn());
      }
      return i;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], iTR);
        for (paramInt = com.tencent.mm.at.a.a(paramVarArgs); paramInt > 0; paramInt = com.tencent.mm.at.a.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.bog();
          }
        }
        if (iZy != null) {
          break;
        }
        throw new b("Not all required fields were included: AesEncryptKey");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
        cc localcc = (cc)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
        switch (paramInt)
        {
        default: 
          return -1;
        case 2: 
          paramVarArgs = ((a.a.a.a.a)localObject1).sJ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new alx();
            localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
            for (bool = true; bool; bool = ((alx)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, com.tencent.mm.at.a.a((a.a.a.a.a)localObject2))) {}
            iZy = ((alx)localObject1);
            paramInt += 1;
          }
        }
        paramVarArgs = ((a.a.a.a.a)localObject1).sJ(paramInt);
        i = paramVarArgs.size();
        paramInt = 0;
        while (paramInt < i)
        {
          localObject2 = (byte[])paramVarArgs.get(paramInt);
          localObject1 = new ku();
          localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
          for (bool = true; bool; bool = ((ku)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, com.tencent.mm.at.a.a((a.a.a.a.a)localObject2))) {}
          iZz = ((ku)localObject1);
          paramInt += 1;
        }
        break;
      }
      return -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.protocal.b.cc
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */