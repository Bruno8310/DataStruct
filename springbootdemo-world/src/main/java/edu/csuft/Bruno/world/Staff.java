package edu.csuft.Bruno.world;


public class Staff {

	//int id;
	String user;
	int age;
	String gender;
	
	public Staff() {
	}

//	public int getId() {
//		return id;
//	}

//	public void setId(int id) {
//		this.id = id;
//	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Staff [user=" + user + ", age=" + age + ", gender=" + gender + "]";
	}
	
	
}
