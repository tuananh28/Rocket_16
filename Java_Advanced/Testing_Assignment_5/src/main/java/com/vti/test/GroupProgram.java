package com.vti.test;

import java.util.List;

import com.vti.entity.Group;
import com.vti.repository.GroupRepository;

public class GroupProgram {
	public static void main(String[] args) {
		GroupRepository repository = new GroupRepository();
		System.out.println("---------------- GET ALL GroupS ----------------");
		List<Group> list = repository.getAllGroups();
		for (Group Group : list) {
			System.out.println(Group);
		}
//		System.out.println("---------------- CREATE GroupS -----------------");
//		Group Group= new Group();
//		Group.setEmail("tuananh@gmail.com");
//		Group.setUserName("tuananhbui");
//		Group.setFirstName("Bùi");
//		Group.setLastName("Tuấn Anh");
//		Group.setCreateDate(null);
//		repository.createGroup(Group);
	}
}
