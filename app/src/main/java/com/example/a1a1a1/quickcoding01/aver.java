package com.example.a1a1a1.quickcoding01;

/**
 * Created by 1a1a1 on 2016-10-06.
 */
public class aver extends Father {
    public int getResult()
    {
        int result=0;
        for(int i=0; i<num.length; i++)
            result+=num[i];

        result=result/num.length;
        return result;
    }
}
