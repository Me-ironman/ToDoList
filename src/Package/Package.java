package Package;

import java.io.*;
import java.util.Scanner;

public class Package {
    public static item[] ToDo_List = new item[100];
    public static int size = 0;

    public static void main(String[] args) {
        try {
            File fileName = new File("toDoList.txt"); // 相对路径
            if (fileName.exists()) {
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fileName));//构造一个BufferedReader类来读取文件
                    String s = null;
                    while ((s = br.readLine()) != null) {//使用readLine方法，一次读一行
                        add_item(s);
                    }
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                fileName.createNewFile(); // 创建新文件,有同名的文件的话直接覆盖
            }
            if (size > 0) {
                System.out.println("事项总览");
                show_item(0);
            } else {
                System.out.println("暂无事项");
            }
        } catch (IOException e) {
            System.out.println("运行出错");
        }
        while (true) {
            System.out.println("请输入:  1(添加事项) 2(完成事项) 3(删除事项) 4(事项浏览) -1(保存退出)");
            String order = new Scanner(System.in).next();
            if (order.equals("1")) {
                add_item("");
                System.out.println("添加成功");
            }
            if (order.equals("2")) {
                finish_item();
            }
            if (order.equals("3")) {
                delete_item();
            }
            if (order.equals("4")) {
                System.out.println("请输入:  1(已完成) 2(未完成) 3(总览)");
                Scanner input = new Scanner(System.in);
                show_item(Integer.parseInt(input.next()) % 3);
            }
            if (order.equals("-1")) {
                save_ToDoList();
            }
        }
    }

    public static void add_item(String work) {
        if (size == 100) {
            System.out.println("事务已满,请删除后继续添加ovo");
        } else {
            if (work.equals("")) {
                System.out.println("请输入事项描述,回车提交:");
                Scanner input = new Scanner(System.in);
                work = input.next();
            }
            ToDo_List[size] = new item(work, false);
            size += 1;
        }
    }

    public static void delete_item() {
        System.out.println("请输入删除事项id,回车提交:");
        Scanner input = new Scanner(System.in);
        int item_id = Integer.parseInt(input.next()) - 1;
        if (item_id >= size || item_id < 0) {
            System.out.println("没有第" + (item_id + 1) + "号事项");
        } else {
            if (size - item_id >= 0) System.arraycopy(ToDo_List, item_id + 1, ToDo_List, item_id, size - item_id);
            size -= 1;
            System.out.println("删除成功");
        }
    }

    public static void finish_item() {
        System.out.println("请输入完成事项id,回车提交:");
        Scanner input = new Scanner(System.in);
        int item_id = Integer.parseInt(input.next()) - 1;
        if (item_id >= size || item_id < 0) {
            System.out.println("没有第" + (item_id + 1) + "号事项");
        } else {
            ToDo_List[item_id].setFinish(true);
            System.out.println("操作成功");
        }
    }

    public static void show_item(int type) {
        /*
         * type 为0 ==>全部打印
         *        1 ==>打印已完成
         *        2 ==>打印未完成*/
        for (int i = 0; i < size; i++) {
            if (type == 0 || type == 1 && ToDo_List[i].finish || type == 2 && !ToDo_List[i].finish)
                System.out.println("" + (i + 1) + (ToDo_List[i].finish ? "\t已完成\t" : "\t未完成\t") + ToDo_List[i].work);
        }
    }

    public static void save_ToDoList() {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter("toDoList.txt"));
            for (int h = 0; h < size; h++) {
                out.write(ToDo_List[h].work + "\n");
            }
            out.close();
            System.exit(0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static item[] getToDo_List() {
        return ToDo_List;
    }

    public static int getSize() {
        return size;
    }

    public static class item {
        boolean finish = false;
        String work = "";

        public String getWork() {
            return work;
        }

        public void setFinish(boolean it) {
            this.finish = it;
        }

        public item(String work, boolean finish) {
            super();
            this.work = work;
            this.finish = finish;
        }
    }
}
