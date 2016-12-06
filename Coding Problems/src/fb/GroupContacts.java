package fb;

import java.util.*;

public class GroupContacts {
	
	class UnionFind{
		int[] ids;
		int[] size;
		int count;
		UnionFind(int n){
			ids = new int[n];
			size = new int[n];
			count = 0;
			for(int i = 0; i < n; i++){
				ids[i] = i;
			}
		}
		
		public int root(int x){
			while(ids[x] != x){
				ids[x] = ids[ids[x]];
				x = ids[x];
			}
			return x;
		}
		
		public int add(int x){
			size[x] = 1;
			count++;
			return x;
		}
		
		public void union(int x, int y){
			x = root(x);
			y = root(y);
			if(x == y) return;
			if(size[x] > size[y]){
				ids[y] = x;
				size[x] += size[y];
			}else{
				ids[x] = y;
				size[y] += size[y];
			}
			count--;
		}
	}
	
	static class Contact{
		String name;
		List<String> emails;
		public Contact(String name, List<String> emails){
			this.name = name;
			this.emails = emails;
		}
	}
	
	public List<List<Integer>> groupContacts(List<Contact> contacts){
		// key: email  value: people
		Map<String, List<Integer>> records = new HashMap<>();
		int n = contacts.size();
		for(int i = 0; i < n; i++){
			for(String email : contacts.get(i).emails){
				List<Integer> list = records.get(email);
				if(list == null){
					list = new ArrayList<>();
				}
				list.add(i);
				records.put(email, list);
			}
		}
		UnionFind uf = new UnionFind(n);
		for(String email : records.keySet()){
			List list = records.get(email);
			for(int i = 0; i < list.size() - 1; i++){
				uf.union((int)list.get(i), (int)(list.get(i + 1)));
			}
		}
		
		//key: contactId, value: other Ids of same contact
		Map<Integer, List<Integer>> groups = new HashMap<>();
		for(int i = 0; i < n; i++){
			int id = uf.root(i);
			List<Integer> list = groups.get(id);
			if(list == null) list = new ArrayList<>();
			list.add(i);
			groups.put(id, list);
		}
		List<List<Integer>> res = new ArrayList<>();
		for(List list : groups.values()){
			res.add(list);
		}
		System.out.println(res);
		return res;
	}
	
	public static void main(String[] args){
		List<Contact> contacts = new ArrayList<>();
		contacts.add(new GroupContacts.Contact("John", Arrays.asList("john@gmail.com")));
		contacts.add(new GroupContacts.Contact("Mary", Arrays.asList("mary@gmail.com")));
		contacts.add(new GroupContacts.Contact("John", Arrays.asList("john@yahoo.com")));
		contacts.add(new GroupContacts.Contact("John", Arrays.asList("john@gmail.com", "john@yahoo.com", "john@hotmail.com")));
		contacts.add(new GroupContacts.Contact("Bob", Arrays.asList("bob@gmail.com")));
		GroupContacts gc = new GroupContacts();
		gc.groupContacts(contacts);
	}
}
