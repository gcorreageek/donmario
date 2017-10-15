package beans;

public class BeanCotizacionVarios {
	//COD_COT, IDE_COT, NUM_ITEM, COD_CLI, CAN_COT,
	//UMED_PROD, NOM_PRODALT, COD_PROD, COD_PRODALT,
	//NOM_MAR, P.Total $, Total $, Costo $, Total $,
	//Dif. $, FEC_DET, COD_CAM, COD_VEN, PORGA_COT, NOM_PROVE, COD_PROVE
	
	//COD_COT, IDE_COT, NUM_ITEM, COD_CLI, CAN_COT,
	//COD_UMED, NOM_UMED, NOM_PRODALT, COD_PROD, COD_PRODALT,
	//NOM_MAR, P.Total $, Total $, Costo $, Total $,
	//Dif. $, FEC_DET, COD_CAM, COD_VEN, PORGA_COT, NOM_PROVE, COD_PROVE, COD_MAR
	String codcot,idecot,numitem,codcli,cancot,umedprod,nomprod,codprod,nommar,costeEntreporc,
	igv$,costeXporcXcant,total$,coste,costeXcant,dife,punits,igvs,ptotals,
	totals,fecdet,codcam,codven,porgacot,nomprove,codprove,codmar,codumed,codCoste,
	pesoprod,tiempoentrega,pesoCarrete,modprod,espprod;

	public BeanCotizacionVarios() {
		super();
	}

	public BeanCotizacionVarios(String codcot, String idecot, String numitem,
			String codcli, String cancot, String umedprod, String nomprod,
			String codprod, String nommar, String costeEntreporc, String igv$,
			String costeXporcXcant, String total$, String coste,
			String costeXcant, String dife, String punits, String igvs,
			String ptotals, String totals, String fecdet, String codcam,
			String codven, String porgacot, String nomprove, String codprove,
			String codmar, String codumed, String codCoste, String pesoprod,
			String tiempoentrega, String pesoCarrete, String modprod,
			String espprod) {
		super();
		this.codcot = codcot;
		this.idecot = idecot;
		this.numitem = numitem;
		this.codcli = codcli;
		this.cancot = cancot;
		this.umedprod = umedprod;
		this.nomprod = nomprod;
		this.codprod = codprod;
		this.nommar = nommar;
		this.costeEntreporc = costeEntreporc;
		this.igv$ = igv$;
		this.costeXporcXcant = costeXporcXcant;
		this.total$ = total$;
		this.coste = coste;
		this.costeXcant = costeXcant;
		this.dife = dife;
		this.punits = punits;
		this.igvs = igvs;
		this.ptotals = ptotals;
		this.totals = totals;
		this.fecdet = fecdet;
		this.codcam = codcam;
		this.codven = codven;
		this.porgacot = porgacot;
		this.nomprove = nomprove;
		this.codprove = codprove;
		this.codmar = codmar;
		this.codumed = codumed;
		this.codCoste = codCoste;
		this.pesoprod = pesoprod;
		this.tiempoentrega = tiempoentrega;
		this.pesoCarrete = pesoCarrete;
		this.modprod = modprod;
		this.espprod = espprod;
	}

	public String getCodcot() {
		return codcot;
	}

	public void setCodcot(String codcot) {
		this.codcot = codcot;
	}

	public String getIdecot() {
		return idecot;
	}

	public void setIdecot(String idecot) {
		this.idecot = idecot;
	}

	public String getNumitem() {
		return numitem;
	}

	public void setNumitem(String numitem) {
		this.numitem = numitem;
	}

	public String getCodcli() {
		return codcli;
	}

	public void setCodcli(String codcli) {
		this.codcli = codcli;
	}

	public String getCancot() {
		return cancot;
	}

	public void setCancot(String cancot) {
		this.cancot = cancot;
	}

	public String getUmedprod() {
		return umedprod;
	}

	public void setUmedprod(String umedprod) {
		this.umedprod = umedprod;
	}

	public String getNomprod() {
		return nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getCodprod() {
		return codprod;
	}

	public void setCodprod(String codprod) {
		this.codprod = codprod;
	}

	public String getNommar() {
		return nommar;
	}

	public void setNommar(String nommar) {
		this.nommar = nommar;
	}

	public String getCosteEntreporc() {
		return costeEntreporc;
	}

	public void setCosteEntreporc(String costeEntreporc) {
		this.costeEntreporc = costeEntreporc;
	}

	public String getIgv$() {
		return igv$;
	}

	public void setIgv$(String igv$) {
		this.igv$ = igv$;
	}

	public String getCosteXporcXcant() {
		return costeXporcXcant;
	}

	public void setCosteXporcXcant(String costeXporcXcant) {
		this.costeXporcXcant = costeXporcXcant;
	}

	public String getTotal$() {
		return total$;
	}

	public void setTotal$(String total$) {
		this.total$ = total$;
	}

	public String getCoste() {
		return coste;
	}

	public void setCoste(String coste) {
		this.coste = coste;
	}

	public String getCosteXcant() {
		return costeXcant;
	}

	public void setCosteXcant(String costeXcant) {
		this.costeXcant = costeXcant;
	}

	public String getDife() {
		return dife;
	}

	public void setDife(String dife) {
		this.dife = dife;
	}

	public String getPunits() {
		return punits;
	}

	public void setPunits(String punits) {
		this.punits = punits;
	}

	public String getIgvs() {
		return igvs;
	}

	public void setIgvs(String igvs) {
		this.igvs = igvs;
	}

	public String getPtotals() {
		return ptotals;
	}

	public void setPtotals(String ptotals) {
		this.ptotals = ptotals;
	}

	public String getTotals() {
		return totals;
	}

	public void setTotals(String totals) {
		this.totals = totals;
	}

	public String getFecdet() {
		return fecdet;
	}

	public void setFecdet(String fecdet) {
		this.fecdet = fecdet;
	}

	public String getCodcam() {
		return codcam;
	}

	public void setCodcam(String codcam) {
		this.codcam = codcam;
	}

	public String getCodven() {
		return codven;
	}

	public void setCodven(String codven) {
		this.codven = codven;
	}

	public String getPorgacot() {
		return porgacot;
	}

	public void setPorgacot(String porgacot) {
		this.porgacot = porgacot;
	}

	public String getNomprove() {
		return nomprove;
	}

	public void setNomprove(String nomprove) {
		this.nomprove = nomprove;
	}

	public String getCodprove() {
		return codprove;
	}

	public void setCodprove(String codprove) {
		this.codprove = codprove;
	}

	public String getCodmar() {
		return codmar;
	}

	public void setCodmar(String codmar) {
		this.codmar = codmar;
	}

	public String getCodumed() {
		return codumed;
	}

	public void setCodumed(String codumed) {
		this.codumed = codumed;
	}

	public String getCodCoste() {
		return codCoste;
	}

	public void setCodCoste(String codCoste) {
		this.codCoste = codCoste;
	}

	public String getPesoprod() {
		return pesoprod;
	}

	public void setPesoprod(String pesoprod) {
		this.pesoprod = pesoprod;
	}

	public String getTiempoentrega() {
		return tiempoentrega;
	}

	public void setTiempoentrega(String tiempoentrega) {
		this.tiempoentrega = tiempoentrega;
	}

	public String getPesoCarrete() {
		return pesoCarrete;
	}

	public void setPesoCarrete(String pesoCarrete) {
		this.pesoCarrete = pesoCarrete;
	}

	public String getModprod() {
		return modprod;
	}

	public void setModprod(String modprod) {
		this.modprod = modprod;
	}

	public String getEspprod() {
		return espprod;
	}

	public void setEspprod(String espprod) {
		this.espprod = espprod;
	}

	


		
}
