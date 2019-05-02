package gui;

import java.net.URL;
import java.text.NumberFormat;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.shape.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import modelo.Apalancamiento;
import javafx.scene.layout.*;
import javafx.scene.Node;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class MainController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblVentas;

    @FXML
    private Label lblCV;

    @FXML
    private Label lblMC;

    @FXML
    private Label lblCF;

    @FXML
    private Label lblUO;

    @FXML
    private Label lblAO;

    @FXML
    private TextField txtPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtFiijos;

    @FXML
    private TextField txtCV;

    @FXML
    private Button btnAct;

    @FXML
    private TextField txtAumentos;

    @FXML
    private Button btnSim;
    
    @FXML
    private LineChart<Number, Number> chart;
    
    private Apalancamiento ap;
    
    @FXML
    void init() {
        ap = new Apalancamiento(0, 0, 0, 0);
        updateUI();
    }

	private void updateUI() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		lblVentas.setText(formatter.format(Double.parseDouble(ap.getVentas())));
		lblCV.setText("("+formatter.format(Double.parseDouble(ap.getCostosVariables()))+")");
		lblMC.setText(""+formatter.format(Double.parseDouble(ap.getMargenContribucion()))+"");
		lblCF.setText("("+formatter.format(ap.getCostoFijo())+")");
		lblUO.setText(formatter.format(Double.parseDouble(ap.utOperativa())));
		lblAO.setText(String.format("%.4f", Math.abs(Double.parseDouble(ap.apOperativo()))));		
		
		
	}
	
	@SuppressWarnings("restriction")
	private void updateChart() {
		chart.getData().clear();
		//Defining X axis  
        //creating the chart    
        chart.setTitle("Unidades vendidas vs Ap. Op.");

        //defining a series
        XYChart.Series<Number, Number> plot = new XYChart.Series();
        plot.setName("Unidades vendidas vs Ap. Op.");
//        //populating the series with data
        int max = Math.max(ap.getUnidadesVendidas()+1, (int)(ap.getPE()*2));
        for (int i = 0; i <= max; i++) {
        	if(i == ap.getPE()) continue;
        	plot.getData().add(new XYChart.Data<Number, Number>(i, ap.apalancamiento(i)));
		}
//        for (XYChart.Data data : plot.getData()) {
//            // this node is StackPane
//        	Node n = data.getNode();
//            StackPane stackPane = (StackPane) data.getNode();
//            stackPane.setVisible(false);
//        }

        int ventas = ap.getUnidadesVendidas();
        double y = ap.apalancamiento(ventas);
        XYChart.Series<Number, Number> actual = new XYChart.Series<Number, Number>();
        actual.setName("Punto actual");
        actual.getData().add(new XYChart.Data<Number, Number>(ventas, y));

        chart.setCreateSymbols(false);
        
        chart.getData().add(plot);
        
        chart.getData().add(actual);
        
        
               
		
	}

	private void numEx(String msg) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(null);
		alert.setContentText("Verifique que los datos sean numeros positivos y que la cantidad vendida sea entera");

		alert.showAndWait();
	}
	
	@FXML
    void actualizar(ActionEvent event) {
		try {
			double pv = Double.parseDouble(txtPrecio.getText());
			int can = Integer.parseInt(txtCantidad.getText());
			double cf = Double.parseDouble(txtFiijos.getText());
			double cv = Double.parseDouble(txtCV.getText());
			
			if(pv < 0 || can < 0 || cf < 0 || cv < 0) {
				throw new NumberFormatException();
			}
			
			if(cv >= pv) {
				numEx("El precio de venta debe ser mayor al costo variable");
			}else {
				ap.setCostoFijo(cf);
				ap.setCostoVariable(cv);
				ap.setPrecioVenta(pv);
				ap.setUnidadesVendidas(can);
				updateUI();
				updateChart();
			}
			
			
		} catch(NumberFormatException e) {
			numEx("Verifique que los datos sean numeros positivos y que la cantidad vendida sea entera");
		}
    }

    @FXML
    void simular(ActionEvent event) {
    	try {
			double porcentaje = Double.parseDouble(txtAumentos.getText());
			
//			if(pv < 0 || can < 0 || cf < 0 || cv < 0) {
//				throw new NumberFormatException();
//			}
			
			ap.simularAumentoVentas(porcentaje);
			txtCantidad.setText(ap.getUnidadesVendidas()+"");
			updateUI();
			updateChart();
			
		} catch(NumberFormatException e) {
			numEx("Verifique que los datos sean numeros positivos y que la cantidad vendida sea entera");
		}
    }
}
