package episode3;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class BankSystem {
    public static void main(String[] args) {
        ArrayList<User> list = new ArrayList<User>();
        while (true) {
            System.out.println("----银行模拟系统----");
            System.out.println("1、登陆");
            System.out.println("2、注册");
            System.out.println("请输入选择项：");
            Scanner sc = new Scanner(System.in);
            int select = sc.nextInt();
            switch (select) {
                case 1:
                    System.out.println("请输入卡号：");
                    String id = sc.next();
                    System.out.println("请输入密码：");
                    String password = sc.next();
                    User user = login(id, password, list);
                    if (user != null) {
                        xx:while(true) {
                            System.out.println("1、查看余额");
                            System.out.println("2、存款");
                            System.out.println("3、取款");
                            System.out.println("4、注销卡号");
                            System.out.println("5、退出");
                            System.out.println("请输入选择项：");
                            int sel = sc.nextInt();
                            switch (sel) {
                                case 1:
                                    selectMoney(user);
                                    break;
                                case 2:
                                    deposit(sc, user);
                                    break;
                                case 3:
                                    	draw(sc, user);
                                    break;
                                case 4:
                                    deleteUser(user, sc, list);
                                    break xx;
                                case 5:
                                    break xx;
                                default:
                                    break;
                            }
                        }

                    }
                    break;
                case 2:
                    register(sc, list);
                    break;
                default:
                    break;
            }
        }

    }

    /**
     * 登陆功能
     * @param id
     * @param password
     * @param list
     * @return
     */
    public static User login(String id, String password, ArrayList<User> list) {
        if (list.size() == 0) {
            //如果集合长度为0，不进行for循环遍历没有了返回值。\
            System.out.println("卡号不存在,请注册!!");
            return null;
        }
        for (int i = 0; i < list.size(); i++) {
            User user = list.get(i);
            if (id.equals(user.id)) { //卡号存在,判断密码是否正确
                if (password.equals(user.password)) {
                    return user;
                } else {
                    System.out.println("密码错误!!");
                    return null;
                }
            } else {
                System.out.println("卡号不存在,请注册!!");
                return null;
            }
        }
        return null;
    }

    /**
     * 判断手机号是否存在
     * @param phoneNum
     * @param list
     * @return
     */
    public static boolean isExistPhoneNum(String phoneNum, ArrayList<User> list) {
        for (int i = 0; i < list.size(); i++) {
            if (phoneNum.equals(list.get(i).phoneNum)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 随机生成一个18位的卡号
     * @return
     */
    public static String createId() {
        Random random = new Random();
        String s = "";
        for (int i =
             0; i < 18; i++) {
			/*int n = random.nextInt(10);		//[0,10)
			s += n;*/
            s += random.nextInt(10);
        }
        return s;
    }

    /**
     * 注册
     * @param sc
     * @param list
     * @return
     */
    public static void register(Scanner sc, ArrayList<User> list) {
        System.out.println("请输入姓名：");
        String name = sc.next();
        System.out.println("请输入手机：");
        String phoneNum = sc.next();
        //boolean b = isExistPhoneNum(phoneNum, list);
        if (isExistPhoneNum(phoneNum, list)) {
            System.out.println("该手机号已被注册！");
            return;
        }
        System.out.println("请输入密码：");
        String registerPassword = sc.next();
        String registerId = createId();
        User user = new User();
        user.id = registerId;
        user.name = name;
        user.password = registerPassword;
        user.phoneNum = phoneNum;
        list.add(user);
        System.out.println("您的卡号："+registerId);
    }

    /**
     * 查询余额
     * @param user
     */
    public static void selectMoney(User user) {
        System.out.println("余额："+user.money);
    }

    /**
     * 存款
     * @param sc
     * @param user
     */
    public static void deposit(Scanner sc,User user) {
        System.out.println("请输入存款金额：");
        double depositMoney = sc.nextDouble();
        double money = user.money + depositMoney;  //现在的余额
        user.money = money;
    }

    /**
     * 取款
     * @param sc
     * @param user
     */
    public static void draw(Scanner sc,User user) {
        System.out.println("请输入取款金额：");
        double drawMoney = sc.nextDouble();
        if(drawMoney > user.money) {
            System.out.println("账号余额不足!!");
            return;
        }
        double money = user.money - drawMoney;
        user.money = money;
        System.out.println("取款成功！");
    }


    /**
     * 注销
     * @param user
     * @param sc
     * @param list
     */
    public static void deleteUser(User user,Scanner sc,ArrayList<User> list) {
        if(user.money > 0) {
            System.out.println("余额："+user.money);
            System.out.println("确认注销吗？Y/N");
            String s = sc.next();
            if("N".equals(s)) {
                return;
            }
        }
        list.remove(user);		//从集合中移除
    }
}
