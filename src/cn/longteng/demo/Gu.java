package cn.longteng.demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.*;

public class Gu extends JFrame {
	static JFrame j;
	static JPanel jp, p1, p2;
	JLabel[] lab = new JLabel[20];
	JLabel[] lab3 = new JLabel[20];
	static JTextField[] txt = new JTextField[20];
	static JButton btn;
	static JLabel lab1;

	String[] str = new String[200];
	int[] num = new int[200];
	String[] sr = new String[20];
	static int[] nm = new int[20];
	static long time = 1800;
	static Main m = new Main();
	static int[] res=new int[20];
	static int counter=0;
	static String[] srs=new String[20];
	static int n;
	static int w;
	static ArrayList<Integer> lis=new ArrayList();
	public Gu() {
					
	}
	
	public void Jiemian(){
		j = new JFrame("小学生在线混合运算题库");
		j.setSize(1366, 735);
		jp = new JPanel();
		jp.setLayout(new BorderLayout());
		p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p2 = new JPanel();
		p2.setLayout(new GridLayout(10, 5, 10, 40));
		btn = new JButton("提交");
		lab1 = new JLabel();	
		
		for (int k = 0; k < 20; k++) {
			lab[k] = new JLabel("");
			txt[k] = new JTextField("   ");
			lab3[k] = new JLabel("                  ");
		}

		for (int i = 0; i < 20; i++) {
			p2.add(lab3[i]);
			p2.add(lab[i]);
			p2.add(txt[i]);
		}

		p1.add(lab1, BorderLayout.WEST);
		p1.add(btn, BorderLayout.EAST);
		j.add(jp);
		jp.add(p1, BorderLayout.NORTH);
		jp.add(p2, BorderLayout.CENTER);
		j.setVisible(true);
		j.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
	}
	
	public void SetLab(Main s) {
		try {
			s.Num();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.str = Main.ts;
		this.num = Main.s;
		int i = 0;
		for (int l = 0; l < 200; l = l + 10) {
			while (i < 20) {
				sr[i] = str[l];
				nm[i] = num[l];
				lab[i].setText(sr[i]);
				i++;
				break;
			}
		}	
		}
	
	
	public  void Time() {
		while(time >0) {
			long mm = time / 60 % 60;
			long ss = time % 60;
			lab1.setText("剩余答题时间：" + mm + ":" + ss);
			time--;
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 	   
		}
	}

	public void Chann(){
	
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==btn){
					for(int x=0;x<20;x++){
						srs[x]=txt[x].getText().replaceAll(" ","");
						if(srs[x].equals("")){
							res[x]=0;
						}
						else{
							res[x]=Integer.parseInt(srs[x].replaceAll(" ", ""));
							if(res[x]==nm[x]){
								counter+=5;
							}
						}
					}
					lis.add(counter);
					n=JOptionPane.showConfirmDialog(j, "是否提交？","系统提示",JOptionPane.INFORMATION_MESSAGE);
					if(n==JOptionPane.YES_OPTION){
						j.dispose();
						w++;
						new Score();	
					}
					else{
						return;
					}
					
				}
			}
			
		});	
	}
	
	public void Ch(){
		if(time==0){
			for(int k=0;k<20;k++){
				srs[k]=txt[k].getText().replaceAll(" ","");
				if(srs[k].equals("")){
					res[k]=0;	
					
		     	}else{
			
				res[k]=Integer.parseInt(srs[k].replaceAll(" ", ""));
				if(res[k]==nm[k]){
					counter+=5;
				}
			}
		}
			lis.add(counter);
			j.dispose();
			w++;
			new Score();
		}
	}

}
