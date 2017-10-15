package beans;

public class BeanProveProdMarUmed {
//COD_PROVE, NOM_PROVE, COD_PROD, NOM_PROD, COD_MAR, NOM_MAR, COD_UMED, 
//	NOM_UMED, COS_DET, MON_DET, IGV_DET, FEC_DET, OBS_DET
	String codigo_proveprodmarumed,codProve,nomProve,codProd,nomProd,codMar,nomMar,codUmed,nomUmed;
	double cosDet; 
	String monDet,igvDet,obsDet,fecDet,estDet;
	
	public BeanProveProdMarUmed() {
		super();
	}

	public BeanProveProdMarUmed(String codigo_proveprodmarumed,
			String codProve, String nomProve, String codProd, String nomProd,
			String codMar, String nomMar, String codUmed, String nomUmed,
			double cosDet, String monDet, String igvDet, String obsDet,
			String fecDet, String estDet) {
		super();
		this.codigo_proveprodmarumed = codigo_proveprodmarumed;
		this.codProve = codProve;
		this.nomProve = nomProve;
		this.codProd = codProd;
		this.nomProd = nomProd;
		this.codMar = codMar;
		this.nomMar = nomMar;
		this.codUmed = codUmed;
		this.nomUmed = nomUmed;
		this.cosDet = cosDet;
		this.monDet = monDet;
		this.igvDet = igvDet;
		this.obsDet = obsDet;
		this.fecDet = fecDet;
		this.estDet = estDet;
	}

	public String getCodigo_proveprodmarumed() {
		return codigo_proveprodmarumed;
	}

	public void setCodigo_proveprodmarumed(String codigo_proveprodmarumed) {
		this.codigo_proveprodmarumed = codigo_proveprodmarumed;
	}

	public String getCodProve() {
		return codProve;
	}

	public void setCodProve(String codProve) {
		this.codProve = codProve;
	}

	public String getNomProve() {
		return nomProve;
	}

	public void setNomProve(String nomProve) {
		this.nomProve = nomProve;
	}

	public String getCodProd() {
		return codProd;
	}

	public void setCodProd(String codProd) {
		this.codProd = codProd;
	}

	public String getNomProd() {
		return nomProd;
	}

	public void setNomProd(String nomProd) {
		this.nomProd = nomProd;
	}

	public String getCodMar() {
		return codMar;
	}

	public void setCodMar(String codMar) {
		this.codMar = codMar;
	}

	public String getNomMar() {
		return nomMar;
	}

	public void setNomMar(String nomMar) {
		this.nomMar = nomMar;
	}

	public String getCodUmed() {
		return codUmed;
	}

	public void setCodUmed(String codUmed) {
		this.codUmed = codUmed;
	}

	public String getNomUmed() {
		return nomUmed;
	}

	public void setNomUmed(String nomUmed) {
		this.nomUmed = nomUmed;
	}

	public double getCosDet() {
		return cosDet;
	}

	public void setCosDet(double cosDet) {
		this.cosDet = cosDet;
	}

	public String getMonDet() {
		return monDet;
	}

	public void setMonDet(String monDet) {
		this.monDet = monDet;
	}

	public String getIgvDet() {
		return igvDet;
	}

	public void setIgvDet(String igvDet) {
		this.igvDet = igvDet;
	}

	public String getObsDet() {
		return obsDet;
	}

	public void setObsDet(String obsDet) {
		this.obsDet = obsDet;
	}

	public String getFecDet() {
		return fecDet;
	}

	public void setFecDet(String fecDet) {
		this.fecDet = fecDet;
	}

	public String getEstDet() {
		return estDet;
	}

	public void setEstDet(String estDet) {
		this.estDet = estDet;
	}
	
	
}
