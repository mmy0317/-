package text;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MygameFrame extends JFrame implements MouseListener {
    public MygameFrame() {
        this.setTitle("五子棋");
        this.setSize(600, 600);
        this.setLocation(400, 140);
        this.setResizable(false);//设置窗口无法改变大小
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//close frame when click x
        /*
        该方法为获取电脑屏幕宽度，通过计算使GUI在屏幕正中间，大可不必。
        int width,high;
        width  = Toolkit.getDefaultToolkit().getScreenSize().width;
        high = Toolkit.getDefaultToolkit().getScreenSize().height;
         */
        this.addMouseListener(this);

        this.setVisible(true);

    }

    public void paint(Graphics g) {
        g.drawString("五子棋游戏", 20, 40);//绘制字符串

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //监听鼠标点击事件
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //监听鼠标按下的时间
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //监听鼠标抬起事件
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //监听鼠标进入事件的操作
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //监听鼠标的离开事件
    }
}
