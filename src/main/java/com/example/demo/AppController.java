package com.example.demo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app")
public class AppController {

  private final List<User> existingUsers = List.of(
      new User(1L, "John Doe", "john@example.com"),
      new User(2L, "Bob Smith", "bob@example.com"),
      new User(3L, "Alice Johnson", "alice@example.com"),
      new User(4L, "Sarah Williams", "sarah@example.com"));

  @PostMapping
  public List<DiffResult> postMethodName(@RequestBody RequestDto entity) {
    return compareTo(entity.getUsers());
  }

  public List<DiffResult> compareTo(List<User> requestUsers) {

    Map<Long, User> dbMap = existingUsers.stream()
        .collect(Collectors.toMap(User::getId, u -> u));

    List<DiffResult> results = new ArrayList<>();
    Set<Long> processedIds = new HashSet<>();

    for (User req : requestUsers) {

      if (req.getId() == null) {
        results.add(new DiffResult(req, ActionType.CREATE));
        continue;
      }

      User dbUser = dbMap.get(req.getId());

      if (dbUser == null) {
        results.add(new DiffResult(req, ActionType.CREATE));
      } else {
        processedIds.add(req.getId());

        if (req.isSame(dbUser)) {
          results.add(new DiffResult(req, ActionType.NO_ACTION));
        } else {
          results.add(new DiffResult(req, ActionType.UPDATE));
        }
      }
    }

    for (User dbUser : existingUsers) {
      if (!processedIds.contains(dbUser.getId())) {
        results.add(new DiffResult(dbUser, ActionType.DELETE));
      }
    }

    return results;
  }
}
