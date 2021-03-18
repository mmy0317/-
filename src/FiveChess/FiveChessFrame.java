package FiveChess;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class FiveChessFrame extends JFrame implements MouseListener, ActionListener {

    //设置五子棋棋盘图片
    BufferedImage BGImage=null;
    //定义变量用来保存棋子坐标
    int x=0;
    int y=0;
    //定义二维数组保存之前下过的棋子坐标
    //保存内容为0表示没有棋子，1为黑子，2为白子
    int[][] all=new int[16][13];
    //定义一个标记来表示当前应该是黑棋还是白棋下下一步
    boolean isBLACK=false;
    JMenu jMenu1, jMenu2, jMenu3;
    JButton jButton1;
    int EgX, EgY;

    //写基础界面
    public FiveChessFrame() {
        this.setTitle("五子棋");//设置swing框的标题
        this.setSize(600, 600);//设置界面大小
        this.setLocation(400, 140);//设置相对于电脑屏幕的位置
        this.setResizable(false);//设置窗口无法改变大小
        this.setLayout(null);//不设置布局
        this.addMouseListener(this);//加入鼠标的事件监听

        JPanel jPanel1=new JPanel();//设置菜单栏
        JMenuBar jMenuBar=new JMenuBar();
        jMenu1=new JMenu("选项");
        jMenu2=new JMenu("返回主界面");
        jMenu3=new JMenu("撤销上一步");
        jMenuBar.add(jMenu1);
        jMenuBar.add(jMenu2);
        jMenuBar.add(jMenu3);
        jPanel1.add(jMenuBar);
        jPanel1.setBounds(100, 0, 400, 30);
        this.add(jPanel1);
        jMenu3.addActionListener(this);

        JPanel jPanel=new JPanel();//设置棋盘
        JLabel frameimg=new JLabel(new ImageIcon(""));
        jPanel.add(frameimg);
        jPanel.setBounds(00, 40, 600, 600);
        this.add(jPanel);

        //设置认输按键
        JPanel jPanel2=new JPanel();
        jButton1=new JButton("认输");
        jPanel2.add(jButton1);
        jPanel2.setBounds(380, 450, 65, 50);
        this.add(jPanel2);
        jButton1.addActionListener(this);

        this.setVisible(true);//设置界面可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭界面就会结束程序


    }

    //写界面绘制 包括棋盘绘制
    public void paint(Graphics g) {
        //g.drawString("黑方剩余时间：", 70, 480);
        // g.drawString("白方剩余时间：", 70, 530);

        //利用paint方法绘制棋盘
        g.drawLine(80, 77, 80, 425);//这条线为最左边的一条竖线
        g.drawLine(80, 77, 515, 77);//这条线为最上边的一条横线
        //可以知道棋盘左上角 （80，77） 右上角 （515，77）左下角（80，425） 右下角 （515，425）
        //棋盘方格为29*29

        for (int j=0; j < 16; j++) {
            g.drawLine(80 + 29 * j, 77, 80 + 29 * j, 425);
        }
        for (int j=0; j < 13; j++) {
            g.drawLine(80, 77 + 29 * j, 515, 77 + 29 * j);
        }

        //绘制棋盘上定位的点
        g.fillOval(165, 162, 4, 4);
        g.fillOval(165, 336, 4, 4);
        g.fillOval(426, 336, 4, 4);
        g.fillOval(426, 162, 4, 4);

        //绘制棋子
        for (int j=0; j < 16; j++) {
            for (int i=0; i < 13; i++) {
                if (all[j][i] == 1) {
                    //绘制一个黑子
                    EgX=73 + j * 29;
                    EgY=70 + i * 29;
                    g.fillOval(EgX, EgY, 15, 15);
                }
                if (all[j][i] == 2) {
                    //绘制白子
                    EgX=73 + j * 29;
                    EgY=70 + i * 29;
                    g.setColor(Color.white);
                    g.fillOval(EgX, EgY, 15, 15);//先绘制一个实心的白色圆
                    g.setColor(Color.black);
                    g.drawOval(EgX, EgY, 15, 15);//再绘制一个黑色的空心圆
                }
            }
        }

        // g.setColor(Color.pink);
        //g.fillRect(80,77,435,348);


    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //判断鼠标点击放置棋子在棋盘范围内
        x=e.getX();
        y=e.getY();
        //判断是否在棋盘范围之内
        if (x >= 80 && x <= 515 && y >= 77 && y <= 420) {
            //不能直接调用repaint方法，要判断棋子距离哪一个交叉点最近
            //判断距离 x方向上选择距离最近的点
            int z=(x - 80) % 29;//29为方格宽度
            if (z > 14.5) {
                x=(x - 80) / 29 + 1;
            } else {
                x=(x - 80) / 29;
            }
            //判断距离 y方向上选择距离最近的点
            int m=(y - 77) % 29;
            if (m > 14.5) {
                y=(y - 77) / 29 + 1;
            } else {
                y=(y - 77) / 29;
            }
            if (all[x][y] == 0) {//判断当前位置是否有棋子
            /*
            判断前面设定的布尔变量是否为true，为true那么现在就是黑棋即将下棋
            在下完棋之后要将变量的值变化，使下一次下棋棋子颜色不会相同
             */
                if (isBLACK == false) {
                    all[x][y]=2;
                    isBLACK  =true;
                } else {
                    all[x][y]=1;
                    isBLACK  =false;
                }
                //判断棋子是否连成五个
                boolean CheckWin1=this.check();
                if (CheckWin1 == true) {
                    JOptionPane.showMessageDialog(this, "game over");
                    this.setVisible(false);
                    //设置游戏结束关闭界面
                }
            } else {
                JOptionPane.showMessageDialog(this, "当前位置已经有棋子了！");
            }

            this.repaint();//表示要重新执行一次paint方法
        }
    }

    //构造一个判断是否获胜的方法
    private Boolean check() {
        boolean flag=false;
        int color=all[x][y];//获取当前的棋子颜色
        //疑问：下不同棋子时候count的值会不会被累加
        //回答：不会，下不同的棋子时候会重新调用这个判断的方法，因此count的值会被重新定为1

        int count=1;
        //判断横向是否有五颗棋子相连，y轴的值是相同的
        /*int i = 1;
        while (NumColor == all[x - i][y]) {
            count = count + 1;
            i = i + 1;
        }
        i = 1;
        while (NumColor == all[x + i][y]) {
            count = count + 1;
            i = i + 1;
        }
        if (count >= 5) {
            flag = true;
        }
        //纵向
        count = 1;
        int j = 1;
        while (NumColor == all[x][y + j]) {
            count = count + 1;
            j = j + 1;
        }
        j = 1;
        while (NumColor == all[x][y - j]) {
            count = count + 1;
            j = j + 1;
        }
        if (count >= 5) {
            flag = true;
        }
        //向右边斜着成五个棋子
        count = 1;
        int a = 1;
        while (NumColor == all[x - a][y - a]) {
            count = count + 1;
            a = a + 1;
        }
        a = 1;
        while (NumColor == all[x + a][y + a]) {
            count = count + 1;
            a = a + 1;
        }
        if (count >= 5) {
            flag = true;
        }
        //向左边斜着五个棋子
        count = 1;
        int b = 1;
        while (NumColor == all[x + b][y - b]) {
            count = count + 1;
            b = b + 1;
        }
        b = 1;
        while (NumColor == all[x - b][y + b]) {
            count = count + 1;
            b = b + 1;
        }
        //判断是否有五颗棋子
        if (count >= 5) {
            flag = true;
        }*/

        count=this.Checkcount(1, 0, color);
        if (count >= 5) {
            flag=true;
        } else {
            count=this.Checkcount(0, 1, color);
            if (count >= 5) {
                flag=true;
            } else {
                count=this.Checkcount(1, -1, color);
            }
        }
        return flag;
    }

    //写一个方法用来判断棋子连接的数量
    private int Checkcount(int XChange, int YChange, int color) {
        int count=1;
        int Xtemp=XChange;
        int Ytemp=YChange;
        while (color == all[x + XChange][y + YChange]) {
            count=count + 1;
            if (XChange != 0) {
                XChange++;
            }
            if (YChange != 0) {
                YChange++;
            }
        }

        XChange=Xtemp;
        YChange=Ytemp;
        while (color == all[x - XChange][y - YChange]) {
            count=count + 1;
            if (XChange != 0) {
                XChange++;
            }
            if (YChange != 0) {
                YChange++;
            }
        }
        return count;

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


    //动作事件监听，用来监听菜单栏的动作，撤回上一步 还没写呢
    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source == jButton1) {
            JOptionPane.showMessageDialog(this, "you defent;");
            this.dispose();
            new LoginInframe();
        }

    }

}
