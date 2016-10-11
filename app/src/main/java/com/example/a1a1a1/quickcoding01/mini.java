package com.example.a1a1a1.quickcoding01;

/**
 * Created by 1a1a1 on 2016-10-06.
 */
public class mini extends Father {

    public int getResult()
    {
        int result=100;
        for(int i=0; i<num.length; i++)
        {
            if(num[i]<result)
                result=num[i];
        }
        return result;
    }
}
