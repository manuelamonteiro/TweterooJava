package com.tweteroo.api.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data // getters e setters
@AllArgsConstructor
public class UserDTO {

	@NotBlank
	@Size(max = 150, message = "Maximum length for name is 150 characters!")
	private String username;

	@NotBlank
	private String avatar;
}
