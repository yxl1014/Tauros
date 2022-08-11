package yxl.demo.y2022.m8.d11;

/**
 * @Author: yxl
 * @Date: 2022/8/11 9:54
 */
public class Solution {
    public String reformat(String s) {
        char c[]=s.toCharArray();
        int count1=0,count2=0;
        for(int i=0;i<c.length;i++){
            if(c[i]>='0'&&c[i]<='9'){count1++;}
            else{count2++;}
        }
        if(Math.abs(count1-count2)>1){return "";}
        int i=0,j=0;
        if(count1>=count2){j++;}//数字多
        else{i++;}
        char ans[]=new char[c.length];
        for(int p=0;p<c.length;p++){
            if(c[p]>='0'&&c[p]<='9'){
                ans[i]=c[p];
                i+=2;
            }
            else{
                ans[j]=c[p];
                j+=2;
            }
        }
        return new String(ans);
    }
}
