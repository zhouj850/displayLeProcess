package displayLeProcess;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Display extends JFrame
{
    /**
     * @Description:��������ڽ�����ʾ
     * @author �ܽ�
     * @date 2016/06/20
     */
    private static final long serialVersionUID = 1L;

    public static final int BOARD_WIDTH = 700;
    
    public static final int BOARD_HEIGHT = 600;
    
    public static final int X_LOCATION = 100;
    
    public static final int Y_LOCATION = 50;
    
    private LeProcess leProcess;
    
    private Display disPlay = this;
    
    //�ѽ����Ϊ��������Panel
    JPanel editPanel = new JPanel();
    
    JPanel expPanel = new JPanel();
    
    JPanel denvPanel = new JPanel();
    
    JPanel centerPanel = new JPanel();
  
    JPanel buttonPanel = new JPanel();
    
    //������ʽ
    JTextField expField = new JTextField(30);
    
    JLabel labelExp = new JLabel("���ʽ��: ", JLabel.RIGHT);
    
   //���붯̬����
    JTextField denvField = new JTextField(30);
    
    JLabel labelDEnv = new JLabel("��̬����: ", JLabel.RIGHT);
    
    //���
    JTextArea txtArea = new JTextArea(10, 50);
    
    JLabel labelTxt = new JLabel("���:");
    
    JScrollPane scroll  = new JScrollPane(txtArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    
    //��ť
    JButton startButton = new JButton("��ʼ");
    
    JButton cancelButton = new JButton("ȡ��");
    
    public void launchFrame()
        throws Exception
    {
       
        
       
        expPanel.add(labelExp);
        expField.setText("ge(add(var(x),mul(cons(2),var(y))),var(z))");
        expPanel.add(expField);
        
        denvPanel.add(labelDEnv);
        denvField.setText("[x->34, y->7, z->50]");
        denvPanel.add(denvField);
        
        editPanel.setLayout(new GridLayout(2,1)); 
        editPanel.add(expPanel);
        editPanel.add(denvPanel);
        
        centerPanel.setLayout(new FlowLayout());
        centerPanel.add(labelTxt);
        centerPanel.add(scroll);
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(startButton);
        buttonPanel.add(cancelButton);
        
        //�����ʼ��
        this.setLocation(X_LOCATION, Y_LOCATION);
        this.setSize(BOARD_WIDTH, BOARD_HEIGHT);
        this.setResizable(true);
        this.setVisible(true);
        this.setTitle("����Le�ļ������");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(3, 1)); //����Ϊ����һ�в���
        this.add(editPanel);
        this.add(centerPanel);
        this.add(buttonPanel);
        
 
  
        startButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                String exp = expField.getText();
                String denv = denvField.getText();
                leProcess=new LeProcess(exp,denv,disPlay);
                leProcess.Start();

            }
        });
        cancelButton.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                txtArea.setText("");
            }
        });
        this.addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
    }
    
    public void OutputResult(String result)
    {
        txtArea.append(result + "\n");
    }
    
    public static void main(String[] args)
        throws Exception
    {
        new Display().launchFrame();
    }
    
}
