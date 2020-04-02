package com.patech;

/**
 * @ClassName: Coverage
 * @Description:
 * @Author: zhzh.yin
 * @Date: 2020-04-01 14:46
 * @Verion: 1.0
 */
public class NumDivide {
    public Integer divide1(int a ,int b){
        if(a>b){
            return a/b;
        }else if(a<b){
            return b/a;
        }else if(a==b){
            return a;
        }else if(a==0 || b==0){
            return 0;
        }

        return 88;

    }
}
