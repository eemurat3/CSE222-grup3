package users;

import java.util.Objects;

/**
 *
 * @author Muhammed Akif Sevilgen
 */
public abstract class User implements Comparable<User>
{
	private String name;
	private String surname;
	private String id;
	private int age;

	public User(String name, String surname, String id, int age) {
        setName(name);
        setSurname(surname);
        setId(id);
        setAge(age);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public int compareTo(User other){
        return getId().compareTo(other.getId());
    }
   
    @Override
    public String toString() {
        StringBuilder strB = new StringBuilder();
        strB.append("Name: ").append(getName());
        strB.append(", Surname: ").append(getSurname());
        strB.append(", Id: ").append(getId());
        strB.append(", Age: ").append(getAge());
        return strB.toString();
    }
}
