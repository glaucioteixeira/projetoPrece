package br.com.cenarioesolucao.projetoPrece.domain.enums;

public enum TipoUsuario {

	PESSOAFISICA(1, "Pessoa Física"),
	PESSOAJURIDICA(2, "Pessoa Jurídica");
	
	/**
	 * Atributos
	 */
	private Integer codigo;
	private String descricao;
	
	
	/**
	 * Construtores
	 * @param codigo
	 * @param descricao
	 */
	private TipoUsuario(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	/**
	 * Getters and setters
	 * @return
	 */
	public Integer getCodigo() {
		return codigo;
	}

	public String getDescricao() {
		return descricao;
	}
	
	/**
	 * Metodos :: Converte o codigo para um objeto do tipo
	 * @param codigo
	 * @return
	 */
	public static TipoUsuario toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (TipoUsuario x : TipoUsuario.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
