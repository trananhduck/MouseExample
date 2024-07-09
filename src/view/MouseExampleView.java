package view;

import controller.MouseExampleCotroller;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import model.MouseExampleModel;

public class MouseExampleView extends JFrame {
    private final MouseExampleModel model;
    private JPanel jPanel_mouse;
    private JLabel jLabel_position;
    private JLabel jLabel_x;
    private JLabel jLabel_y;
    private JLabel jLabel_count;
    private JLabel jLabel_countValue;
    private JLabel jLabel_empty1;
    private JLabel jLabel_checkIn;
    private JLabel jLabel_checkInValue;
    private JLabel jLabel_empty2;

    public MouseExampleView() throws HeadlessException {
        this.model = new MouseExampleModel();
        this.init();
    }

    private void init() {
        this.setTitle("Mouse Example");
        this.setSize(1200, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        MouseExampleCotroller mouseExampleCotroller = new MouseExampleCotroller(this);
        jPanel_mouse = new JPanel();
        jPanel_mouse.setBackground(Color.CYAN);
        jPanel_mouse.addMouseListener(mouseExampleCotroller);
        jPanel_mouse.addMouseMotionListener(mouseExampleCotroller);

        JPanel jPanel_info = new JPanel();
        jPanel_info.setLayout(new GridLayout(3, 3));

        Font font = new Font("Arial", Font.BOLD, 30);

        jLabel_position = new JLabel("Position: ");
        jLabel_position.setFont(font);
        jLabel_x = new JLabel("x = ");
        jLabel_x.setFont(font);
        jLabel_y = new JLabel("y = ");
        jLabel_y.setFont(font);
        jLabel_count = new JLabel("Number of clicks: ");
        jLabel_count.setFont(font);
        jLabel_countValue = new JLabel("n");
        jLabel_countValue.setFont(font);
        jLabel_empty1 = new JLabel();
        jLabel_empty1.setFont(font);
        jLabel_checkIn = new JLabel("Mouse is in component: ");
        jLabel_checkIn.setFont(font);
        jLabel_checkInValue = new JLabel("no");
        jLabel_checkInValue.setFont(font);
        jLabel_empty2 = new JLabel();
        jLabel_empty2.setFont(font);

        jPanel_info.add(jLabel_position);
        jPanel_info.add(jLabel_x);
        jPanel_info.add(jLabel_y);
        jPanel_info.add(jLabel_count);
        jPanel_info.add(jLabel_countValue);
        jPanel_info.add(jLabel_empty1);
        jPanel_info.add(jLabel_checkIn);
        jPanel_info.add(jLabel_checkInValue);
        jPanel_info.add(jLabel_empty2);

        this.setLayout(new BorderLayout());
        this.add(jPanel_mouse, BorderLayout.CENTER);
        this.add(jPanel_info, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public void click() {
        this.model.addClick();
        this.jLabel_countValue.setText(this.model.getCount() + "");
    }

    public void enter() {
        this.model.enter();
        this.jLabel_checkInValue.setText(this.model.getCheckIn());
    }

    public void exit() {
        this.model.exit();
        this.jLabel_checkInValue.setText(this.model.getCheckIn());
    }

    public void update(int x, int y) {
        this.model.setX(x);
        this.model.setY(y);
        this.jLabel_x.setText(this.model.getX() + "");
        this.jLabel_y.setText(this.model.getY() + "");
    }
}