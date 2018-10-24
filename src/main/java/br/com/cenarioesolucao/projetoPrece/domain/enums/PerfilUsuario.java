package br.com.cenarioesolucao.projetoPrece.domain.enums;

public enum PerfilUsuario {

	ADMIN(1, "ROLE_ADMIN"),
	USUARIO(2, "ROLE_USUARIO");
	
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
	private PerfilUsuario(Integer codigo, String descricao) {
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
	public static PerfilUsuario toEnum(Integer codigo) {
		if (codigo == null) {
			return null;
		}
		
		for (PerfilUsuario x : PerfilUsuario.values()) {
			if (codigo.equals(x.getCodigo())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + codigo);
	}
}
