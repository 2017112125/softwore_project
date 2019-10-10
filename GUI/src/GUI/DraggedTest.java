package GUI;

import java.awt.BorderLayout;  
import java.awt.Component;  
import java.awt.EventQueue;  
import java.awt.Color;  
import java.awt.event.MouseAdapter;  
import java.awt.event.MouseEvent;  
  
import javax.swing.BorderFactory;  
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;  
  
  
public class DraggedTest extends JFrame {  
  
    private JPanel contentPane;  
  
    public static void main(String[] args) {  
    	DraggedTest test = new DraggedTest();
    	test.setVisible(true);
    }  
  
    public DraggedTest() {  
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        setSize(660, 500);  
        setLocationRelativeTo(null);  
        contentPane = new JPanel();  
        contentPane.setLayout(new BorderLayout());  
        add(contentPane);  
          
        JPanel panel = new JPanel();  
        contentPane.add(panel, BorderLayout.CENTER);  
        panel.setBorder(BorderFactory.createLineBorder(Color.orange, 2));  
        panel.setLayout(null);  
        
        JLabel text = new JLabel("Hello Wordl");
        text.setBounds(261, 85, 130, 130);
        panel.add(text);
          
        MyListener m = new MyListener();  
        text.addMouseListener(m);
        text.addMouseMotionListener(m);  
    }  
    // дһ����̳������������������������Ϳ���������õķ�����  
    class MyListener extends MouseAdapter{  
        //������x��yΪ������ʱ����Ļ��λ�ú��϶�ʱ���ڵ�λ��  
        int newX,newY,oldX,oldY;  
        //����������Ϊ�����ǰ������  
        int startX,startY;  
      
        @Override  
        public void mousePressed(MouseEvent e) {  
            //��Ϊ�õ��¼�Դ���  
            Component cp = (Component)e.getSource();  
            //�������µ�ʱ���¼�����ǰ����������굱ǰ����Ļ��λ��  
            startX = cp.getX();  
            startY = cp.getY();  
            oldX = e.getXOnScreen();  
            oldY = e.getYOnScreen();  
        }  
        @Override  
        public void mouseDragged(MouseEvent e) {  
            Component cp = (Component)e.getSource();  
            //�϶���ʱ���¼������  
            newX = e.getXOnScreen();  
            newY = e.getYOnScreen();  
            //����bounds,������ʱ��¼�������ʼ����������϶��ľ������  
            cp.setBounds(startX+(newX - oldX), startY+(newY - oldY), cp.getWidth(), cp.getHeight());  
        }  
  
    }  
}  
