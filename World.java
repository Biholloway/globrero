package world;



import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.Color;
import main.GameState;
import main.Player;

public class World {

	public GameCamera cam;
	//Player p = new Player();
	Vector2f pos;
	Tile tile;
	int index;
	Player p;
	GameState gameState;
	Image image;
	

	
	public World(GameCamera cam, float x, float y, GameState gameState){
		
		index = 0;
		this.cam = cam;
		pos = new Vector2f(x,y);
		this.gameState = gameState;
		p = new Player(gameState);
	}
	
	public void init(){
		/**
		for (int i = 0; i<100; i++)
		{
			t[i] = new Tile();
		}
		**/
	}
	
	
	public void update(GameContainer gc){
		
		p.update(gc);
	}
	public void render(Graphics g, GameContainer gc){
		try {
			image = new Image("res/hud1.png",false,Image.FILTER_NEAREST);
			g.drawImage(image,286,696);
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		p.render(g);
		genTileDisplay(g, p.getTileNum());
		
		
	}
	public void genTileDisplay(Graphics g, int tileNum)
	{
		Tile[] tiles = this.gameState.getTiles();
		if(tileNum > 0 && tileNum < tiles.length + 1) {
			Tile t = tiles[tileNum - 1]; //was tileNum - 1
		g.setColor(Color.white);
		g.fillRect(0, 0, 100, 40);
		g.setColor(Color.black);
		g.drawString("Tile: " + tileNum, 0, 0);
		g.drawString("ID: " + t.getId(), 0, 20);
		}
		
	}
	
}
