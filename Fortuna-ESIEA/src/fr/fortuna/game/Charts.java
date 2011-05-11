package fr.fortuna.game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.TextAnchor;

import fr.fortuna.Tirage.TirageLoto;
import fr.fortuna.controller.Loto;
import fr.fortuna.dao.CsvTirageDAO;
import fr.fortuna.dao.LotoCsvTirageDAO;

public class Charts extends ApplicationFrame {
	
	public Charts(String title){
		super(title);
		/*JPanel pan = new JPanel(new BorderLayout());
		JPanel panNord= new JPanel();
		pan.add(panNord, BorderLayout.NORTH);
		JPanel panMid= new JPanel();
		pan.add(panMid, BorderLayout.CENTER);*/
		//JPanel jpanel = createDemoPanel();
        //jpanel.setPreferredSize(new Dimension(500, 270));
        //setContentPane(jpanel);
        List<fr.fortuna.controller.TirageLoto> tirages = new ArrayList<fr.fortuna.controller.TirageLoto>();
        String ligne1="2008080;2;SA;20081004;20081204;33;32;42;16;15;49;37;15-16-32-33-42-49;;2;904940;8;10953,9;213;1400,3;589;61,6;11911;30,8;20552;5,4;255211;2,7;7 523 262;eur;";
String ligne2="2008080;1;SA;20081004;20081204;36;9;16;27;25;12;48;9-12-16-25-27-36;;3;282006;7;12513,4;461;662,5;1033;32;22997;16;25950;3,6;391755;1,8;7 523 262;eur;";
String ligne3="2008079;2;ME;20081001;20081201;41;16;14;18;10;21;24;10-14-16-18-21-41;;2;793603;8;9604,1;231;1138,8;743;40,6;15920;20,3;21248;4,4;279631;2,2;4 114 098;eur;";
String ligne4="2008079;1;ME;20081001;20081201;29;28;3;1;6;37;11;1-3-6-28-29-37;;0;0;7;10970,6;249;1059,2;1200;41;14790;20,5;32257;8,2;289766;4,1;4 114 098;eur;";
String ligne5="2008078;2;SA;20080927;20081127;24;47;39;42;45;35;46;24-35-39-42-45-47;;2;900725;2;41972,1;358;844,8;608;47,4;15683;23,7;17963;5,2;268384;2,6;8 931 007;eur;";
String ligne6="2008078;1;SA;20080927;20081127;28;7;24;35;32;23;33;7-23-24-28-32-35;;2;419649;7;12455;250;1193,2;601;47,2;15781;23,6;18635;4,4;321203;2,2;8 931 007;eur;";
        fr.fortuna.controller.TirageLoto tl1 = lineToTirage(ligne1);
        tirages.add(tl1);
        fr.fortuna.controller.TirageLoto tl2 = lineToTirage(ligne2);
        tirages.add(tl2);
        fr.fortuna.controller.TirageLoto tl3 = lineToTirage(ligne3);
        tirages.add(tl3);
        fr.fortuna.controller.TirageLoto tl4 = lineToTirage(ligne4);
        tirages.add(tl4);
        fr.fortuna.controller.TirageLoto tl5 = lineToTirage(ligne5);
        tirages.add(tl5);
        fr.fortuna.controller.TirageLoto tl6= lineToTirage(ligne6);
        tirages.add(tl6);
        Loto loto = new Loto(tirages);
        HashMap<fr.fortuna.controller.TirageLoto, HashMap<Integer, Double>> maMap=loto.calculStatGagnant();
       //System.out.println(maMap.get(1).get(1));
	}
	

  /*  private static CategoryDataset createDataset() {
        double ad[][] = {
            {
                4D, 3D, -2D, 3D, 6D
            }
        };
        return DatasetUtilities.createCategoryDataset("Series ", "Category ", ad);
    }

    private static JFreeChart createChart(CategoryDataset categorydataset) {
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo 3", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setNoDataMessage("NO DATA!");
        categoryplot.setRangePannable(true);
        Paint apaint[] = {
            new Color(196, 215, 216), new Color(78, 137, 139), new Color(138, 177, 178), new Color(19, 97, 100)
        };
        CustomRenderer customrenderer = new CustomRenderer(apaint);
        customrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        customrenderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0D);
        customrenderer.setBasePositiveItemLabelPosition(itemlabelposition);
        categoryplot.setRenderer(customrenderer);
        CategoryMarker categorymarker = new CategoryMarker("Category 3");
        categorymarker.setLabel("Special");
        categorymarker.setPaint(new Color(221, 255, 221, 128));
        categorymarker.setAlpha(0.5F);
        categorymarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        categorymarker.setLabelTextAnchor(TextAnchor.TOP_LEFT);
        categorymarker.setLabelOffsetType(LengthAdjustmentType.CONTRACT);
        categoryplot.addDomainMarker(categorymarker, Layer.BACKGROUND);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLowerMargin(0.14999999999999999D);
        numberaxis.setUpperMargin(0.14999999999999999D);
        NumberAxis numberaxis1 = new NumberAxis(null);
        numberaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis1.setLowerMargin(0.14999999999999999D);
        numberaxis1.setUpperMargin(0.14999999999999999D);
        categoryplot.setRangeAxis(1, numberaxis1);
        CategoryAxis categoryaxis = new CategoryAxis(null);
        categoryplot.setDomainAxis(1, categoryaxis);
        java.util.List list = Arrays.asList(new Integer[] {
            new Integer(0), new Integer(1)
        });
        categoryplot.mapDatasetToDomainAxes(0, list);
        categoryplot.mapDatasetToRangeAxes(0, list);
        ChartUtilities.applyCurrentTheme(jfreechart);
        return jfreechart;
    }

    public static JPanel createDemoPanel() {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }*/

    public static void main(String args[]) {
        Charts c= new Charts("titre");
    }
	
	private fr.fortuna.controller.TirageLoto lineToTirage(String line) {
		String[] values = line.split(";");

		fr.fortuna.controller.TirageLoto t=new fr.fortuna.controller.TirageLoto();
		
		t.setNumeroDeTirage(values[0]);
		t.setOrdreDeTirage(Integer.valueOf(values[1]));
		t.setJour(values[2]);
		t.setDateTirage(values[3]);
		t.setDateForclusion(values[4]);
		
		int[] boules=new int[6];
		int i=0;
		for(;i<6;i++)
			boules[i]=Integer.valueOf(values[5+i]);
		
		t.setBoules(boules);
		t.setBouleComplementaire(Integer.valueOf(values[5+i]));
		t.setNumeroJoker(values[7+i]);
		int j=0;
		int[] nbGag=new int[7];
		double[] Rap=new double[7];
		for(;j<14;j+=2)
		{
			nbGag[j/2]=Integer.valueOf(values[8+i+j]);
			Rap[j/2]=Double.valueOf(values[8+i+j+1].replace(',', '.'));
		}
		t.setNombreDeGagnantsRg(nbGag);
		t.setRapportRang(Rap);

		t.setNumeroJokerPlus(values[8+i+j]);
		t.setDevise(values[8+i+j+1]);

		t.calcNombreDeGagnants();
		t.calcGain();
		t.calcGainParRg();
		
		return t;
	}


}
