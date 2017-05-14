package SpyAgency;

public class EnemySiteDimensions {
	private int siteRows,siteColumns;
	private Position docPosition;
	public EnemySiteDimensions(int siteRows,int siteColumns,Position docPosition){
		this.siteRows=siteRows;
		this.siteColumns=siteColumns;
		this.docPosition=docPosition;
	}
	
	public boolean checkValidDimension(int currentX,int currentY) {
		if(currentX<=siteColumns&&currentY<=siteRows)return true;
		else return false;
	}
	
	public boolean checkSuccess(char[][] fromEnemySite) {
		return docPosition.checkSuccess(fromEnemySite);
	}
	
	public void display(char[][] fromEnemySite) {
		for(int i=siteRows-1;i>=0;i--) {
			for(int j=0;j<siteColumns;j++) {				
				System.out.print(fromEnemySite[i][j]+" ");
			}
		System.out.println();
		}
	}
	
	public char[][] setInitialValues(char[][] fromEnemySite){
		fromEnemySite=new char[siteRows][siteColumns];
		for(int i=siteRows-1;i>=0;i--) {
			for(int j=0;j<siteColumns;j++) {
				fromEnemySite[i][j]	='O';
			}
		}
		try {
			fromEnemySite=docPosition.setInsectPosition(fromEnemySite, 'X');
		}catch(ArrayIndexOutOfBoundsException e) {System.out.println("Exception Occurred: "+e);}
		return fromEnemySite;
	}
}
