package SpyAgency;

import java.util.Scanner;

public class SpyAgency {
	private static Scanner sc=new Scanner(System.in);

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter the number of rows and columns on enemy site followed by position of Documents");
		EnemySite s=new EnemySite(new EnemySiteDimensions(sc.nextInt(),sc.nextInt(),new Position(sc.nextInt(),sc.nextInt(),'\u0000')));
		s.display();
		l:while(true) {
		System.out.println("Enter choice\n1.Add INsect\n2.Move Insect\n3.Rename Insect\n4.Remove Insect\n5.exit\n");	
		switch(sc.nextInt()) {
		case 1:
			s.addInsect();
			break;
		case 2:
			s.moveInsect();
			break;
		case 3:
			s.renameInsect();
			break;
		case 4:
			s.removeInsect();
			break;
		case 5:
			break l;
		default:
			System.out.println("Enter a valid choice");
		
		}
		s.display();
		if(s.checkSuccess()) {
			System.out.println("Mission Accomplished");
			break l;
		}
		}
	}

}
