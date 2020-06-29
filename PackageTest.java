package source;

import org.junit.After;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class PackageTest {
   
    @Test
    public void testadd_item() throws Exception {
        String input = "case1";
        int actual = Package.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input.getBytes()));
            Package.add_item(input);
        }finally {
            System.setIn(stdin);
        }
        assertEquals(1,actual+1);

    }

    @Test
    public void testdelete_item() {
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "1";
        int actual = Package.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            Package.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            Package.add_item(input2);
            actual = Package.getSize();
            assertEquals(2,actual);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            Package.delete_item();

        }finally {
            System.setIn(stdin);
        }
        actual = Package.getSize();
        assertEquals(1,actual);
    }

    @Test
    public void testfinish_item() {
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "2";
        int actual = Package.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            Package.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            Package.add_item(input2);
            actual = Package.getSize();
            assertEquals(2,actual);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            Package.finish_item();
        }finally {
            System.setIn(stdin);
        }

    }

    @Test
    public void testshow_item() {//case1完成，其余未完成
        String input1 = "case1";
        String input2 = "case2";
        String input3 = "case3";
        String input4 = "1";
        int actual = Package.getSize();
        InputStream stdin = System.in;
        try{
            System.setIn(new ByteArrayInputStream(input1.getBytes()));
            Package.add_item(input1);
            System.setIn(new ByteArrayInputStream(input2.getBytes()));
            Package.add_item(input2);
            System.setIn(new ByteArrayInputStream(input3.getBytes()));
            Package.add_item(input3);
            actual = Package.getSize();
            assertEquals(3,actual);
            System.setIn(new ByteArrayInputStream(input4.getBytes()));
            Package.finish_item();
            System.out.println("---------全部打印----------");
            Package.show_item(0);
            System.out.println("---------已完成的----------");
            Package.show_item(1);
            System.out.println("---------未完成的----------");
            Package.show_item(2);
        }finally {
            System.setIn(stdin);
        }
    }

}