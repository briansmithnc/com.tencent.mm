package com.tencent.mm.protocal.b;

import java.util.LinkedList;

public final class aww
  extends ali
{
  public String avm;
  public String dkU;
  public String eiq;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (jGS != null)
      {
        paramVarArgs.cj(1, jGS.kn());
        jGS.a(paramVarArgs);
      }
      if (eiq != null) {
        paramVarArgs.d(2, eiq);
      }
      if (dkU != null) {
        paramVarArgs.d(3, dkU);
      }
      if (avm != null) {
        paramVarArgs.d(4, avm);
      }
      return 0;
    }
    if (paramInt == 1) {
      if (jGS == null) {
        break label438;
      }
    }
    label438:
    for (int i = a.a.a.a.ch(1, jGS.kn()) + 0;; i = 0)
    {
      paramInt = i;
      if (eiq != null) {
        paramInt = i + a.a.a.b.b.a.e(2, eiq);
      }
      i = paramInt;
      if (dkU != null) {
        i = paramInt + a.a.a.b.b.a.e(3, dkU);
      }
      paramInt = i;
      if (avm != null) {
        paramInt = i + a.a.a.b.b.a.e(4, avm);
      }
      return paramInt;
      if (paramInt == 2)
      {
        paramVarArgs = new a.a.a.a.a((byte[])paramVarArgs[0], iTR);
        for (paramInt = ali.a(paramVarArgs); paramInt > 0; paramInt = ali.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.bog();
          }
        }
        break;
      }
      if (paramInt == 3)
      {
        Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
        aww localaww = (aww)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        switch (paramInt)
        {
        default: 
          return -1;
        case 1: 
          paramVarArgs = ((a.a.a.a.a)localObject1).sJ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            Object localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dc();
            localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
            for (boolean bool = true; bool; bool = ((dc)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, ali.a((a.a.a.a.a)localObject2))) {}
            jGS = ((dc)localObject1);
            paramInt += 1;
          }
        case 2: 
          eiq = maU.readString();
          return 0;
        case 3: 
          dkU = maU.readString();
          return 0;
        }
        avm = maU.readString();
        return 0;
      }
      return -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.protocal.b.aww
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */