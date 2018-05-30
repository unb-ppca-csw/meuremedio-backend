package br.net.meuremedio.domain.enumeration;

public enum Sexo {
	MASCULINO("Masculino"), 
	FEMININO("Feminino");

	private String label;

	private Sexo(String label) {
		this.label = label;
	}

	public static Sexo fromLabel(String label) {
		for (Sexo sexo : values()) {
			if (sexo.getLabel().equals(label)) {
				return sexo;
			}
		}
		return null;
	}

	public String getLabel() {
		return label;
	}
}
