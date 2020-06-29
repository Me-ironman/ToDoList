package Package;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.Assert.*;

public class PackageTest {

    @Test
    public void testadd_item() throws Exception {
        System.out.println("add添加测试");
        Package p=new Package();
        String input = "case1";
        int actual = p.getSize();
        int now = p.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            p.add_item(input);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(1+now,actual+1);

    }



    @Test
    public void testdelete_item() {
        System.out.println("delete删除测试");
        Package p=new Package();
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "1";
        int actual = p.getSize();
        int now=p.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            p.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            p.add_item(input2);
            actual = p.getSize();
            assertEquals(2+now,actual);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            p.delete_item();

        }finally {
            System.setIn(stdin);
        }
        actual = p.getSize();
        assertEquals(1+now,actual);
    }

    @Test
    public void testfinish_item() {
        System.out.println("finish完成测试");
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "2";
        int actual = Package.getSize();
        InputStream stdin = System.in;
        int now = Package.getSize();
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            Package.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            Package.add_item(input2);
            actual = Package.getSize();
            assertEquals(2+now,actual);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            Package.finish_item();
        }finally {
            System.setIn(stdin);
        }

    }

    @Test
    public void testshow_item() {//case1完成，其余未完成
        Package p=new Package();
        System.out.println("show展示测试");
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "case3";
        String input4 = "1";
        int actual = p.getSize();
        int now = p.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            p.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            p.add_item(input2);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            p.add_item(input3);
            actual = p.getSize();
            assertEquals(now+3,actual);
            System.setIn(new ByteArrayInputStream(input4.getBytes()));
            p.finish_item();
            System.out.println("---------全部打印----------");
            p.show_item(0);
            System.out.println("---------已完成的----------");
            p.show_item(1);
            System.out.println("---------未完成的----------");
            p.show_item(2);
        }finally {
            System.setIn(stdin);
        }
    }

}