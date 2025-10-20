package com.empresa.inventoryapi.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "ESTOQUES", uniqueConstraints = { @UniqueConstraint(columnNames = { "PRODUTO_ID", "LOCALIZACAO_ID" }) })
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estoque {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estoque_seq")
	@SequenceGenerator(name = "estoque_seq", sequenceName = "ESTOQUE_SEQ", allocationSize = 1)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PRODUTO_ID", nullable = false)
	private Produto produto;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOCALIZACAO_ID", nullable = false)
	private Localizacao localizacao;

	@Column(name = "QUANTIDADE", nullable = false)
	private Integer quantidade;
	@Column(name = "ULTIMA_ATUALIZACAO")
	private LocalDateTime ultimaAtualizacao;

	@PrePersist
	public void prePersist() {
		this.ultimaAtualizacao = LocalDateTime.now();
	}
}