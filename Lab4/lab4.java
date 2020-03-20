import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.IntStream;

public class lab4 {

	public static void main(String[] args) {
		
		var r = IntStream.rangeClosed(0, 3)
				 .mapToObj(i -> new Resident("R" + i, i) )
				 .toArray(Resident[]::new);
		
		var h = IntStream.rangeClosed(0, 2)
				 .mapToObj(i -> new Hospital("H" + i, i+1) )
				 .toArray(Hospital[]::new);
		List<Resident> residentList = new ArrayList<>();
		Set<Hospital> hospitalList = new HashSet<>();
		
		for (Resident res : r) {
			 residentList.add(res);
			 System.out.println(res.getName());
			}
		
		for (Hospital hos : h) {
			hospitalList.add(hos);
			 System.out.println(hos.getName()+ " " + hos.getCapacity());
			}
		
		Map<Resident,List<Hospital>> resPrefMap = new HashMap();
		List<Hospital> prefList = new ArrayList<>();
		prefList.add(h[0]);
		prefList.add(h[1]);
		prefList.add(h[2]);
		
		resPrefMap.put(r[1], prefList);
		resPrefMap.put(r[0], prefList);
		resPrefMap.put(r[2], Arrays.asList(h[0], h[1]));
		resPrefMap.put(r[3], Arrays.asList(h[0], h[2]));
		
		
		System.out.println("Preferintele rezidentilor sunt:");
		for(int i=0; i<4;i++)
		{
			System.out.print(r[i].getName() + " : ");
			System.out.println(resPrefMap.get(r[i]));
		}
		Map<Hospital,List<Resident>> hosPrefMap = new HashMap();
		List<Resident> prefList1 = new ArrayList<>();
		hospitalList.addAll( Arrays.asList(h));
		hosPrefMap.put(h[0], Arrays.asList(r[3],r[0], r[1],r[2]));
		hosPrefMap.put(h[1], Arrays.asList(r[0], r[1],r[2]));
		hosPrefMap.put(h[2], Arrays.asList(r[0], r[1],r[3]));
		
		System.out.println("Preferintele spitalelor sunt:");
		
			System.out.print(h[0].getName() + " : ");
			//System.out.println(hosPrefMap.get(h[i]));
			System.out.println(r[3].getName() +" " + r[0].getName()  +" " + r[1].getName()+" " +r[2].getName());
			
			System.out.print(h[1].getName() + " : ");
			System.out.println(r[0].getName()  +" " + r[1].getName()+" " +r[2].getName());
			
			System.out.print(h[2].getName() + " : ");
			System.out.println(r[0].getName()  +" " + r[1].getName()+" "+ r[3].getName());
		
			Comparator<Resident> com = new Comparator<Resident>()
			{
				public int compare(Resident r1, Resident r2)
				{
					if(r2.getPriority()<r1.getPriority())
						return 1;
					else 
						return -1;
				}
			};
			
			Collections.sort(residentList,
					 ((r1, r2) -> r1.getName().compareTo(r2.getName())));
			System.out.println();
			for (Resident res : r) {
				 System.out.print(res.getName() + " ");
				}
	}
}

 