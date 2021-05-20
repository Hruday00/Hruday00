import java.util.*;

public class CountryMap {
private HashMap<String,String> m1;
public CountryMap() {
	m1=new HashMap<String,String>();
}
public HashMap<String,String> storeCountryCapital(String CountryName,String Capital){
	m1.put(CountryName, Capital);
	return m1;
}
String retriveCapital(String CountryName) {
return m1.get(CountryName);	
}
String retriveCountry(String CapitalName) {
retrive m1.get(CapitalName);
}
public HashMap swap() {
	HashMap m2=new HashMap();
	Set s=m1.entrySet();
	Iterator i=s.iterator();
	while(i.hasNext()) {
		Map.Entry e=(Entry) i.next();
		m2.put(e.getValue(),e.getKey());
	}
return m2;	
}
public List array() {
List l=new ArrayList();
Set s=m1.entrySet();
Iterator i=s.iterator();
while(i.hasNext()) {
	Map.Entry e=(Entry) i.next();
	l.add(e.getKey());
	}
return l;
}
public static void main(String[] args) {
	CountryMap m=new CountryMap();
	m.storeCountryCapital("india","delhi");
	m.storeCountryCapital("japan","tokyo");
	System.out.println(m.retriveCapital("india"));
	System.out.println(m.retriveCountry("tokyo"));
	System.out.println(m.array());
	HashMap w=m.swap();
	System.out.println(w);
}
}