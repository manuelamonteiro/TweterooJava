package com.tweteroo.api.models;

import com.tweteroo.api.dtos.UserDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Indica ao banco que isso é uma entidade a ser mapeada
@Table(name = "tb_users") // Permite escolher o nome da tabela
public class UserModel {

	public UserModel(UserDTO dto) {
		this.username = dto.getUsername();
		this.avatar = dto.getAvatar();
	}

	@Id // Identifica que é o id, a chave primária da tabela
	@GeneratedValue(strategy = GenerationType.SEQUENCE) // Estratégia gerar IDs
	private Long id;

	@Column(length = 100, nullable = false) // Coluna da tabela + constraints
	private String username;

	@Column(nullable = false)
	private String avatar;

}