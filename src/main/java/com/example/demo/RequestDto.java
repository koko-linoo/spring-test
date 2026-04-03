package com.example.demo;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestDto {
  @Schema(example = "{\n" + //
      "  \"users\": [\n" + //
      "    { \"id\": 1, \"name\": \"John Doe\", \"email\": \"john@example.com\" },\n" + //
      "    { \"id\": 2, \"name\": \"Bob Smith\", \"email\": \"bob_new@example.com\" },\n" + //
      "    { \"name\": \"New User\", \"email\": \"new@example.com\" }\n" + //
      "  ]\n" + //
      "}", description = "Users")
  private List<User> users;
}
