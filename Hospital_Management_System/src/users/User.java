package users;

import java.util.Objects;

/**
 *
 * @author Muhammed Akif Sevilgen
 * User Class is the parent class for all workers and patients.
 */
public abstract class User implements Comparable<User>
{
	private String name;
	private String surname;
	private String id;
	private int age;

	// A constructor.
    public User(String name, String surname, String id, int age) {
        setName(name);
        setSurname(surname);
        setId(id);
        setAge(age);
    }

    /**
     * This function returns the name of the person
     * 
     * @return The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * This function sets the name of the object to the name passed in as a parameter
     * 
     * @param name The name of the parameter.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * This function returns the surname of the person
     * 
     * @return The surname of the person.
     */
    public String getSurname() {
        return surname;
    }

    /**
     * This function sets the surname of the person
     * 
     * @param surname The surname of the person
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * This function returns the id of the current object
     * 
     * @return The id of the object.
     */
    public String getId() {
        return id;
    }

    /**
     * This function sets the id of the object to the id passed in as a parameter
     * 
     * @param id The id of the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * This function returns the age of the person
     * 
     * @return The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * This function sets the age of the person to the value of the parameter age
     * 
     * @param age The age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }


    /**
     * If the object is the same object, return true. If the object is null, return false. If the
     * object is not the same class, return false. If the object's id is not the same, return false.
     * Otherwise, return true
     * 
     * @param obj The object to compare with.
     */
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

    /**
     * The compareTo() method compares the id of the current object with the id of the object passed as
     * an argument
     * 
     * @param other The other object to compare to.
     * @return The id of the user.
     */
    @Override
    public int compareTo(User other){
        return getId().compareTo(other.getId());
    }
   
    /**
     * The toString() method returns a string representation of the object
     * 
     * @return The toString() method is being returned.
     */
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
