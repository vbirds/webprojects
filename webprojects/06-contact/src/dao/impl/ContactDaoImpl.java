package dao.impl;

import com.sun.javaws.jnl.XMLUtils;
import dao.ContactDao;
import entity.Contact;
import org.dom4j.Element;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import util.XMLUtil;

import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by vbirds on 17-4-10.
 */
public class ContactDaoImpl implements ContactDao {

    private static List<Contact> contactList = new LinkedList<Contact>();
    private static AtomicBoolean loadAllFlag = new AtomicBoolean(false);

    static {
        loadAll();
    }


    private static void loadAll() {
        Document doc = XMLUtil.getDocument("./contact");
        if (doc != null) {
            List<Element> conList = (List<Element>) doc.selectNodes("//contact");
            for (Element elem : conList) {
                Contact c = new Contact();
                c.setId(elem.attributeValue("id"));
                c.setName(elem.attributeValue("name"));
                c.setGender(elem.attributeValue("gender"));
                c.setAge(elem.attributeValue("age"));
                c.setQq(elem.attributeValue("qq"));
                c.setEmail(elem.attributeValue("email"));
                c.setPhone(elem.attributeValue("phone"));
                contactList.add(c);
            }
            loadAllFlag.set(true);
        }
    }

    /**
     * 查询所有联系人
     * @return
     */
    public List<Contact> findAll() {
            if (loadAllFlag.get()) {
                return contactList;
            }
            synchronized (contactList) {
                contactList.clear();
                loadAll();
            }
            return contactList;
    }

    /**
     * 根据id查找联系人
     * @param id
     * @return
     */
    public Contact findById(String id) {
        for (Contact c : contactList) {
            if (c.getId().equals(id)) {
                return c;
            }
        }
        return null;
    }

    /**
     * 添加联系人
     * @param contact
     */
    public void addCOntact(Contact contact){
        File file = new File("./contact.xml");
        Document doc = null;
        Element rootElem = null;

        try {
            if (!file.exists()) {
                doc = (Document) DocumentHelper.createDocument();
                rootElem = doc.addElement("contactList");
            } else {
                doc = XMLUtil.getDocument("./contact.xml");
                rootElem = doc.getRootElement();
            }

            Element contactELem = rootElem.addElement("contact");
            /**
             * 由系统自动生成随机且唯一的ID值，赋值给联系人
             */
            String uuid = UUID.randomUUID().toString().replace("-","");

            contactELem.addAttribute("id", uuid);
            contactELem.addElement("name").setText(contact.getName());
            contactELem.addElement("gender").setText(contact.getGender());
            contactELem.addElement("age").setText(contact.getAge()+"");
            contactELem.addElement("phone").setText(contact.getPhone());
            contactELem.addElement("email").setText(contact.getEmail());
            contactELem.addElement("qq").setText(contact.getQq());

            XMLUtil.write2xml(doc);
        } catch (Exception e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }
    }

    /**
     * 更新联系人
     */
    public void updateContact() {
        Document doc = DocumentHelper.createDocument();
        Element rootElem = doc.addElement("contactList");

        for (Contact c : contactList) {
            Element elem = rootElem.addElement("contact");
            elem.addAttribute("id", c.getId());
            elem.addElement("name").setText(c.getName());
            elem.addElement("gender").setText(c.getGender());
            elem.addElement("age").setText(c.getAge());
            elem.addElement("qq").setText(c.getQq());
            elem.addElement("email").setText(c.getEmail());
            elem.addElement("phone").setText(c.getPhone());
        }
        XMLUtil.write2xml(doc);
    }

    /**
     * 删除联系人
     */
    public void deleteContact(String id) {
        for (Contact c : contactList) {
            if (c.getId().equals(id)) {
                contactList.remove(c);
                break;
            }
        }
    }

}
