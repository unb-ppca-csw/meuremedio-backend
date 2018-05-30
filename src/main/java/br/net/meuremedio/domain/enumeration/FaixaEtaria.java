package br.net.meuremedio.domain.enumeration;

public enum FaixaEtaria {	
	QUINZE_VINTE("15-20"), 
	VINTE_TRINTA("20-30"), 
	TRINTA_QUARENTA("30-40"),
	QUARENTA_CINQUENTA("40-50"),
	CINQUENTA_SETENTA("50-70"),
	MAIOR_QUE_SETENTA("70+");

	private String label;

	private FaixaEtaria(String label) {
		this.label = label;
	}

	public static FaixaEtaria fromLabel(String label) {
		for (FaixaEtaria faixa : values()) {
			if (faixa.getLabel().equals(label)) {
				return faixa;
			}
		}
		return null;
	}

	public String getLabel() {
		return label;
	}
}
