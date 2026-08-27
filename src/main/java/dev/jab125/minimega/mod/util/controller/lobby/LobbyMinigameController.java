package dev.jab125.minimega.mod.util.controller.lobby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LobbyMinigameController {

   static class BallotBox<T>
   {
     public final Map<UUID, T> playerVotes = new ConcurrentHashMap<>(); public final List<T> entries;
     volatile T winner;
     
     BallotBox(List<T> entries) {
       this.entries = entries;
     }
     
     public void vote(UUID uuid, T t) {
       if (!this.entries.contains(t))
         return;  this.playerVotes.put(uuid, t);
     }
     
     public void retractVote(UUID uuid) {
       this.playerVotes.remove(uuid);
     }
     
     public boolean setup() {
       return true;
     }
   
     
     public T winner() {
       if (this.winner != null) return this.winner; 
       Map<T, List<UUID>> results = new HashMap<>();
      this.entries.forEach(f -> results.computeIfAbsent(f, ignored -> new ArrayList<>()));
       this.playerVotes.forEach((k, v) -> { if (v != null)
               ((List<UUID>)results.get(v)).add(k);  }); return this
   
   
   
   
   
         
         .winner = ((Map)results.entrySet().stream().collect(Collectors.groupingBy(e -> Integer.valueOf(((List)e.getValue()).size())))).entrySet().stream().max(Map.Entry.comparingByKey()).stream().flatMap(e -> ((List)e.getValue()).stream()).map(Map.Entry::getKey).collect(Collectors.collectingAndThen(
             Collectors.toList(), list -> list.get(ThreadLocalRandom.current().nextInt(list.size()))));
     }
   }
}
