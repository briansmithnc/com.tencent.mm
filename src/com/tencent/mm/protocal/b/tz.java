package com.tencent.mm.protocal.b;

import a.a.a.b;
import java.util.LinkedList;

public final class tz
  extends alq
{
  public int iXh;
  public int jst;
  public LinkedList jsu = new LinkedList();
  public String jsv;
  public int jsw;
  
  protected final int a(int paramInt, Object... paramVarArgs)
  {
    if (paramInt == 0)
    {
      paramVarArgs = (a.a.a.c.a)paramVarArgs[0];
      if (jHj == null) {
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (jHj != null)
      {
        paramVarArgs.cj(1, jHj.kn());
        jHj.a(paramVarArgs);
      }
      paramVarArgs.ci(2, jst);
      paramVarArgs.d(3, 8, jsu);
      if (jsv != null) {
        paramVarArgs.d(4, jsv);
      }
      paramVarArgs.ci(5, iXh);
      paramVarArgs.ci(6, jsw);
      return 0;
    }
    if (paramInt == 1) {
      if (jHj == null) {
        break label606;
      }
    }
    label606:
    for (paramInt = a.a.a.a.ch(1, jHj.kn()) + 0;; paramInt = 0)
    {
      int i = paramInt + a.a.a.a.cg(2, jst) + a.a.a.a.c(3, 8, jsu);
      paramInt = i;
      if (jsv != null) {
        paramInt = i + a.a.a.b.b.a.e(4, jsv);
      }
      return paramInt + a.a.a.a.cg(5, iXh) + a.a.a.a.cg(6, jsw);
      if (paramInt == 2)
      {
        paramVarArgs = (byte[])paramVarArgs[0];
        jsu.clear();
        paramVarArgs = new a.a.a.a.a(paramVarArgs, iTR);
        for (paramInt = alq.a(paramVarArgs); paramInt > 0; paramInt = alq.a(paramVarArgs)) {
          if (!super.a(paramVarArgs, this, paramInt)) {
            paramVarArgs.bog();
          }
        }
        if (jHj != null) {
          break;
        }
        throw new b("Not all required fields were included: BaseResponse");
      }
      if (paramInt == 3)
      {
        Object localObject1 = (a.a.a.a.a)paramVarArgs[0];
        tz localtz = (tz)paramVarArgs[1];
        paramInt = ((Integer)paramVarArgs[2]).intValue();
        Object localObject2;
        boolean bool;
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
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new dd();
            localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
            for (bool = true; bool; bool = ((dd)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, alq.a((a.a.a.a.a)localObject2))) {}
            jHj = ((dd)localObject1);
            paramInt += 1;
          }
        case 2: 
          jst = maU.jC();
          return 0;
        case 3: 
          paramVarArgs = ((a.a.a.a.a)localObject1).sJ(paramInt);
          i = paramVarArgs.size();
          paramInt = 0;
          while (paramInt < i)
          {
            localObject2 = (byte[])paramVarArgs.get(paramInt);
            localObject1 = new afn();
            localObject2 = new a.a.a.a.a((byte[])localObject2, iTR);
            for (bool = true; bool; bool = ((afn)localObject1).a((a.a.a.a.a)localObject2, (com.tencent.mm.at.a)localObject1, alq.a((a.a.a.a.a)localObject2))) {}
            jsu.add(localObject1);
            paramInt += 1;
          }
        case 4: 
          jsv = maU.readString();
          return 0;
        case 5: 
          iXh = maU.jC();
          return 0;
        }
        jsw = maU.jC();
        return 0;
      }
      return -1;
    }
  }
}

/* Location:
 * Qualified Name:     com.tencent.mm.protocal.b.tz
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */