package anydoor.service.learning;

import org.junit.jupiter.api.Test;

public class ReferenceTransferTest
{
    public  void swap(DataWrap dw)
    {
        int tmp = dw.a;
        dw.a = dw.b;
        dw.b = tmp;
        System.out.println("swap方法里，a成员变量的值是"
                + dw.a + "；b成员变量的值是" + dw.b);
        System.out.println(dw.hashCode()+"-----before null");
        dw=null;
//        System.out.println(dw.hashCode());
    }
    @Test
    public  void main()
    {
        DataWrap dw = new DataWrap();
        System.out.println(dw.hashCode()+"----1");
        dw.a = 6;
        dw.b = 9;
        swap(dw);
        System.out.println(dw.hashCode()+"----2");
        System.out.println("交换结束后，a成员变量的值是"
                + dw.a + "；b成员变量的值是" + dw.b);
    }
}
class DataWrap
{
    int a;
    int b;
}