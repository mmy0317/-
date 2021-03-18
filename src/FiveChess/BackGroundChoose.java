package FiveChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackGroundChoose extends JFrame implements ActionListener {

    private JButton jButton, jButton1, jButton2, jButton3;
    public int color=0;

    public BackGroundChoose() {
        this.setTitle("五子棋");//设置swing框的标题
        this.setSize(600, 600);//设置界面大小
        this.setLocation(400, 140);//设置相对于电脑屏幕的位置
        this.setResizable(false);//设置窗口无法改变大小
        this.setLayout(null);//不设置布局模式，试试看能不能加入多个button

        jButton =new JButton("粉色");
        jButton1=new JButton("蓝色");
        jButton2=new JButton("灰色");
        jButton3=new JButton("返回");

        jButton.setBounds(93, 150, 50, 20);
        jButton1.setBounds(243, 150, 50, 20);
        jButton2.setBounds(393, 150, 50, 20);
        this.add(jButton);
        this.add(jButton1);
        this.add(jButton2);
        jButton3.setBounds(393, 200, 50, 20);
        this.add(jButton3);

        jButton.addActionListener(this);
        jButton1.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);


        this.setVisible(true);//设置界面可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭界面就会结束程序

    }

    //写一个绘制颜色图块的类
    public void paint(Graphics g) {
        //可以调整棋盘背景为粉色，蓝色,灰色
        g.setColor(Color.pink);
        g.fillOval(100, 100, 30, 30);
        g.setColor(Color.black);
        g.drawOval(100, 100, 30, 30);

        g.setColor(Color.CYAN);
        g.fillOval(250, 100, 30, 30);
        g.setColor(Color.black);
        g.drawOval(250, 100, 30, 30);

        g.setColor(Color.GRAY);
        g.fillOval(400, 100, 30, 30);
        g.setColor(Color.black);
        g.drawOval(400, 100, 30, 30);

    }


    //事件监听 设置一个参数，将参数传导到Fivechessframe
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();

        if (source == jButton) {
            color=1;
            int set=JOptionPane.showConfirmDialog(this, "棋盘界面将被改为粉色？", "选择", JOptionPane.YES_NO_CANCEL_OPTION);
            if (set == 0) {
                this.dispose();
                new LoginInframe();
            }
        } else if (source == jButton1) {
            color=2;
            int set2=JOptionPane.showConfirmDialog(this, "棋盘界面将被改为蓝色？", "选择", JOptionPane.YES_NO_CANCEL_OPTION);
            if (set2 == 0) {
                this.dispose();
                new LoginInframe();
            }
        } else if (source == jButton2) {
            color=3;
            int set3=JOptionPane.showConfirmDialog(this, "棋盘界面将被改为灰色？", "选择", JOptionPane.YES_NO_CANCEL_OPTION);
            if (set3 == 0) {
                this.dispose();
                new LoginInframe();
            }
        }
        if (source == jButton3) {
            this.dispose();
            new LoginInframe();
        }

    }


}
