package gui;

import java.net.URL;
import java.text.NumberFormat;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
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
        ap.setPrecioVenta(15);
        ap.setUnidadesVendidas(2);
        ap.setCostoVariable(20);
        ap.setCostoFijo(10);
        updateUI();
    }

	private void updateUI() {
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		lblVentas.setText(formatter.format(Double.parseDouble(ap.getVentas())));
		lblCV.setText("("+formatter.format(Double.parseDouble(ap.getCostosVariables()))+")");
		lblMC.setText(""+formatter.format(Double.parseDouble(ap.getMargenContribucion()))+"");
		lblCF.setText("("+formatter.format(ap.getCostoFijo())+")");
		lblUO.setText(formatter.format(Double.parseDouble(ap.utOperativa())));
		lblAO.setText(String.format("%.2f", Double.parseDouble(ap.apOperativo())));
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("Information Dialog");
//		alert.setHeaderText(null);
//		alert.setContentText("I have a great message for you!");
//
//		alert.showAndWait();
	}
}
