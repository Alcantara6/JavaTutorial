package com.yanjing.sync;

/**
 * @author yanjing
 * @date 2021/12/18
 */
// 两个人去银行取钱，账户
public class UnsafeBank {

    public static void main(String[] args) {

        Account account = new Account(100, "建设银行");

        Drawing youDrawing = new Drawing(account, 50, "you");
        Drawing wifeDrawing = new Drawing(account, 100, "wife");


        new Thread(youDrawing).start();
        new Thread(wifeDrawing).start();
    }
}

class Account {

    int money; // 余额
    String name; // 卡名

    public Account(int money, String name) {
        this.money = money;
        this.name = name;
    }
}

// 因为不涉及操作多个对象，所以继承Thread
class Drawing extends Thread {

    final Account account;
    // 取了多少钱
    int transactionMoney;
    //  现在手里有多少钱
    int ownMoney;

    public Drawing(Account account, int transactionMoney, String name) {
        super(name);
        this.account = account;
        this.transactionMoney = transactionMoney;
    }

    @Override
    public void run() {

        // 其实核心就是：锁共同操作的对象，这里you和wife是两个不同的实例，共同操作的是account
        synchronized (account) {

            if (account.money - transactionMoney < 0) {

                System.out.println(Thread.currentThread().getName() + "钱不够，取不了");
                return;
            }

            // Sleep可以放大问题的发生性
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            account.money -= transactionMoney;
            ownMoney += transactionMoney;

            System.out.println(account.name + "余额：" + account.money);
            // Thread.currentThread().getName() = this.getName
            System.out.println(this.getName() + "手里的钱：" + ownMoney);
        }
    }
}
