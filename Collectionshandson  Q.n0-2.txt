import java.util.*;
public class HashMa {
static String country="Pakistan";
Set storeCountryName(String CountryName) {
	Set s=new HashSet();
	s.add("india");
	s.add("bangladesh");
	s.add("Australia");
	s.add("China");
	s.add("New Zeland");	
	return s;
}
Set retriveCountry(String CountryName) {
	Set s=new HashSet();
	s.addAll(storeCountryName(CountryName));
	if(s.contains(country)) {
		System.out.println(country);
	}
	else
		System.out.println("Null");
	return s;
}
public static void main(String[] args) {
	HashMa m=new HashMa();
	m.retriveCountry("india");
}
}
Output:-Null(because i passing country name as Pakistan which is not present in set)