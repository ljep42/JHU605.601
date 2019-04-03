package game;

import java.net.Socket;
import java.util.ArrayList;
import java.util.UUID;


public class Player {
    private Socket client;
    private String character;
    private boolean out;
    private ArrayList<Card> cards = new ArrayList<Card>();
    private UUID uuid;
    private boolean turn = false;

    public Player(Socket client) {
        this.client = client;
        out = false;
        uuid = UUID.randomUUID();
    }

    public void out() {
        out = true;
    }

    public boolean inPlay() {
        return !out;
    }

    public void setName(String name) {
        character = name;
    }

    public String getName() {
        return character;
    }

    public Socket getClient() {
        return client;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void insertCard(Card card) {
        cards.add(card);
    }

    public boolean turn() {
        return turn;
    }

    public void setTurn(boolean turn) {
        this.turn = turn;
    }

}
