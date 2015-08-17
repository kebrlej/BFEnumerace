import java.util.ArrayList;
import java.util.List;


public class Range {
	
	
	private long[] masky = new long[52];
	
	long [] range = new long[52];
	private long vymazKarty = Long.MAX_VALUE;
	
	//List<Group> range = new ArrayList<Group>();
	
	
	public static void main(String[] args) {
		Range r = new Range();
		r.odeberKartu(10);
		r.odeberKartu(0);
		r.odeberKartu(51);
	
	}
	
	
	public void odeberKartu(int hodnota){
	
		//vymazani z radku
		range[hodnota] = range[hodnota] & vymazKarty;
		
		//vymazani ze sloupce
		for (int i = 0; i < range.length; i++) {
			range[i] = range[i] & masky[hodnota];
		}
		vypisPole(range);
	}
	
	public void vlozKartu(int hodnota){
		
	}
	
	public void vypisPole(long [] pole){
		System.out.println();
		for (int i = 0; i < pole.length; i++) {
			//System.out.println(Long.toBinaryString(pole[i]));
			vypis(pole[i]);
		}
		
	}
	
	public void vypis(long cislo){
		long maska = 1;
		
		for (int i = 0; i < 64; i++) {
			if( (cislo & maska) ==1){
				System.out.print(1);
				
			}else{
				System.out.print(0);
			}
			cislo = cislo >>1;
		}
		System.out.println();
	}
	
	
	
	
	
	
	public Range() {
		// vytvor masky a inicializuj
		//vypis(2);
		for (int i = 0; i < masky.length; i++) {
			masky[i] = Long.MAX_VALUE;
			masky[i] = masky[i]<<1;
			for (int j = 0; j <i; j++) {
				
				masky[i] = (masky[i] << 1)+1;
				
				
			}
			range[i] = Long.MAX_VALUE;
			range[i] = range[i] & masky[i];
			vypis(masky[i]);
		}
		
		vymazKarty = vymazKarty<< 52;
		//vypis(vymazKarty);
		
		
	}

}
