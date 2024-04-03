package com.tweteroo.api.models;

import com.tweteroo.api.dtos.TweetDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Indica ao banco que isso é uma entidade a ser mapeada
@Table(name = "tb_tweets") // Permite escolher o nome da tabela
public class TweetModel {

	public TweetModel(TweetDTO dto) {
		this.user = new UserModel();
		this.user.setId(dto.getUserId());
		this.text = dto.getText();
	}

	public TweetModel(TweetDTO dto, UserModel user) {
		this.user = user;
		this.text = dto.getText();
	}

	@Id // Identifica que é o id, a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Estratégia gerar IDs
	private Long id;

	@Column(length = 280, nullable = false) // Coluna da tabela + constraints
	private String text;

	@ManyToOne
	@JoinColumn(name = "userId")
	private UserModel user;
}
