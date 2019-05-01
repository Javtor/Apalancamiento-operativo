package modelo;

public class Apalancamiento {

	private double precioVenta;
	private double costoVariable;
	private double costoFijo;
	private int unidadesVendidas;

	public Apalancamiento(double precioVenta, double costoVariable, double costoFijo, int unidadesVendidas) {
		super();
		this.precioVenta = precioVenta;
		this.costoVariable = costoVariable;
		this.costoFijo = costoFijo;
		this.unidadesVendidas = unidadesVendidas;
	}

	public void simularAumentoVentas(double porcentaje) {

	}

	public void actualizarInfo(double precioVenta, double costoVariable, double costoFijo, int unidadesVendidas) {
		this.precioVenta = precioVenta;
		this.costoVariable = costoVariable;
		this.costoFijo = costoFijo;
		this.unidadesVendidas = unidadesVendidas;
	}

	public String estadoDeResultados() {
		StringBuilder estado = new StringBuilder("Estado de resultados - Margen de contribución\n");
		estado.append("Ventas: " + getVentas());
		estado.append("Costos variables: " + getCostosVariables());
		estado.append("Margen de contribución: " + getMargenContribucion());
		estado.append("Costos fijos: ");
		estado.append("Utilidad operativa: ");
		return estado.toString();
	}

	private String getMargenContribucion() {
		// TODO Auto-generated method stub
		return null;
	}

	private String getCostosVariables() {
		return costoVariable * unidadesVendidas + "";
	}

	private String getVentas() {
		return precioVenta * unidadesVendidas + "";
	}

	public double getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(double precioVenta) {
		this.precioVenta = precioVenta;
	}

	public double getCostoVariable() {
		return costoVariable;
	}

	public void setCostoVariable(double costoVariable) {
		this.costoVariable = costoVariable;
	}

	public double getCostoFijo() {
		return costoFijo;
	}

	public void setCostoFijo(double costoFijo) {
		this.costoFijo = costoFijo;
	}

	public int getUnidadesVendidas() {
		return unidadesVendidas;
	}

	public void setUnidadesVendidas(int unidadesVendidas) {
		this.unidadesVendidas = unidadesVendidas;
	}

}
