package edu.java.contact.ver06;

import static edu.java.contact.ver06.Contact.Entity.*;

public interface ContactSql {

    // TODO: ContactDao.read() 메서드에서 사용할 SQL
    // select * from CONTACTS order by NAME
    String SQL_READ_ALL = String.format("select * from %s order by %s", TBL_CONTACTS, COL_NAME);

    // ContactDao.read(Integer cid) 메서드에서 사용할 SQL
    // select * from CONTACTS where CID = ? order by NAME
    String SQL_READ_BY_CID = String.format("select * from %s where %s = ? order by %s", TBL_CONTACTS, COL_CID,
            COL_NAME);

    // TODO: ContactDao.create(Contact contact) 메서드에서 사용할 SQL.
    String SQL_CREATE = String.format("insert into %s (%s, %s, %s) values (?, ?, ?)", TBL_CONTACTS, COL_NAME, COL_PHONE,
            COL_EMAIL);

    // TODO: ContactDao.update(Contact contact) 메서드에서 사용할 SQL.
    String SQL_UPDATE = String.format("update %s set %s = ?, %s = ?, %s = ? where %s = ?", TBL_CONTACTS, COL_NAME,
            COL_PHONE, COL_EMAIL, COL_CID);

    // TODO: ContactDao.delete(Integer cid) 메서드에서 사용할 SQL.
    String SQL_DELETE = String.format("delete from %s where %s = ?", TBL_CONTACTS, COL_CID);
    // delete from CONTACTS where CID = ?

    String SQL_SELECT_BY_KEYWORD = String.format(
            "select * from %s where lower(%s) like ? or lower(%s) like ? or lower(%s) like ? order by %s", TBL_CONTACTS,
            COL_NAME, COL_PHONE, COL_EMAIL, COL_NAME);
}
