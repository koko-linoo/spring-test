package com.example.demo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Schema(description = "User entity")
@AllArgsConstructor
public class User {

  @Schema(example = "1", description = "User ID")
  private Long id;

  @Schema(example = "John Doe", description = "Full name of the user")
  private String name;

  @Schema(example = "john@example.com", description = "User email address")
  private String email;

  public boolean isSame(User other) {
    return this.name.equals(other.name)
        && this.email.equals(other.email);
  }
}