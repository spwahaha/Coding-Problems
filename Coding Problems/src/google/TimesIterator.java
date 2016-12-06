package google;

import java.util.*;

public class TimesIterator implements Iterator<Integer>{
	
	List<Integer> list;
	int counter;
	Integer num;
	
	public TimesIterator(List<Integer> list){
		this.list = list;
		setCounter();
	}
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return counter != 0;
	}

	private void setCounter(){
		if( this.counter != 0) return;
		if(list.size() == 0) return;
		while(list.size() > 0 && counter == 0){
			counter = (int) list.get(0);
			list.remove(0);
			num = list.get(0);
			list.remove(0);
		}
	}
	
	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		int val = num;
		counter--;
		setCounter();
		return val;
	}
	
	public static void main(String[] args){
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(3, 8, 0, 12, 2, 9));
		TimesIterator it = new TimesIterator(list);
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
	
	
}
