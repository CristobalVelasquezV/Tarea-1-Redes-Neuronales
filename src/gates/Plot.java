package gates;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class Plot extends ApplicationFrame {

/**
* Clase Plot Grafica lineas y puntos.
*
* @param String title .
 * @throws Exception 
*/
public Plot(final String title,double[] datax, double[] datay,int type) throws Exception {

   super(title);
   final XYSeries series = new XYSeries("Learning curve");
   if(datax.length==datay.length){
   for(int i=0;i<datax.length;i++){
	   series.add(datax[i],datay[i]);
   }
   }
   else{
		throw new Exception("Distinto numero de datos x e y.");
   }

   final JFreeChart chart;
   final XYSeriesCollection data = new XYSeriesCollection(series);
   if(type==0){
   chart = ChartFactory.createXYLineChart(
       title,
       "N: Number of trainings", 
       "Y: Number of correct points", 
       data,
       PlotOrientation.VERTICAL,
       true,
       true,
       false
   );
   }
   else{
	   
	  chart = ChartFactory.createScatterPlot(
	            title, // chart title
	            "X", // x axis label
	            "Y", // y axis label
	            data, // data  ***-----PROBLEM------***
	            PlotOrientation.VERTICAL,
	            true, // include legend
	            true, // tooltips
	            false // urls
	            );
   }

   final ChartPanel chartPanel = new ChartPanel(chart);
   chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
   setContentPane(chartPanel);
   
   

}


public Plot(final String title,double[] dataxblue,double[] datayblue,double[] dataxred, double[] datayred) throws Exception {

	   super(title);
	   final XYSeries series = new XYSeries("Points of Section 1");
	   final XYSeries series2 = new XYSeries("Points of Section 2");
	   if(dataxblue.length==datayblue.length){
	   for(int i=0;i<dataxblue.length;i++){
		   series.add(dataxblue[i],datayblue[i]);
	   }
	   }
	   else{
			throw new Exception("Distinto numero de datos x e y.");
	   }
	   
	   
	   if(dataxred.length==datayred.length){
		   for(int i=0;i<dataxred.length;i++){
			   series2.add(dataxred[i],datayred[i]);
		   }
		   }
		   else{
				throw new Exception("Distinto numero de datos x e y.");
		   }

	   final JFreeChart chart;
	   final XYSeriesCollection data = new XYSeriesCollection(series);
	   data.addSeries(series2);
		  chart = ChartFactory.createScatterPlot(
		            title, // chart title
		            "X", // x axis label
		            "Y", // y axis label
		            data, // data  ***-----PROBLEM------***
		            PlotOrientation.VERTICAL,
		            true, // include legend
		            true, // tooltips
		            false // urls
		            );
	   

	   final ChartPanel chartPanel = new ChartPanel(chart);
	   chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));
	   setContentPane(chartPanel);
	   
	   

	}
}