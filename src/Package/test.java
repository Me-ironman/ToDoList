package Package;

import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

public class test {
    public static void main(String[] ages) {
        System.out.println("刘园-17140120097\n");
        testM();
    }

    @Test
    public static void testM() {
        String data = "新建事项_testM";
        System.setIn(new ByteArrayInputStream(data.getBytes()));
        Package.add_item("");
        System.out.println("#### 添加事项测试--输入示例:\t" + data);
        String new_work = Package.getToDo_List()[Package.getSize() - 1].work;
        Package.show_item(0);
        try {
            Assert.assertEquals("新建事项_testM", new_work);
            System.out.println("添加事项-测试成功\n");
        } catch (Exception e) {
            System.out.println("添加事项-测试错误");
        }
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Package.finish_item();
        System.out.println("#### 完成事项测试--输入示例:\t1");
        boolean finish = Package.getToDo_List()[Package.getSize() - 1].finish;
        Package.show_item(0);
        try {
            Assert.assertTrue(finish);
            System.out.println("完成事项-测试成功\n");
        } catch (Exception e) {
            System.out.println("完成事项-测试错误");
        }
        System.setIn(new ByteArrayInputStream("1".getBytes()));
        Package.delete_item();
        System.out.println("#### 删除事项测试--输入示例:\t1");
        Package.show_item(0);
        int size = Package.getSize();
        try {
            Assert.assertEquals(0, size);
            System.out.println("删除事项-测试成功\n");
        } catch (Exception e) {
            System.out.println("删除事项-测试错误");
        }
    }

}
