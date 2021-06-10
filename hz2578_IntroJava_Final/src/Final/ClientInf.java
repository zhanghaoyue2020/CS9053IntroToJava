package Final;

public class ClientInf implements java.io.Serializable {
	GameData data;
	Integer scores;
	Integer client;
	public ClientInf(GameData data, Integer scores, Integer client) {
		super();
		this.data = data;
		this.scores = scores;
		this.client = client;
	}
	public GameData getData() {
		return data;
	}
	public Integer getScores() {
		return scores;
	}
	public Integer getClient() {
		return client;
	}
}