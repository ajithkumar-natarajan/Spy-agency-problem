package SpyAgency;

public class Position {
	private int x,y;
	private char direction;
	public Position(int x,int y,char direction){
		this.x=x;
		this.y=y;
		this.direction=direction;
	}
	
	public void turnRight(Insect in) {
		switch(in.getPosition().direction) {
		case 'N': in.getPosition().direction='E';break;
		case 'E': in.getPosition().direction='S';break;
		case 'S': in.getPosition().direction='W';break;
		case 'W': in.getPosition().direction='N';break;
		}
	}
	
	public void turnLeft(Insect in) {
		switch(in.getPosition().direction) {
		case 'N': in.getPosition().direction='W';break;
		case 'E': in.getPosition().direction='N';break;
		case 'S': in.getPosition().direction='E';break;
		case 'W': in.getPosition().direction='S';break;
		}
	}
	
	public void moveForward(Insect in,EnemySite t) {
		switch(in.getPosition().direction) {
		case 'N':if(t.checkPosValid(in.getPosition().x,in.getPosition().y+1,in))in.getPosition().y++;break;
		case 'S':if(t.checkPosValid(in.getPosition().x,in.getPosition().y-1,in))in.getPosition().y--;break;
		case 'W':if(t.checkPosValid(in.getPosition().x-1,in.getPosition().y,in))in.getPosition().x--;break;
		case 'E':if(t.checkPosValid(in.getPosition().x+1,in.getPosition().y,in))in.getPosition().x++;break;
		}
	}
	
	public void displayInsectValues() {
		System.out.print(x+" "+y+" "+direction+'\n');
	}
	
	public boolean checkSuccess(char[][] fromEnemySite) {
		if(fromEnemySite[y-1][x-1]!='X')
			return true;
		else return false;
	}
	
	public char[][] setInsectPosition(char[][] fromEnemySite,char c) throws ArrayIndexOutOfBoundsException{
		fromEnemySite[y-1][x-1]=c;
		return fromEnemySite;
	}
}
