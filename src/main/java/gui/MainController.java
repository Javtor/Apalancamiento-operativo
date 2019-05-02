package gui;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import modelo.Apalancamiento;

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
	
	private void numEx() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Information Dialog");
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
			
			ap.setCostoFijo(cf);
			ap.setCostoVariable(cv);
			ap.setPrecioVenta(pv);
			ap.setUnidadesVendidas(can);
			updateUI();
		} catch(NumberFormatException e) {
			numEx();
		}
    }

    @FXML
    void simular(ActionEvent event) {
    	System.out.println("si");
    }
}
