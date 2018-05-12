package avoid_unnecessary_objects;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Adapter {
  private final HashMap<Integer, String> backingObject =
      new HashMap<>(
          Stream.of(
                  new AbstractMap.SimpleEntry<>(0, "Thanos"),
                  new AbstractMap.SimpleEntry<>(1, "Thor"),
                  new AbstractMap.SimpleEntry<>(2, "Star Lord"),
                  new AbstractMap.SimpleEntry<>(3, "Doctor Strange"),
                  new AbstractMap.SimpleEntry<>(4, "Rocket"),
                  new AbstractMap.SimpleEntry<>(5, "Gamora"))
              .collect(Collectors.toMap(AbstractMap.SimpleEntry::getKey, AbstractMap.SimpleEntry::getValue)));

  public Set getKeys() {
    return this.backingObject.keySet();
  }

  public void addHero() {
    if(this.backingObject.size() < 7) {
      backingObject.put(6, "Loki");
    }
  }
}
