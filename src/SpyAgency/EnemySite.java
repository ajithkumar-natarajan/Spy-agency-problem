package SpyAgency;
import java.util.*;

public class EnemySite {
	Scanner sc=new Scanner(System.in);
	private EnemySiteDimensions dimensions; 
	private char enemySite[][];
	private Map<String,Insect> m=new HashMap<String,Insect>();
	
	public EnemySite(EnemySiteDimensions dimensions) {
		this.dimensions=dimensions;
		enemySite=dimensions.setInitialValues(enemySite);
	}
	
	public boolean checkSuccess() {
		return dimensions.checkSuccess(enemySite);
	}
	
	private void addInsectByName(Insect in) {
		try {
			enemySite=in.getPosition().setInsectPosition(enemySite, in.getFirstChar());
		}catch(ArrayIndexOutOfBoundsException e) {System.out.println("Exception occurred: "+e);}
	}
	
	public void addInsect() {
		System.out.println("Enter insect name followed by its position and direction");
		String tempName=sc.next();
		m.put(tempName, new Insect(tempName,sc.nextInt(),sc.nextInt(),sc.next().charAt(0)));
		addInsectByName(m.get(tempName));
	}
	
	public void removeInsect() {
		System.out.println("Enter name of insect to remove");
		String n=sc.next();
		try {
		enemySite=m.get(n).getPosition().setInsectPosition(enemySite,'O');
		}catch(ArrayIndexOutOfBoundsException e) {System.out.println("Exception Occured: "+e);}
		m.remove(n);
	}
	
	public void moveInsect() {
		System.out.println("Enter the insect to move and the sequence");
		Insect in=m.get(sc.next());
		String s=sc.next();
		try {
		enemySite=in.getPosition().setInsectPosition(enemySite,'O');
		for(int i=0;i<s.length();i++) {
			switch(s.charAt(i)) {
			case 'L': in.getPosition().turnLeft(in);
			case 'R': in.getPosition().turnRight(in);
			case 'F': in.getPosition().moveForward(in,this);
			}
		}
		enemySite=in.getPosition().setInsectPosition(enemySite, in.getFirstChar());
		}catch(ArrayIndexOutOfBoundsException e) {System.out.println("Exception Occured: "+e);}
		in.displayInsectName();in.getPosition().displayInsectValues();
	}
	
	public void display() {
		dimensions.display(enemySite);
	}
	
	public void renameInsect() {
		System.out.println("Enter the insect name followed by new name");
		String old=sc.next();
		String neww=sc.next();
		m.get(old).setInsectName(neww);
		m.put(neww, m.get(old));
		addInsectByName(m.get(neww));
		m.remove(old);
	}
	
	public boolean checkPosValid(int currentPosX,int currentPosY,Insect in) {
		if(enemySite[currentPosY-1][currentPosX-1]!='O'&&enemySite[currentPosY-1][currentPosX-1]!='X'&&dimensions.checkValidDimension(currentPosX,currentPosY)){
			in.displayInsectName();
			System.out.println(" Invalid COmmand ");
			in.getPosition().displayInsectValues();
			return false;
		}else return true;
	}
}
