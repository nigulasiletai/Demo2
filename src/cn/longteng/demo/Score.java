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
		
		JFreeChart chart=ChartFactory.createBarChart3D("小学生在线测试分数结果", "测试的次数", "分数", dataset,  PlotOrientation.VERTICAL, true, false,false);
		
		CategoryPlot plot=chart.getCategoryPlot();
		
		CategoryAxis domainAxis=plot.getDomainAxis(); 
		
		domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题

        domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题
        
        domainAxis.setUpperMargin(0.2); 
        //设置距离图片右端距离 
        domainAxis.setLowerMargin(0.1); 
        //透明度
       // plot.setForegroundAlpha(1.0f); 

        ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状

        rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));

        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));

        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体
        
        BarRenderer3D renderer = new BarRenderer3D();//3D属性修改 
        
        plot.setRenderer(renderer);//将修改后的属性值保存到图中 
       
        renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator()); 
        
        renderer.setBaseItemLabelsVisible(true);
        
        renderer.setBaseItemLabelPaint(Color.BLUE);//
        
        frame1=new ChartPanel(chart,true); 
        
        frame=new JFrame("小学生在线混合运算测试统计图");

	    frame.setLayout(new GridLayout(2,2,10,10));

	    frame.add(getChartPanel());           //添加柱形图

	    frame.setBounds(300, 50, 600, 650);

	    frame.setVisible(true);
	    Clos();
	}

	
	public CategoryDataset getData(Gu g) {
		// TODO Auto-generated method stub
		 DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		 this.lis=g.lis;
		 for(int i=0;i<g.w;i++){
			 dataset.addValue(lis.get(i),"","第"+i+"轮测试");
		 }
         return dataset;
	}
	
	public ChartPanel getChartPanel(){
	    return frame1;
	}
	
	public static  void Clos(){
		 frame.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 int i=JOptionPane.showConfirmDialog(null, "是否再次测试","系统提示",JOptionPane.INFORMATION_MESSAGE);
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
