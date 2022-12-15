package linkedlist;

import javax.lang.model.element.VariableElement;

/**
 * @author ：XiaoYu
 * @date ：2022/11/11 5:43
 * @version: :1.0
 * :
 */
public class LinkedListDemo {
    public static void main(String[] args) {

        HeroNode heroNode1 = new HeroNode(1, "孙悟空", "齐天大圣");
        HeroNode heroNode2 = new HeroNode(2, "猪八戒", "天蓬元帅");
        HeroNode heroNode3 = new HeroNode(3, "沙悟净", "卷帘大将");
        HeroNode heroNode4 = new HeroNode(4, "唐三藏", "玄奘法师");
        HeroNode heroNode5 = new HeroNode(5, "白龙马", "小白龙");
        HeroNode heroNode6 = new HeroNode(6, "二郎神", "杨戬");

        LinkedList linkedList = new LinkedList();

//        linkedList.add(heroNode5);
//        linkedList.add(heroNode2);
//        linkedList.add(heroNode3);
//        linkedList.add(heroNode4);
//        linkedList.add(heroNode1);
//        linkedList.add(heroNode6);
//        linkedList.add(heroNode6);


        linkedList.addOrderBy(heroNode6);
        linkedList.addOrderBy(heroNode1);
        linkedList.addOrderBy(heroNode2);
        linkedList.addOrderBy(heroNode4);
        linkedList.addOrderBy(heroNode3);
        linkedList.addOrderBy(heroNode5);

        linkedList.List();
        linkedList.List();
        linkedList.List();
        linkedList.getLastNode(1);


    }


}
//管理链表
class LinkedList {
    // 初始化头节点，头节点不能动
    private HeroNode head = new HeroNode(0, "", "");

    public HeroNode getHead() {
        return head;
    }

    //输出链表的倒数第n个节点
    public void getLastNode( int index) {

        //辅助变量
        HeroNode temp = head.next;

        if (temp == null) {
            System.out.println("链表为空");
            return;
        }
        //得到链表的有效节点长度
        int length = getLength();

        if(index <1|| length<index ){
            System.out.println("输入的数字不能小于链表的有效节点,或者小于1");
            return;
        }
        for (int i = 0; i < length-index; i++) {
            temp=temp.next;
        }
        System.out.println(temp);
    }


    // 获取到单链表的节点个数
    public int getLength() {
        HeroNode temp = head;
        if (temp.next == null) { //链表为空
            return 0;
        }
        int length = 0;

        while (temp.next != null) {
            length++;
            temp = temp.next;

        }


        return length;
    }


    //删除节点
    public void deleteNo(int no) {
        //辅助变量
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {// 表示找到了要删除的位置
                flag = true;
                System.out.println(temp.next + "即将删除\n==============================================");
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            // 删除
            temp.next = temp.next.next;
            System.out.println("删除后的情况");
            List();
        } else {
            System.out.println("没有找到要删除的no编号");
        }


    }

    //顺序添加节点
    public void addOrderBy(HeroNode heroNode) {
        //辅助变量
        HeroNode temp = head;

        //不能添加重复英雄的条件
        boolean flag = true;

        while (true) {
            if (temp.next == null) {//表示最后一个节点
                break;
            }

            if (temp.next.no > heroNode.no) { //找到位置 在temp后面插入
                break;
            }

            if (temp.next.no == heroNode.no) {  //若英雄编号相同 flag设为false
                flag = false;
                System.out.println("添加的英雄已经存在：" + heroNode.no + " " + heroNode.name);
                break;
            }

            temp = temp.next;
        }
        if (flag) {                    //  s:要插入的位置  p:要插入位置的前一个节点
            heroNode.next = temp.next; // 1. s.next  <= p.next   顺序不能乱 否则自己指向自己
            temp.next = heroNode;      // 2. p.next  <= s
        }




















    }

    // 根据no编号修改节点
    public void update(HeroNode heroNode) {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助节点
        HeroNode temp = head.next;
        //判断是否找到编号
        boolean flag = true;


        while (true) {
            if (temp == null) { //判断链表是否到最后
                break;
            }
            if (temp.no == heroNode.no) {//编号相同就添加
                temp.name = heroNode.name;
                temp.nickname = heroNode.nickname;
                flag = false;//表示找到了编号
                break;
            }
            temp = temp.next;

        }
        if (flag) {
            System.out.println("没有找到编号");
        }
    }

    // 添加节点
    public void add(HeroNode heroNode) {
        //辅助变量
        HeroNode temp = head;

        while (true) {
            if (temp.next == null) {//表示最后一个节点
                break;
            }
            //移动到下一个节点
            temp = temp.next;
        }
        // 将节点添加到尾部
        temp.next = heroNode;
    }

    // 遍历链表
    public void List() {

        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助变量
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }

            System.out.println(temp);

            temp = temp.next;
        }
        System.out.println("=============================================");
    }


}


//定义HeroNode节点
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个节点

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}