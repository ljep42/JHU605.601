package game;

import java.util.UUID;


public class Card {
    private String name;
    private String type;
    private UUID uuid;

    public Card(String name, String type) {
        this.name = name;
        this.type = type;
        uuid = UUID.randomUUID();
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public UUID getUUID() {
        return uuid;
    }
}
