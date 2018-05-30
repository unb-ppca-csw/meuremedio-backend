package br.net.meuremedio.domain.enumeration;

/**
 * The Tarja enumeration.
 */
public enum Tarja {
    VENDA_LIVRE("Venda Livre"), 
    TARJA_VERMELHA("Tarja Vermelha"), 
    TARJA_PRETA("Tarja Preta");
	
	private String label;
	
	private Tarja(String label) {
		this.label = label;
	}
	
	public static Tarja fromLabel(String label) {
		for(Tarja tarja: values()) {
			if(tarja.getLabel().equals(label)) {
				return tarja;
			}
		}
		return null;
	}
	
	public String getLabel() {
		return label;
	}
	
}
