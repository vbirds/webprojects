package entity;

/**
 * Created by vbirds on 17-4-10.
 */
public class Contact {
    private String id;
    private String name;
    private String gender;
    private String age;
    private String qq;
    private String phone;
    private String email;

    public Contact(String id, String name, String gender, String age, String qq, String phone, String email) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.age = age;
        this.qq = qq;
        this.phone = phone;
        this.email = email;
    }

    public Contact() {}

    @Override
    public String toString() {
        return "Contact{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + gender + '\'' +
                ", age='" + age + '\'' +
                ", qq='" + qq + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String sex) {
        this.gender = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
