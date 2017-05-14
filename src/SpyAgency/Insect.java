package SpyAgency;

public class Insect {
	private String insectName;
	private Position position;
	public Insect(String insectName,int x,int y,char direction){
		this.insectName=insectName;	
		position =new Position(x,y,direction);
	}
	
	public void displayInsectName() {
		System.out.print(insectName+" ");
	}
	
	public char getFirstChar() {
		return insectName.charAt(0);
	}
	public void setInsectName(String insectName) {
		this.insectName=insectName;
	}
	
	public Position getPosition() {
		return position;
	}
}
