package dao;

import entity.Contact;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.List;

/**
 * Created by vbirds on 17-4-10.
 */
public interface ContactDao {
    /**
     * 查询所有联系人
     * @return
     */
    public List<Contact> findAll();

    /**
     * 根据id查找联系人
     * @param id
     * @return
     */
    public Contact findById(String id);

    /**
     * 添加联系人
     * @param contact
     */
    public void addContact(Contact contact);

    /**
     * 更新联系人
     */
    public void updateContact();

    /**
     * 删除联系人
     */
    public void deleteContact(String id);

}
