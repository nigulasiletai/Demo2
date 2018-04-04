package cn.longteng.demo;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class Score extends JFrame{
	ChartPanel frame1;
    static JFrame frame;
	static Gu gu=new Gu();
	static Main m = new Main();
	static ArrayList<Integer> lis=new ArrayList();
	public Score(){
        CategoryDataset dataset=getData(gu);
		
		JFreeChart chart=ChartFactory.createBarChart3D("Сѧ�����߲��Է������", "���ԵĴ���", "����", dataset,  PlotOrientation.VERTICAL, true, false,false);
		
		CategoryPlot plot=chart.getCategoryPlot();
		
		CategoryAxis domainAxis=plot.getDomainAxis(); 
		
		domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����

        domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����
        
        domainAxis.setUpperMargin(0.2); 
        //���þ���ͼƬ�Ҷ˾��� 
        domainAxis.setLowerMargin(0.1); 
        //͸����
       // plot.setForegroundAlpha(1.0f); 

        ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״

        rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));

        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));

        chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������
        
        BarRenderer3D renderer = new BarRenderer3D();//3D�����޸� 
        
        plot.setRenderer(renderer);//���޸ĺ������ֵ���浽ͼ�� 
       
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        
        renderer.setBaseItemLabelsVisible(true);
        
        renderer.setBaseItemLabelPaint(Color.BLUE);//
        
        frame1=new ChartPanel(chart,true); 
        
        frame=new JFrame("Сѧ�����߻���������ͳ��ͼ");

	    frame.setLayout(new GridLayout(2,2,10,10));

	    frame.add(getChartPanel());           //�������ͼ

	    frame.setBounds(300, 50, 600, 650);

	    frame.setVisible(true);
	    Clos();
	}

	
	public CategoryDataset getData(Gu g) {
		// TODO Auto-generated method stub
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 this.lis=g.lis;
		 for(int i=0;i<g.w;i++){
			 dataset.addValue(lis.get(i),"","��"+i+"�ֲ���");
		 }
         return dataset;
	}
	
	public ChartPanel getChartPanel(){
	    return frame1;
	}
	
	public static  void Clos(){
		 frame.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 int i=JOptionPane.showConfirmDialog(null, "�Ƿ��ٴβ���","ϵͳ��ʾ",JOptionPane.INFORMATION_MESSAGE);
				 if(i==JOptionPane.YES_OPTION){
					Gu g = new Gu();
					g.Jiemian();
					g.SetLab(m);
					g.Chann();
					frame.dispose();
					//g.Time();
					g.Ch();
				 }
				 else {
					 System.exit(0);
				 }
			 }
		 });
	}
	
}
