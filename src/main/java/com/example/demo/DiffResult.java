package com.example.demo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DiffResult {
  private User user;
  private ActionType action;

  public DiffResult(User user, ActionType action) {
    this.user = user;
    this.action = action;
  }
}