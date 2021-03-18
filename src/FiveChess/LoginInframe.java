package FiveChess;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;

public class LoginInframe extends JFrame implements ActionListener {

    JButton jButton, jButton1, jButton2, jButton3;

    public LoginInframe() {
        this.setTitle("五子棋");//设置swing框的标题
        this.setSize(600, 600);//设置界面大小
        this.setLocation(400, 140);//设置相对于电脑屏幕的位置
        this.setResizable(false);//设置窗口无法改变大小
        this.setLayout(new FlowLayout());//不设置布局

        JPanel jPanel1=new JPanel();
        jButton1=new JButton("人机对战");
        jButton1.setPreferredSize(new Dimension(200, 200));
        jPanel1.add(jButton1);
        this.add(jPanel1);
        jButton1.addActionListener(this);

        JPanel jPanel=new JPanel();
        jButton=new JButton("人人对战");
        jButton.setPreferredSize(new Dimension(200, 200));
        jPanel.add(jButton);
        this.add(jPanel);
        jButton.addActionListener(this);

        JPanel jPanel2=new JPanel();
        jButton2=new JButton("游戏简介");
        jButton2.setPreferredSize(new Dimension(200, 200));
        jPanel2.add(jButton2);
        this.add(jPanel2);
        jButton2.addActionListener(this);

        JPanel jPanel3=new JPanel();
        jButton3=new JButton("更换背景");
        jButton3.setPreferredSize(new Dimension(200, 200));
        jPanel3.add(jButton3);
        this.add(jPanel3);
        jButton3.addActionListener(this);

        this.setVisible(true);//设置界面可见
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置关闭界面就会结束程序
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source=e.getSource();
        if (source == jButton2) {
            JOptionPane.showMessageDialog(this, "五子棋是全国智力运动会竞技项目之一，是一种两人对弈的纯策略型棋类游戏。双方分别使用黑白两色的棋子，下在棋盘直线与横线的交叉点上，先形成五子连线者获胜。");
        } else if (source == jButton) {
            this.dispose();
            new FiveChessFrame();
        } else if (source == jButton1) {
            this.dispose();
            new AIGame();
        } else if (source == jButton3) {
            this.dispose();
            new BackGroundChoose();
        }
    }
}
