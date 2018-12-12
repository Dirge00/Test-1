package RGR;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorApp {

	public static void main(String[] args) throws InterruptedException {
		Calculator calc = new Calculator(args); //�������� ������� ������ ������������
		calc.setVisible(true); //������� ����������� �������

	}

}

class Calculator extends JFrame implements ActionListener{
	 JLabel label1, label2, label3; //�������� �������� ��������
	 JButton countB; //�������� ������� ������
	 JTextField textField1, textField2, textField3; //�������� �������� ��������� �����
	 JPanel panel; //�������� ������� ������
	 
	public Calculator(String[] args) throws InterruptedException {
		super("Calculator"); //�������� �������� ����
		setBounds(200, 200, 200, 200); //�������� ������� ����
		if(args.length!=0) { //���� ������� ���� �������� ������� ������, �� ��� �������� � ���� �����
			textField1 = new JTextField(args[0], 2); //������������� ���������� ����
			textField2 = new JTextField(args[1], 2); //������������� ���������� ����
			textField3 = new JTextField(args[2], 2); //������������� ���������� ����
		}
		else { //���� ������� �� ���� �������� ������� ������, �� ���� ����� �������
			textField1 = new JTextField("", 2); //������������� ���������� ����
			textField2 = new JTextField("", 2); //������������� ���������� ����
			textField3 = new JTextField("", 2); //������������� ���������� ����
		}
		label1 = new JLabel("������� ���� ������������."); //������������� �������
		label2 = new JLabel("��� ��������� ���� ������������ �������������?"); //������������� �������	
		label3 = new JLabel("��� ��������� ���� ������������ ������ �������?"); //������������� �������
		countB = new JButton("�������� ������"); //������������ ������
		panel = new JPanel(new FlowLayout());  //������������� ������
		panel.add(label1); //���������� �� ������ �������
		panel.add(textField1); //���������� �� ������ ���������� ����
		panel.add(label2); //���������� �� ������ �������
		panel.add(textField2); //���������� �� ������ ���������� ����
		panel.add(label3); //���������� �� ������ �������
		panel.add(textField3); //���������� �� ������ ���������� ����
		panel.add(countB); //���������� �� ������ ������
		countB.addActionListener(this); //���������� ��������� ������
		add(panel); //���������� ������ �� ����
		pack(); //������������� ����� ����������� ������ ����, ������� ���������� ��� ����������� ���� ��� �����������
		Thread th = new Thread(new Runnable() { //�������� ���������� ������, ���������������� ��� �������� � ��������������
			public void run() {
				try {
					Thread.sleep(3000); //�������� 3 �������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				countB.doClick(); //������� ������� ������
				try {
					Thread.sleep(3000); //�������� 3 �������
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0); //���������� ���������
			}
		});
		if(args.length !=0)
			th.start(); //������ ���������� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //��� ������� �� ������� ��������� ����� �����������
	}

	public void actionPerformed(ActionEvent e) { //��� ����� ������ ������ ��� �������
		if(!(textField1.getText().equals(" ") || textField2.getText().equals(" ") || textField3.getText().equals(" ")) ) //���� ��� ��� ���� ��� ����� �� �����
			JOptionPane.showMessageDialog(null, "��� ���������� ��������� ������������ � ���������� " + (20/(Integer.valueOf(textField1.getText()) + Integer.valueOf(textField2.getText()) + Integer.valueOf(textField3.getText()) ) + "." ) ); //������ ��������� ��� ���������� ��������� �������������
	}
}
